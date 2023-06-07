package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.BorrowBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BorrowBookDao  extends BaseMapper<BorrowBook> {
    @Update("update borrow set status = '已归还' where book_id = #{book_id} and user_id = #{user_id}")
    public boolean returnBook( @Param("user_id") Integer user_id, @Param("book_id") Integer book_id);

    @Update("update borrow set status = '借阅中' where book_id = #{book_id} and user_id = #{user_id}")
    public boolean borrowBook(@Param("user_id") Integer user_id, @Param("book_id") Integer book_id);

    @Update("update borrow set score = #{score} where book_id = #{book_id} and user_id = #{user_id}")
    public boolean setScore(@Param("user_id") Integer user_id, @Param("book_id") Integer book_id, @Param("score") Integer score);
}
