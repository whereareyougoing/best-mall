package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.vo.ProductDetailVo;

/**
 * @author 宋艾衡
 * @date 2019/4/10 17:32
 * @desc
 */
public interface IProductService {
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);

}