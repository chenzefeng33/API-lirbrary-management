package com.example.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library.dao.HoldingLayoutDao;
import com.example.library.pojo.HoldingLayout;
import com.example.library.service.HoldingLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldingLayoutServiceimpl extends ServiceImpl<HoldingLayoutDao, HoldingLayout> implements HoldingLayoutService {
    @Autowired
    public HoldingLayoutDao holdingLayoutDao;

    @Override
    public List<HoldingLayout> getHoldingLayout() {
        return holdingLayoutDao.getHoldingLayout();
    }

    @Override
    public List<HoldingLayout> getHoldingLayoutByLibraryId(Integer library_id) {
        return holdingLayoutDao.getHoldingLayoutByLibraryId(library_id);
    }
}
