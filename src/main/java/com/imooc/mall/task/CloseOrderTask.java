package com.imooc.mall.task;

import com.imooc.mall.common.Const;
import com.imooc.mall.common.RedissonManager;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.util.PropertiesUtil;
import com.imooc.mall.util.RedisShardedPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 宋艾衡
 * 2019/7/16 14:11
 */

@Component
@Slf4j
public class CloseOrderTask {


    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private RedissonManager redissonManager;


    public void closeOrderTask(){

    }




    private void closeOrder(String lockName){
        RedisShardedPoolUtil.expire(lockName,5);//有效期50秒，防止死锁
        log.info("获取{},ThreadName:{}", Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK,Thread.currentThread().getName());
        int hour = Integer.parseInt(PropertiesUtil.getProperty("close.order.task.time.hour","2"));
        iOrderService.closeOrder(hour);
        RedisShardedPoolUtil.del(Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK);
        log.info("释放{},ThreadName:{}",Const.REDIS_LOCK.CLOSE_ORDER_TASK_LOCK,Thread.currentThread().getName());
        log.info("===============================");
    }

}
