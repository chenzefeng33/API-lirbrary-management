package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.HoldingStatistics;
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
public interface HoldingStatisticsDao extends BaseMapper<HoldingStatistics> {
    @Select("select * from holding_statistics")
    List<HoldingStatistics> getHoldingStatistics();

    @Select("select * from holding_statistics where book_id = #{book_id}")
    List<HoldingStatistics> getHoldingStatisticsByBookId(@Param("book_id") Integer book_id);

    @Select("select * from holding_statistics where library_id = #{library_id}")
    List<HoldingStatistics> getHoldingStatisticsByLibraryId(@Param("library_id") Integer library_id);
}
