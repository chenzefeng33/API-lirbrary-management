package com.example.library.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @description: 实体类
 * @author: 肖景方
 * @date: 5-31
 */
@Component
@Setter
@Getter
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
    private String publish_date;
    private float price;
    private String description;
    private int total;
}
