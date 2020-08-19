package com.kitchen.springsecurity.service.impl;

import com.kitchen.springsecurity.dao.SysRoleMapper;
import com.kitchen.springsecurity.entity.SysRole;
import com.kitchen.springsecurity.service.ISysRoleService;
import com.kitchen.springsecurity.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleServiceImpl implements ISysRoleService {}/*{
    @Autowired
    private SysRoleMapper roleMapper;

    *//**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     *//*
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        // 获得 userId 拥有的 SysRole 数组
        List<SysRole> perms = roleMapper.selectRolePermissionByUserId(userId);
        // 遍历 SysRole 数组，生成角色标识数组
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }




}*/
