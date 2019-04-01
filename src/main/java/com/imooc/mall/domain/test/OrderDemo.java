package com.imooc.mall.domain.test;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 宋艾衡
 * @date 2019/4/1 14:44
 * @desc
 */

@Data
public class OrderDemo {

    private Integer id;

    private Long orderNo;

    private Integer userId;

//    private Integer shippingId;
    private String shippingId;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;

    private Integer status;

    private Date paymentTime;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

}
