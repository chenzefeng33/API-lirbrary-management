package com.example.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library.dao.BookDao;
import com.example.library.pojo.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceimpl  extends ServiceImpl<BookDao, Book> implements BookService {
    @Autowired
    public BookDao bookDao;

    @Override
    public String getDescription(Integer book_id) {
        String description = bookDao.getDescription(book_id);
        return description;
    }

    @Override
    public boolean updateQuantity(Integer book_id, Integer quantityNumber) {
        boolean tag = bookDao.updateQuantity(book_id, quantityNumber);
        return tag;
    }
}
