package com.imooc.mall.repository;

import com.imooc.mall.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);

    User selectLogin(@Param("username") String username, @Param("password") String md5Password);

    Integer insertGenerator(User user);

    int checkEmail(@Param("email") String str);

    String selectQuestionByUsername(String username);

    int checkAnswer(String username, String question, String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("password") String md5Password);

    int checkPassword(@Param("password") String md5EncodingUtf8, @Param("id") Integer id);
}