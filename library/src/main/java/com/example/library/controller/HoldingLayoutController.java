package com.example.library.controller;

import com.example.library.pojo.HoldingLayout;
import com.example.library.pojo.R;
import com.example.library.service.impl.HoldingLayoutServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/holdinglayout")
public class HoldingLayoutController {
    @Autowired
    public HoldingLayoutServiceimpl holdingLayoutServiceimpl;
    /**
     * 获取所有馆藏布局信息
     * @return
     */
    @GetMapping
    public R holdinglayout() {
        List<HoldingLayout> list = holdingLayoutServiceimpl.getHoldingLayout();
        if(list.isEmpty()){
            return R.error();
        }else {
            return R.ok().data("holdingLayoutList",list);
        }
    }

    @GetMapping("/library_id={library_id}")
    public R holdinglayoutByLibraryId(@PathVariable("library_id") Integer library_id) {
        List<HoldingLayout> list = holdingLayoutServiceimpl.getHoldingLayoutByLibraryId(library_id);
        if(list == null){
            return R.error();
        }else {
            return R.ok().data("holdingLayoutByLibraryId"+ library_id,list);
        }
    }
}
