package com.example.library.controller;

import com.example.library.pojo.R;
import com.example.library.service.impl.BorrowBookimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrowbooks")
public class BorrowBookController {
    @Autowired
    public BorrowBookimpl borrowBookimpl;

    @PutMapping("returns/{user_id}/{book_id}")
    public R returnBook(@PathVariable("user_id") Integer user_id, @PathVariable("book_id") Integer book_id) {
        boolean tag = borrowBookimpl.returnBook(user_id, book_id);
        if(tag) return R.ok();
        else return R.error().message("请确认归还书籍信息");
    }

    @PutMapping("borrowings/{user_id}/{book_id}")
    public R borrowBook(@PathVariable("user_id") Integer user_id, @PathVariable("book_id") Integer book_id){
        boolean tag = false;
//        try {
            tag = borrowBookimpl.borrowBook(user_id, book_id);
//        } catch (Exception DuplicateKeyException) {
//            return R.error().message("没有该用户或书籍");
//        }
        if(tag) return R.ok();
        else return R.error();
    }

    @PutMapping("/scores/{user_id}/{book_id}/{score}")
    public R setScore(@PathVariable("book_id") Integer book_id, @PathVariable("user_id") Integer user_id, @PathVariable("score") Integer score) {
        boolean tag = borrowBookimpl.setScore(user_id, book_id, score);
        if(tag) return R.ok();
        else return R.error().message("请确认打分书籍信息");
    }
}
