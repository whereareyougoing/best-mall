package com.imooc.mall.service.impl;

import com.imooc.mall.common.Const;
import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.common.TokenCache;
import com.imooc.mall.domain.User;
import com.imooc.mall.repository.UserMapper;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author 宋艾衡
 * @date 2019/3/29 18:55
 * @desc
 */

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse<User> login(String username, String password) {

        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("用户不存在");
        }

        String md5Password = MD5Util.MD5EncodingUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功",user);

    }


    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)) {
            if (Const.USERNAME.equals(type)) {
                int result = userMapper.checkUsername(str);
                if (result > 0) {
                    return ServerResponse.createByErrorMessage("用户名已经存在");
                }
            }
            if (Const.EMAIL.equals(type)) {
                int result = userMapper.checkEmail(str);
                if (result > 0) {
                    return ServerResponse.createByErrorMessage("邮箱已经存在");
                }
            }
        }else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<String> register(User user) {
        ServerResponse validResponse = checkValid(user.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        validResponse = checkValid(user.getEmail(), Const.EMAIL);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        user.setRole(Const.Role.ROLE_CUSTOMER);
        user.setPassword(MD5Util.MD5EncodingUtf8(user.getPassword()));
        int resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户注册失败");
        }
        return ServerResponse.createBySuccessMessage("用户注册成功");
    }

    @Override
    public ServerResponse<String> selectQuestion(String username) {
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }

        String question = userMapper.selectQuestionByUsername(username);
        if (StringUtils.isBlank(question)) {
            return ServerResponse.createByErrorMessage("找回密码问题为空");
        }
        return ServerResponse.createBySuccess(question);

    }

    @Override
    public ServerResponse<String> checkAnswer(String username, String question, String answer) {
        int result = userMapper.checkAnswer(username,question,answer);
        if (result >0 ){
            // 防止越权的安全问题，将一个随机的uuid放在本地内存的缓存中，修改密码的时候需要将返回的uuid再次带过来验证
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题答案错误");
    }

    @Override
    public ServerResponse<String> forgetResetPassword(String username, String newPassword, String forgetToken) {
        if (StringUtils.isBlank(forgetToken)) return ServerResponse.createByErrorMessage("修改密码需要token验证");
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (!validResponse.isSuccess()) return ServerResponse.createByErrorMessage("用户不存在");
        String cacheToken = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
        if (StringUtils.equals(forgetToken, cacheToken)) {
            String md5Password = MD5Util.MD5EncodingUtf8(newPassword);
            int result = userMapper.updatePasswordByUsername(username, md5Password);
            if (result > 0) {
                return ServerResponse.createBySuccess("修改密码成功");
            }
        }else return ServerResponse.createByErrorMessage("token错误，或者过期");
        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    @Override
    public ServerResponse<String> resetPassword(String oldPassword, String newPassword,User user) {
        int result = userMapper.checkPassword(MD5Util.MD5EncodingUtf8(oldPassword), user.getId());
        if (result == 0) return ServerResponse.createByErrorMessage("就密码错误");
        user.setPassword(MD5Util.MD5EncodingUtf8(newPassword));
        int updateResult = userMapper.updateByPrimaryKeySelective(user);
        if (updateResult > 0) return ServerResponse.createBySuccessMessage("密码更新成功");
        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    @Override
    public ServerResponse<User> updateInformation(User user) {
        ServerResponse response = this.checkValid(user.getEmail(), Const.EMAIL);
        if (!response.isSuccess()) return response;
        User userUpdate = new User();
        BeanUtils.copyProperties(user, userUpdate);
        int result = userMapper.updateByPrimaryKeySelective(userUpdate);
        if (result > 0) return ServerResponse.createBySuccessMessage("用户信息更新成功");
        return ServerResponse.createByErrorMessage("用户信息更新失败");
    }

    @Override
    public ServerResponse<User> getInformation(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) return ServerResponse.createByErrorMessage("找不到该用户");
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }


    // backend
    public ServerResponse checkAdminRole(User user){
        if (user != null && user.getRole().intValue() == Const.Role.ROLE_ADMIN) return ServerResponse.createBySuccess();
        return ServerResponse.createByError();
    }
}
