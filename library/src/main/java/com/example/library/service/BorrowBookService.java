package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.BorrowBook;

public interface BorrowBookService  extends IService<BorrowBook> {
    boolean returnBook(Integer user_id, Integer book_id);
    boolean borrowBook(Integer user_id, Integer book_id);
    boolean setScore(Integer user_id, Integer book_id, Integer score);
}
