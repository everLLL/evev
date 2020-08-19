package com.kitchen.springsecurity.service.impl;

import com.kitchen.springsecurity.dao.SysUserMapper;
import com.kitchen.springsecurity.entity.SysUser;
import com.kitchen.springsecurity.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService {
//    @Autowired
//    private SysUserMapper userMapper;

    @Override
    public SysUser selectUserByUserName(String userName) {
        SysUser user = new SysUser();
        return user;
//        return userMapper.selectUserByUserName(userName);
    }


}
