package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.Book;

public interface BookService extends IService<Book>{
    String getDescription(Integer book_id);
    boolean updateQuantity(Integer book_id, Integer quantityNumber);
}
