package com.example.library.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("borrow")
public class BorrowBook {
    @MppMultiId
    @TableField(value = "user_id")
    private Integer userId;
    @MppMultiId
    @TableField(value = "book_id")
    private Integer bookId;
    private String reservationTime;
    private String state;
    private Integer waitingPosition;
    private Integer score;
}
