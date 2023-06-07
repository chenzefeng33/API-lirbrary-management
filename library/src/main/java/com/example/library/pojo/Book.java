package com.example.library.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 实体类
 * @author: 肖景方
 * @date: 5-31
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book {
    @TableId(value = "book_id")
    private int bookId;

    private String bookName;

    private String author;

    private String publisher;

    private String publishDate;

    private float price;

    private String description;

    private int total;
}
