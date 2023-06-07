package com.example.library.controller;

import com.example.library.pojo.Borrow;
import com.example.library.util.R;
import com.example.library.service.BorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Borrow)表控制层
 *
 * @author hxy
 * @since 2023-06-06 09:40:35
 */
@Api(tags = "(Borrow)")
@RestController
@RequestMapping("/reserve")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    
    @ApiOperation(value = " 查询预约列表")
    @GetMapping("/list")
    public R selectList(Borrow borrow) {
        return R.ok().data("borrowList", borrowService.selectList(borrow));
    }
    
    @ApiOperation(value = "根据id查询预约明细 ")
    @PostMapping("/{id}")
    public R queryById(@PathVariable("id")  Integer id) {
        return  R.ok().data("borrow", borrowService.queryById(id));
    }
    
    @ApiOperation("新增保存预约")
    @PostMapping("/add")
    public R add(@RequestBody Borrow borrow) {
       int t =borrowService.insert(borrow);
        return t>0?R.ok():t==-1 ?R.error().message("有库存请预约"):t==-2?R.error().message("无库存请排队借阅"):R.error().message("新增失败");
    }
    
    @ApiOperation("修改保存")
    @PutMapping("/edit")
    public R update(@RequestBody Borrow borrow) {
        return borrowService.updateById(borrow)>0?R.ok():R.error().message("更新失败");
    }

    @ApiOperation("删除")
    @DeleteMapping("/remove/{id}")
    public R deleteById(@PathVariable("id")  Integer id) {
        return borrowService.deleteById(id)>0?R.ok():R.error().message("删除失败");
    }
}


