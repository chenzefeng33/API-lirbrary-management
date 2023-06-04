package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.LibraryInformation;

import java.util.List;

public interface LibraryInformationService extends IService<LibraryInformation> {
    List<LibraryInformation> getLibraryInformation();

    List<LibraryInformation> getLibraryInformationByLibraryId(Integer library_id);
}
