package com.imooc.mall.service;

import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.domain.Shipping;

/**
 * @author 宋艾衡
 * @date 2019/4/17 11:23
 * @desc
 */
public interface IShippingService {


    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse del(Integer userId, Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse select(Integer userId, Integer shippingId);

    ServerResponse list(Integer userId, int pageNum, int pageSize);
}
