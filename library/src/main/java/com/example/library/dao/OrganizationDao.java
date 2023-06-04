package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.Organization;
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
public interface OrganizationDao extends BaseMapper<Organization> {
    @Select("select * from organization")
    List<Organization> getOrganizaiton();

    @Select("select * from organization where branch_id = #{branch_id}")
    List<Organization> getOrganizaitonByBranchId(@Param("branch_id") Integer branch_id);
}
