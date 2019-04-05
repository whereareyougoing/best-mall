package com.imooc.mall.service.impl;

import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.domain.User;
import com.imooc.mall.repository.UserMapper;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//        int resultCount = userMapper.checkUsername(username);
//        if (resultCount == 0){
//            return ServerResponse.createByErrorMessage("用户不存在");
//        }
//
//        String md5Password = MD5Util.MD5EncodingUtf8(password);
//        User user = userMapper.selectLogin(username, md5Password);
//        if (user == null){
//            return ServerResponse.createByErrorMessage("密码错误");
//        }
//        user.setPassword(StringUtils.EMPTY);
//        return ServerResponse.createBySuccess("登陆成功",user);

        return null;
    }
}
