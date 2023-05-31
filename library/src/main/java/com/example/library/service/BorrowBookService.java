package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.Book;
import com.example.library.pojo.BorrowBook;
import org.apache.ibatis.annotations.Param;

public interface BorrowBookService  extends IService<BorrowBook> {
    public boolean returnBook(Integer user_id, Integer book_id);
    public boolean borrowBook(Integer user_id, Integer book_id);
    public boolean setScore(Integer user_id, Integer book_id, Integer score);
}
