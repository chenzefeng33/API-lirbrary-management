package com.example.library.service;

import com.example.library.pojo.Borrow;

import java.util.List;

/**
 * (Borrow)表服务接口
 *
 * @author hxy
 * @since 2023-06-06 09:40:35
 */
public interface BorrowService {

     /**
     * 通过条件检索全部
     *
     * @return 实例对象
     */
    List<Borrow> selectList(Borrow borrow);
    
    /**
     * 通过ID查询单条数据
     *
     * @param  id
     * @return 实例对象
     */
    Borrow queryById(Integer id);
    
    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    int insert(Borrow borrow);

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    int updateById(Borrow borrow);

    /**
     * 通过主键删除数据
     *
     * @param  id
     * @return 是否成功
     */
    int deleteById( Integer id );
}

