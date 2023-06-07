package com.example.library.controller;

import com.example.library.pojo.Organization;
import com.example.library.util.R;
import com.example.library.service.impl.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    public OrganizationService organizationService;

    /**
     * 获取所有组织机构信息
     * @return
     */
    @GetMapping
    public R organization() {
        List<Organization> list = organizationService.getOrganization();

        if(list.isEmpty()){
            return R.error();
        }else {
            return R.ok().data("organizationList",list);
        }
    }

    @GetMapping("/branch_id={branch_id}")
    public R organizationByBranchId(@PathVariable("branch_id") Integer branch_id){
        List<Organization> list = organizationService.getOrganizationByBranchId(branch_id);
        if(list == null){
            return R.error();
        }else {
            return R.ok().data("holdingLayoutByBranchId"+ branch_id,list);
        }
    }
}
