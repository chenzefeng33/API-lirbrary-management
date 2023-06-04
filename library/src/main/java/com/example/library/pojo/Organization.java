package com.example.library.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @description: 实体类
 * @author: 陈泽锋
 * @date: 6-4
 */
@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("organization")
public class Organization {
    @TableId(value = "branch_id")
    private int branchId;
    private String branchName;
    private String branchFunctions;
    private String branchDirector;
    private int branchPhone;
    private String branchAddress;
}
