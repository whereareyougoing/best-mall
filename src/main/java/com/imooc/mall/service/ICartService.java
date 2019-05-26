package com.imooc.mall.service;

import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.vo.CartVo;

/**
 * @author 宋艾衡
 * @date 2019/4/12 17:12
 * @desc
 */
public interface ICartService {
    ServerResponse<CartVo> list(Integer userId);

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer userId, Integer productId,Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, int checked);

}
