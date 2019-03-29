package com.imooc.mall.service.impl;

import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.domain.User;
import com.imooc.mall.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author 宋艾衡
 * @date 2019/3/29 18:55
 * @desc
 */

@Service
public class UserServiceImpl implements IUserService{

    @Override
    public ServerResponse<User> login(String username, String password) {
        return null;
    }
}
