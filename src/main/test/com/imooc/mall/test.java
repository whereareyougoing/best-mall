package com.imooc.mall;

import com.imooc.mall.domain.Order;
import com.imooc.mall.domain.test.OrderDemo;
import com.imooc.mall.repository.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @author 宋艾衡
 * @date 2019/4/1 14:49
 * @desc
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class test {

    private static final Logger logger = LoggerFactory.getLogger(test.class);

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testCopy(){
        Order order = orderMapper.selectByPrimaryKey(103);
        OrderDemo orderDemo = new OrderDemo();
        BeanUtils.copyProperties(order,orderDemo);
        orderDemo.setShippingId(order.getShippingId().toString());
        System.out.println(orderDemo);
    }

    @Test
    public void testException(){
        try {
            // throw new Exception("异常测试");
            Assert.notNull(null,"不能为null");
        }catch (Exception e){
            logger.error("message:{},e:{}", "123123123", e);
            System.out.println("123123123===============123123");
        }
    }

}
