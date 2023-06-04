package com.example.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.library.pojo.Organization;

import java.util.List;

public interface OrganizationService extends IService<Organization> {
    List<Organization> getOrganization();

    List<Organization> getOrganizationByBranchId(Integer branch_id);
}
