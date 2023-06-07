package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * (Borrow)表数据库访问层
 *
 * @author hxy
 * @since 2023-06-06 09:40:34
 */
@Mapper
@Repository
public interface BorrowMapper  extends BaseMapper<Borrow> {
}

