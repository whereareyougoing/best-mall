package com.imooc.mall.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author 宋艾衡
 * @date 2019/4/10 17:34
 * @desc
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDetailVo {

    private Integer  id;
    private Integer categoryId;
    private String name;
    private String subtitle;
    private String mainImage;
    private String subImages;
    private String detail;
    private BigDecimal price;
    private Integer stock;
    private Integer status;
    private String createTime;
    private String updateTime;


    private String imageHost;
    private Integer parentCategoryId;


}
