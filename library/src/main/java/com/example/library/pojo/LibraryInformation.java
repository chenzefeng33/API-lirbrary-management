package com.example.library.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;
import lombok.*;

/**
 * @description: 实体类
 * @author: 陈泽锋
 * @date: 6-2
 */
@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("library_information")
public class LibraryInformation {
    @TableId(value = "library_id")
    private int libraryId;
    private String libraryName;
    private String libraryIntroduction;
}
