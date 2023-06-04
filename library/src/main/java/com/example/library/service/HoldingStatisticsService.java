package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.HoldingStatistics;

import java.util.List;

public interface HoldingStatisticsService extends IService<HoldingStatistics> {
    List<HoldingStatistics> getHoldingStatistics();

    List<HoldingStatistics> getHoldingStatisticsByBookId(Integer book_id);

    List<HoldingStatistics> getHoldingStatisticsByLibraryId(Integer library_id);
}
