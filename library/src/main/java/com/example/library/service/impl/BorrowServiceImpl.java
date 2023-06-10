package com.example.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.library.dao.BookDao;
import com.example.library.dao.BorrowMapper;
import com.example.library.pojo.Book;
import com.example.library.pojo.Borrow;
import com.example.library.service.BookService;
import com.example.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Borrow)表服务实现类
 *
 * @author hxy
 * @since 2023-06-06 09:40:35
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookService bookService;
    
    /**
     * 获取全部列表
     *
     * @return 实例对象
     */
    @Override
    public List<Borrow> selectList(Borrow borrow) {
        QueryWrapper<Borrow> queryWrapper = new QueryWrapper<>(borrow);
        return borrowMapper.selectList(queryWrapper);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param  id
     * @return 实例对象
     */
    @Override
    public Borrow queryById( Integer id) {
        return borrowMapper.selectById(id);
    }

    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    @Override
    public int insert(Borrow borrow) {
        if(borrow.getBookId() == null )return -3;
        //判断库存是否为小于0
        QueryWrapper<Book> queryWrapper = new QueryWrapper();
        queryWrapper.eq("book_id",borrow.getBookId());
        queryWrapper.gt("quantity",0);
        //有库存并且没写预约时间
        if(bookDao.selectCount(queryWrapper)>0 && borrow.getReservationTime() ==null)return -1;
        //没有有库存并且写了预约时间
        if(bookDao.selectCount(queryWrapper)==0 && borrow.getReservationTime() !=null)return -2;
        if("待取书".equals(borrow.getStatus())){
            bookService.updateQuantity(borrow.getBookId(),-1);
        }
        if("排队中".equals(borrow.getStatus())){
            QueryWrapper<Borrow> wrapper = new QueryWrapper();
            wrapper.eq("book_id",borrow.getBookId());
            wrapper.eq("status","排队中");
            wrapper.orderByDesc("waiting_position");
            List<Borrow> borrows=borrowMapper.selectList(wrapper);
            borrow.setWaitingPosition(borrows !=null && borrows.size()>0 ? borrows.get(0).getWaitingPosition()+1:1);
        }
        //TODO 一个人只能借一本书
        return borrowMapper.insert(borrow);
    }

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    @Override
    public int updateById(Borrow borrow) {
        //带取书、排队中、借阅中、已归还
        if("已归还".equals(borrow.getStatus())){
            if(borrow.getBookId() == null )return -1;
            QueryWrapper<Borrow> queryWrapper = new QueryWrapper();
            queryWrapper.eq("book_id",borrow.getBookId());
            queryWrapper.eq("status","排队中");
            if(borrowMapper.selectCount(queryWrapper)>0){
                //有排队借阅人员,取序列
                QueryWrapper<Borrow> wrapper = new QueryWrapper();
                wrapper.eq("book_id",borrow.getBookId());
                wrapper.eq("status","排队中");
                wrapper.orderByAsc("waiting_position");
                List<Borrow> borrows=borrowMapper.selectList(wrapper);
                Borrow b=borrows.get(0);
                borrowMapper.updateById(Borrow.builder().id(b.getId()).status("待取书").reservationTime(new Date()).build());
            }else{
                //无排队借阅人员,直接释放库存+1
                bookService.updateQuantity(borrow.getBookId(),1);
            }
        }
        return borrowMapper.updateById(Borrow.builder().id(borrow.getId()).score(borrow.getScore()).reservationTime(borrow.getReservationTime()).status(borrow.getStatus()).build());
    }

    /**
     * 通过主键删除数据
     *
     * @param  id
     * @return 影响行数
     */
    @Override
    public int deleteById(Integer id ) {
        Borrow borrow=borrowMapper.selectById(id);
        if("待取书".equals(borrow.getStatus())){
            QueryWrapper<Borrow> queryWrapper = new QueryWrapper();
            queryWrapper.eq("book_id",borrow.getBookId());
            queryWrapper.eq("status","排队中");
            if(borrowMapper.selectCount(queryWrapper)>0){
                //有排队借阅人员,取序列
                QueryWrapper<Borrow> wrapper = new QueryWrapper();
                wrapper.eq("book_id",borrow.getBookId());
                wrapper.eq("status","排队中");
                wrapper.orderByAsc("waiting_position");
                List<Borrow> borrows=borrowMapper.selectList(wrapper);
                Borrow b=borrows.get(0);
                borrowMapper.updateById(Borrow.builder().id(b.getId()).status("带取书").reservationTime(new Date()).build());
            }else{
                //无排队借阅人员,直接释放库存+1
                bookService.updateQuantity(borrow.getBookId(),1);
            }
        }
        if("借阅中".equals(borrow.getStatus()) || "已归还".equals(borrow.getStatus())) return -1;
        return borrowMapper.deleteById(id);
    }
}

