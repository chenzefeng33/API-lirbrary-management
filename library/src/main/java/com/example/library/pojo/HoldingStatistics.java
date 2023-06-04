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
@TableName("opening_statistics")
public class HoldingStatistics {
    @TableId(value = "library_id")
    private int libraryId;
    @TableId(value = "library_floor")
    private int libraryFloor;
    @TableId(value = "library_holding_name")
    private String libraryHoldingName;
    @TableId(value = "library_holding_RoomNo")
    private int libraryHoldingRoomno;
    @TableId(value = "book_id")
    private int bookId;
}
