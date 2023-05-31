package com.example.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library.dao.BookDao;
import com.example.library.dao.BorrowBookDao;
import com.example.library.pojo.BorrowBook;
import com.example.library.pojo.R;
import com.example.library.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookimpl extends ServiceImpl<BorrowBookDao, BorrowBook> implements BorrowBookService {
    @Autowired
    public BorrowBookDao borrowBookDao;
    @Autowired
    public BookDao bookDao;

    @Override
    public boolean returnBook(Integer user_id, Integer book_id) {
        boolean tag = borrowBookDao.returnBook(user_id, book_id);
        bookDao.updateQuantity(book_id, -1);
        return tag;
    }

    @Override
    public boolean borrowBook(Integer user_id, Integer book_id) {
        boolean tag = borrowBookDao.borrowBook(user_id, book_id);
        bookDao.updateQuantity(book_id, 1);
        return tag;
    }

    @Override
    public boolean setScore(Integer user_id, Integer book_id, Integer score) {
        boolean tag = borrowBookDao.setScore(user_id, book_id, score);
        return tag;
    }
}
