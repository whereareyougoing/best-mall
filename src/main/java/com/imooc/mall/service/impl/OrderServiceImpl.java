package com.imooc.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 宋艾衡
 * @date 2019/4/17 10:15
 * @desc
 */

@Service("iOrderService")
@Slf4j
public class OrderServiceImpl implements IOrderService {


    @Override
    public ServerResponse createOrder(Integer id, Integer shippingId) {
        return null;
    }

    @Override
    public ServerResponse<String> cancel(Integer id, Long orderNo) {
        return null;
    }

    @Override
    public ServerResponse getOrderCartProduct(Integer id) {
        return null;
    }

    @Override
    public ServerResponse<OrderVo> getOrderDetail(Integer id, Long orderNo) {
        return null;
    }

    @Override
    public ServerResponse<PageInfo> getOrderList(Integer id, int pageNum, int pageSize) {
        return null;
    }
}
