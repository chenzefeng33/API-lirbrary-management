package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.dao 0.0.1
 */

@Mapper
public interface UserDao extends BaseMapper<User> {
    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     */
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);
}
