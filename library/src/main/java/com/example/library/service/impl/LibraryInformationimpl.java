package com.example.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library.dao.LibraryInformationDao;
import com.example.library.pojo.LibraryInformation;
import com.example.library.service.LibraryInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryInformationimpl extends ServiceImpl<LibraryInformationDao, LibraryInformation> implements LibraryInformationService {
    @Autowired
    public LibraryInformationDao libraryInformationDao;

    @Override
    public List<LibraryInformation> getLibraryInformation() {
        return libraryInformationDao.getLibraryInformation();
    }

    @Override
    public List<LibraryInformation> getLibraryInformationByLibraryId(Integer library_id) {
        return libraryInformationDao.getLibraryInformationByLibraryId(library_id);
    }
}
