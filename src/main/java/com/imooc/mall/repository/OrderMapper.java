package com.imooc.mall.repository;

import com.imooc.mall.domain.Order;
import com.imooc.mall.domain.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByUserIdAndOrderNo(Integer userId, Long orderNo);

    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllOrder();

    Order selectByOrderNo(Long orderNo);

    // 二期新增定时关单
    List<Order> selectOrderStatusByCreateTime(@Param("status") Integer status, @Param("date") String date);

    int closeOrderByOrderId(Integer id);
}