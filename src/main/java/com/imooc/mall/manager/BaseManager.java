package com.imooc.mall.manager;

import com.imooc.mall.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 宋艾衡
 * @date 2019/4/17 11:33
 * @desc
 */

public abstract class BaseManager {


    public Long insert(Object obj){
        return 1L;
    }

    public static Logger LOGGER = LoggerFactory.getLogger(BaseManager.class);


}
