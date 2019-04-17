package com.imooc.mall.vo;

import lombok.Data;

/**
 * @author 宋艾衡
 * @date 2019/4/17 10:34
 * @desc
 */

@Data
public class ShippingVo {
    private String receiverName;

    private String receiverPhone;

    private String receiverMobile;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverZip;
}
