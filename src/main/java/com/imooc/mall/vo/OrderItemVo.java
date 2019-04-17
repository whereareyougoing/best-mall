package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 宋艾衡
 * @date 2019/4/17 10:32
 * @desc
 */

@Data
public class OrderItemVo {


    private Long orderNo;

    private Integer productId;

    private String productName;
    private String productImage;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private String createTime;

}
