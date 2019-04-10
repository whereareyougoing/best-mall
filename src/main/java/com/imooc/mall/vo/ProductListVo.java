package com.imooc.mall.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 宋艾衡
 * @date 2019/4/10 18:40
 * @desc
 */

@Data
@NoArgsConstructor
public class ProductListVo {

    private Integer id;
    private Integer categoryId;

    private String name;
    private String subtitle;
    private String mainImage;
    private BigDecimal price;

    private Integer status;

    private String imageHost;



}
