package com.example.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library.dao.HoldingStatisticsDao;
import com.example.library.pojo.HoldingStatistics;
import com.example.library.service.HoldingStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldingStatisticsServiceImpl extends ServiceImpl<HoldingStatisticsDao, HoldingStatistics> implements HoldingStatisticsService {
    @Autowired
    public HoldingStatisticsDao holdingStatisticsDao;

    @Override
    public List<HoldingStatistics> getHoldingStatistics() {
        return holdingStatisticsDao.getHoldingStatistics();
    }

    @Override
    public List<HoldingStatistics> getHoldingStatisticsByBookId(Integer book_id) {
        return holdingStatisticsDao.getHoldingStatisticsByBookId(book_id);
    }

    @Override
    public List<HoldingStatistics> getHoldingStatisticsByLibraryId(Integer library_id) {
        return holdingStatisticsDao.getHoldingStatisticsByLibraryId(library_id);
    }
}
