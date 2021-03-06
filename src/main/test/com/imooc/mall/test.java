package com.imooc.mall;

import com.alibaba.fastjson.JSON;
import com.imooc.mall.domain.Order;
import com.imooc.mall.domain.User;
import com.imooc.mall.domain.test.OrderDemo;
import com.imooc.mall.repository.OrderMapper;
import com.imooc.mall.util.MD5Util;
import com.imooc.mall.repository.UserMapper;
import com.imooc.mall.util.PropertiesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    @Autowired
    private UserMapper userMapper;

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
            Assert.assertNotNull(null);
        }catch (Exception e){
            logger.error("message:{},e:{}", "123123123", e);
            System.out.println("123123123===============123123");
        }
    }


    @Test
    public void testMD5(){
        String password = "123456";
        String md5Password = MD5Util.MD5EncodingUtf8(password);
        System.out.println(md5Password);
    }

    @Test
    public void testPropertiesUtil(){
        String value = PropertiesUtil.getProperty("password.salt");
        System.out.println(value);
    }

    @Test
    public void testQueryUserById(){
        User user = userMapper.selectByPrimaryKey(1);
        Assert.assertNotNull("未找到用户",user);
        System.out.println(JSON.toJSON(user));

        String s = "427338237BD929443EC5D48E24FD2B1A";
    }

    @Test
    public void testInsertUser(){
        User user = userMapper.selectByPrimaryKey(1);
        User user1 = new User();
        BeanUtils.copyProperties(user,user1);
        user1.setId(22);
        user1.setUsername("123");
        user1.setPassword(MD5Util.MD5EncodingUtf8("123456"));
        int result = userMapper.insert(user1);
        Assert.assertNotEquals(0, result);
        System.out.println(result);
    }

}
