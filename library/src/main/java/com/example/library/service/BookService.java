package com.example.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

public interface BookService extends IService<Book>{
    public String getDescription(Integer book_id);
    public boolean updateQuantity(Integer book_id, Integer quantityNumber);
}
