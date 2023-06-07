package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.OpeningHours;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: dao层
 * @author: 陈泽锋
 * @date: 6-4
 */
@Mapper
public interface OpeningHoursDao extends BaseMapper<OpeningHours> {
    @Select("select * from opening_hours")
    List<OpeningHours> getOpeningHours();

    @Select("select * from opening_hours where service_point_id = #{service_point_id}")
    List<OpeningHours> getOpeningHoursByPointId(@Param("service_point_id") Integer service_point_id);
}
