package com.kitchen.springsecurity.service.impl;

import com.kitchen.springsecurity.entity.SysUser;
import com.kitchen.springsecurity.service.ISysMenuService;
import com.kitchen.springsecurity.service.ISysPermissionService;
import com.kitchen.springsecurity.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SysPermissionServiceImpl implements ISysPermissionService{}/*{
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ISysRoleService roleService;

    @Override
    public Set<String> getMenuPermission(SysUser user) {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            roles.add("*:*:*"); // 所有模块
        } else {
            // 读取
            roles.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
        }
        return roles;
    }


    *//**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     *//*
    @Override
    public Set<String> getRolePermission(SysUser user) {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) { // 如果是管理员，强制添加 admin 角色
            roles.add("admin");
        } else { // 如果非管理员，进行查询
            roles.addAll(roleService.selectRolePermissionByUserId(user.getUserId()));
        }
        return roles;
    }




}*/
