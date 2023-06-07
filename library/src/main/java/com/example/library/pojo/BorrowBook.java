package com.example.library.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName("borrow")
public class BorrowBook {
    @MppMultiId
    @TableId(value = "user_id")
    private int userId;
    @MppMultiId
    @TableId(value = "book_id")
    private int bookId;
    private String reservation_time;
    private String state;
    private int waiting_position;
    private int score;
}
