package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @description: dao层
 * @author: 肖景方
 * @date: 5-31
 * @version: v1.0
 */
@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {
    @Select("select description from book where book_id = #{book_id}")
    public String getDescription(@Param("book_id") Integer book_id);

    @Update("update book set quantity = quantity + #{quantityNumber} where book_id = #{book_id}")
    public boolean updateQuantity(@Param("book_id") Integer book_id, @Param("quantityNumber") Integer quantityNumber);
}
