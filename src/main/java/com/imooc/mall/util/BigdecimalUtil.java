package com.imooc.mall.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 宋艾衡
 * @date 2019-05-26 02:21
 */
public class BigdecimalUtil {

    public BigdecimalUtil() {
    }

    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }
    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }
    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, 2, RoundingMode.HALF_UP); // 四舍五入，保留两位小数
    }

}
