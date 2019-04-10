package com.imooc.mall.service;

import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.domain.User;

/**
 * @author 宋艾衡
 * @date 2019/3/29 18:42
 * @desc
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> register(User user);

    ServerResponse<String> selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String newPassword, String forgetToken);

    ServerResponse<String> resetPassword(String oldPassword, String newPassword,User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer id);

    ServerResponse checkAdminRole(User user);
}
