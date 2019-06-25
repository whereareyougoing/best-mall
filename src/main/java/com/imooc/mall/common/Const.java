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

    public enum ProductStatusEnum{
        ON_SALE(1,"在线"),
        OFF_SALE(2,"下线"),
        DELETED(3, "已删除");
        private String value;
        private int code;
        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public interface Cart{
        int CHECKED = 1;
        int UN_CHECKED = 0;

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }


    public static final String IMAGE_HOST_PREFIX =  "ftp.server.http.prefix";


}
