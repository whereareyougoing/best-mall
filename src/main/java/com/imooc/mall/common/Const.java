package com.imooc.mall.common;

import com.google.common.collect.Sets;
import java.util.Set;

/**
 * @author 宋艾衡
 * @date 2019/3/29 18:30
 * @desc
 */
public class Const {

    public static final String PROPERTIES_NAME = "mmall.properties";


    public static final String CURRENT_USER = "current_user";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";

    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }


    public interface Role{
        int ROLE_CUSTOMER = 0;
        int ROLE_ADMIN = 1;
    }


}
