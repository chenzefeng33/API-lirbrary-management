package com.example.library.controller;

import com.example.library.pojo.LibraryInformation;
import com.example.library.service.LibraryInformationService;
import com.example.library.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libraryinformation")
public class LibraryInformationController {

    @Autowired
    public LibraryInformationService libraryInformationService;

    /**
     * 获取所有图书馆信息
     * @return
     */
    @GetMapping
    public R libraryinformation() {
        List<LibraryInformation> list = libraryInformationService.getLibraryInformation();

        if(list.isEmpty()){
            return R.error();
        }else {
            return R.ok().data("libraryInformationList",list);
        }
    }

    @GetMapping("/library_id={library_id}")
    public R getLibraryInformationByLibraryId(@PathVariable("library_id") Integer library_id){
        List<LibraryInformation> list = libraryInformationService.getLibraryInformationByLibraryId(library_id);
        if (list == null){
            return R.error();
        }else {
            return R.ok().data("libraryInformationByLibraryId"+ library_id, list);
        }
    }

}
