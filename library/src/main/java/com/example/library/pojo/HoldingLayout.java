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
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("holding_layout")
public class HoldingLayout {
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
    @TableField(value = "library_holding_RoomNo")
    private int libraryHoldingRoomno;

    private String libraryHolding;
    private String libraryServe;
    private String libraryServeTime;
}
