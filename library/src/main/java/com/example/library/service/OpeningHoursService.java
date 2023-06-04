package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.OpeningHours;

import java.util.List;

public interface OpeningHoursService extends IService<OpeningHours> {
    List<OpeningHours> getOpeningHours();

    List<OpeningHours> getOpeningHoursByPointId(Integer service_point_id);
}
