package com.imooc.mall.service;

import com.imooc.mall.common.ServerResponse;

/**
 * @author 宋艾衡
 * @date 2019/4/10 16:32
 * @desc
 */
public interface ICategoryService {
    ServerResponse<String> addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse getChildrenParallelCategory(Integer categoryId);

    ServerResponse selectCategoryAndChildrenById(Integer categoryId);

}
