package com.example.library.controller;

import com.example.library.pojo.HoldingStatistics;
import com.example.library.service.HoldingStatisticsService;
import com.example.library.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/holdingstatistics")
public class HoldingStatisticsController {

    @Autowired
    public HoldingStatisticsService holdingStatisticsService;

    /**
     * 获取所有馆藏统计信息
     * @return
     */
    @GetMapping
    public R holdingstatistics() {
        List<HoldingStatistics> list = holdingStatisticsService.getHoldingStatistics();

        if(list.isEmpty()){
            return R.error();
        }else {
            return R.ok().data("holdingStatisticsList",list);
        }
    }

    @GetMapping("book_id={book_id}")
    public R holdingstatisticsByBookId(@PathVariable("book_id") Integer book_id) {
        List<HoldingStatistics> list = holdingStatisticsService.getHoldingStatisticsByBookId(book_id);

        if(list == null){
            return R.error();
        }else {
            return R.ok().data("holdingstatisticsByBookId"+ book_id,list);
        }
    }

    @GetMapping("library_id={library_id}")
    public R holdingstatisticsByLibraryId(@PathVariable("library_id") Integer library_id) {
        List<HoldingStatistics> list = holdingStatisticsService.getHoldingStatisticsByLibraryId(library_id);

        if(list == null){
            return R.error();
        }else {
            return R.ok().data("holdingstatisticsByLibraryId"+ library_id,list);
        }
    }
}
