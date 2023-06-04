package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.LibraryInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: dao层
 * @author: 陈泽锋
 * @date: 6-2
 */
@Mapper
@Repository
public interface LibraryInformationDao extends BaseMapper<LibraryInformation> {
    @Select("select * from library_information")
    List<LibraryInformation> getLibraryInformation();

    @Select("select * from library_information where library_id = #{library_id}")
    List<LibraryInformation> getLibraryInformationByLibraryId(@Param("library_id") Integer library_id);
}