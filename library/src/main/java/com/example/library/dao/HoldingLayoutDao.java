package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.HoldingLayout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: dao层
 * @author: 陈泽锋
 * @date: 6-4
 */
@Mapper
@Repository
public interface HoldingLayoutDao extends BaseMapper<HoldingLayout> {
    @Select("select * from holding_layout")
    List<HoldingLayout> getHoldingLayout();

    @Select("select * from holding_layout where library_id = #{library_id}")
    List<HoldingLayout> getHoldingLayoutByLibraryId(@Param("library_id") Integer library_id);
}
