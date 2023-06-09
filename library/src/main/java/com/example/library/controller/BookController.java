package com.example.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.library.pojo.Book;
import com.example.library.util.R;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookService bookService;

    /**
     * 获取所有书籍
     * @return
     */
    @GetMapping
    public R books() {
        List<Book> list = bookService.list();

        if (list.isEmpty()){
            return R.error();
        }else {
            return R.ok().data("bookList", list);
        }
    }

    @GetMapping("/{book_id}")
    public R getDescription(@PathVariable("book_id") Integer book_id){
        String description = bookService.getDescription(book_id);

        if (description == null){
            return R.error();
        }else {
            return R.ok().data("description", description);
        }
    }

    @GetMapping("/search/{book_name}")
    public R searchBooks(@PathVariable("book_name") String book_name){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("book_name",   book_name);
        List<Book> list = bookService.list(wrapper);

        if (list.isEmpty()){
            return R.error();
        }else {
            return R.ok().data("bookList", list);
        }
    }
}
