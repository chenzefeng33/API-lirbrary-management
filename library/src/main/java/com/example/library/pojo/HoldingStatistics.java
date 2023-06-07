package com.example.library.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 实体类
 * @author: 陈泽锋
 * @date: 6-4
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("opening_statistics")
public class HoldingStatistics {
    @MppMultiId
    @TableField(value = "library_id")
    private int libraryId;

    @MppMultiId
    @TableField(value = "library_floor")
    private int libraryFloor;

    @MppMultiId
    @TableField(value = "library_holding_name")
    private String libraryHoldingName;

    @MppMultiId
    @TableField(value = "book_id")
    private int bookId;

    @TableField(value = "library_holding_RoomNo")
    private int libraryHoldingRoomno;
}
