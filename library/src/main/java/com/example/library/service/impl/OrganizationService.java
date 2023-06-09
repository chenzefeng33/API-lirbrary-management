package com.example.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.library.dao.OrganizationDao;
import com.example.library.pojo.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationService extends ServiceImpl<OrganizationDao, Organization> implements com.example.library.service.OrganizationService {
    @Autowired
    public OrganizationDao organizationDao;

    @Override
    public List<Organization> getOrganization() { return organizationDao.getOrganizaiton(); }

    @Override
    public List<Organization> getOrganizationByBranchId(Integer branch_id) { return organizationDao.getOrganizaitonByBranchId(branch_id); }
}
