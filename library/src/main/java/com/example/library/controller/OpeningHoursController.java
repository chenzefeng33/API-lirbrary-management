package com.example.library.controller;

import com.example.library.pojo.OpeningHours;
import com.example.library.service.OpeningHoursService;
import com.example.library.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/openinghours")
public class OpeningHoursController {

    @Autowired
    public OpeningHoursService openingHoursService;

    /**
     * 获取所有开闭关时间信息
     * @return
     */
    @GetMapping
    public R openinghours() {
        List<OpeningHours> list = openingHoursService.getOpeningHours();

        if(list.isEmpty()){
            return R.error();
        }else {
            return R.ok().data("openingHoursList",list);
        }
    }

    @GetMapping("/service_point_id={service_point_id}")
    public R openinghoursByPointId(@PathVariable("service_point_id") Integer service_point_id) {
        List<OpeningHours> list = openingHoursService.getOpeningHoursByPointId(service_point_id);

        if(list == null){
            return R.error();
        }else {
            return R.ok().data("openinghoursByPointId"+ service_point_id,list);
        }
    }
}
