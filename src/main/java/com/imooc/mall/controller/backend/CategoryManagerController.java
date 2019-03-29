package com.imooc.mall.controller.backend;

import com.imooc.mall.common.Const;
import com.imooc.mall.common.ResponseCode;
import com.imooc.mall.common.ServerResponse;
import com.imooc.mall.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author 宋艾衡
 * @date 2019/3/29 17:47
 * @desc
 */

@Controller
@RequestMapping("/manager/category")
public class CategoryManagerController {

    // 增加分类
    public ServerResponse<String> addCategory(HttpSession session,String catecoryName, @RequestParam(value = "parentId",defaultValue = "0") int parentId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getDesc());
        }
        return null;
    }


}
