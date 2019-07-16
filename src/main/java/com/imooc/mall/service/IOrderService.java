package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.vo.OrderVo;

/**
 * @author 宋艾衡
 * @date 2019/4/17 10:15
 * @desc
 */
public interface IOrderService {


    /**
     * 创建订单
     * @param id
     * @param shippingId
     * @return
     */
    ServerResponse createOrder(Integer id, Integer shippingId);

    /**
     * 删除
     * @param id
     * @param orderNo
     * @return
     */
    ServerResponse<String> cancel(Integer id, Long orderNo);

    /**
     * 获取订单购物车里的商品
     * @param id
     * @return
     */
    ServerResponse getOrderCartProduct(Integer id);

    /**
     * 查询订单详情
     * @param id
     * @param orderNo
     * @return
     */
    ServerResponse<OrderVo> getOrderDetail(Integer id, Long orderNo);

    /**
     * 查询订单列表
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getOrderList(Integer id, int pageNum, int pageSize);


    // 后台操作


    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);

    /**
     * 1 小时  未付款订单进行关闭
     * @param hour
     */
    void closeOrder(int hour);
}
