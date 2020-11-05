package com.deyuan.controller;

import com.deyuan.pojo.Permission;
import com.deyuan.pojo.Role;
import com.deyuan.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    @RequestMapping("addPermissionToRole")
    public  String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids",required = true)String[] permissionIds ){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";

    }

    @RequestMapping("findRoleByIdPermission")
    public  ModelAndView findRoleByIdPermission(@RequestParam(name = "id",required = true) String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleId",id);
         List<Permission>  permissionList = roleService.findRoleByRoleIdOtherPermission(id);
         modelAndView.addObject("permissionList",permissionList);
         modelAndView.setViewName("user-permission-add");
         return  modelAndView;


    }



    //保存
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";

    }

    //查询全部
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Role> roleList = roleService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
