package com.imooc.mall.domain.test;

import java.io.*;

/**
 * @author 宋艾衡
 * @date 2019/4/11 18:31
 * @desc
 */
public class GetSet {

    private static File file = new File("");

    public static StringBuilder handle() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        while ((s = br.readLine())!=null){
            sb.append(s);
        }
        return sb;
    }

    public static void prient(String oldBean,String newBean) throws IOException {
        StringBuilder sb = handle();
        String[] words= sb.toString().split(",");
        for (String word : words) {
            String getSet = oldBean+".set"+word.substring(0,1).toUpperCase()+word.substring(1)+"("
                    +newBean+".get("+word.substring(0,1).toUpperCase()+word.substring(1)+"));";
            System.out.println(getSet);
        }
    }

}
