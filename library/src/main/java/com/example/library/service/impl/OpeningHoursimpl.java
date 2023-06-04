package com.example.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library.dao.OpeningHoursDao;
import com.example.library.pojo.OpeningHours;
import com.example.library.service.OpeningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpeningHoursimpl extends ServiceImpl<OpeningHoursDao, OpeningHours> implements OpeningHoursService {
    @Autowired
    public OpeningHoursDao openingHoursDao;

    @Override
    public List<OpeningHours> getOpeningHours() {
        return openingHoursDao.getOpeningHours();
    }

    @Override
    public List<OpeningHours> getOpeningHoursByPointId(Integer service_point_id) {
        return openingHoursDao.getOpeningHoursByPointId(service_point_id);
    }
}
