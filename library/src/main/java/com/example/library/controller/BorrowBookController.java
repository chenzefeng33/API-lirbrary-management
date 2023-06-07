package com.example.library.controller;

import com.example.library.service.BorrowBookService;
import com.example.library.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrowbooks")
public class BorrowBookController {

    @Autowired
    public BorrowBookService borrowBookService;

    @PutMapping("returns/{user_id}/{book_id}")
    public R returnBook(@PathVariable("user_id") Integer user_id, @PathVariable("book_id") Integer book_id) {
        boolean tag = borrowBookService.returnBook(user_id, book_id);
        if(tag) return R.ok();
        else return R.error().message("请确认归还书籍信息");
    }

    @PutMapping("borrowings/{user_id}/{book_id}")
    public R borrowBook(@PathVariable("user_id") Integer user_id, @PathVariable("book_id") Integer book_id){
        boolean tag = false;
//        try {
            tag = borrowBookService.borrowBook(user_id, book_id);
//        } catch (Exception DuplicateKeyException) {
//            return R.error().message("没有该用户或书籍");
//        }
        if(tag) return R.ok();
        else return R.error();
    }

    @PutMapping("/scores/{user_id}/{book_id}/{score}")
    public R setScore(@PathVariable("book_id") Integer book_id, @PathVariable("user_id") Integer user_id, @PathVariable("score") Integer score) {
        boolean tag = borrowBookService.setScore(user_id, book_id, score);
        if(tag) return R.ok();
        else return R.error().message("请确认打分书籍信息");
    }
}
