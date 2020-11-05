package com.deyuan.service;

import com.deyuan.pojo.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}
