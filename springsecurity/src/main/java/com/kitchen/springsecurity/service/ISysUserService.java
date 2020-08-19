package com.kitchen.springsecurity.service;

import com.kitchen.springsecurity.entity.SysUser;

public interface ISysUserService {
    SysUser selectUserByUserName(String username);
}
