package com.deyuan.service.impl;

import com.deyuan.dao.RoleDao;
import com.deyuan.pojo.Permission;
import com.deyuan.pojo.Role;
import com.deyuan.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleDao roledao;


    @Override
    public List<Role> findAll() {
        return roledao.findAll();
    }

    @Override
    public void save(Role role) {
        roledao.save(role);
    }

    @Override
    public List<Permission> findRoleByRoleIdOtherPermission(String id) {
        return roledao.findRoleByRoleIdOtherPermission(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roledao.addPermissionToRole(roleId,permissionId);
        }

    }
}
