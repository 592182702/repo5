package com.deyuan.controller;


import com.deyuan.pojo.Permission;
import com.deyuan.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")

public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    //保存资源权限
    @RequestMapping("/save")
    public  String save (Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }


    //查询全部资源权限
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
      List<Permission> list = permissionService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionList",list);
        modelAndView.setViewName("permission-list");


        return modelAndView;
    }
}
