package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.HoldingLayout;

import java.util.List;

public interface HoldingLayoutService extends IService<HoldingLayout> {
    List<HoldingLayout> getHoldingLayout();

    List<HoldingLayout> getHoldingLayoutByLibraryId(Integer library_id);
}
