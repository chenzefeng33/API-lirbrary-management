package com.example.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.library.pojo.Borrow;
import org.apache.ibatis.annotations.Mapper;


/**
 * (Borrow)表数据库访问层
 *
 * @author hxy
 * @since 2023-06-06 09:40:34
 */
@Mapper
public interface BorrowMapper  extends BaseMapper<Borrow> {
}

