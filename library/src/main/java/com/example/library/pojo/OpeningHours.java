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
@TableName("opening_hours")
public class OpeningHours {
    @TableId(value = "service_point_id")
    private int servicePointId;
    private String servicePointName;
    private String servicePointAddress;
    private int servicePointPhone;
    private String servicePointOpentime;
}
