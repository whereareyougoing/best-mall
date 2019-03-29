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

}
