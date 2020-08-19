package com.kitchen.springsecurity.service.impl;


import com.kitchen.springsecurity.entity.LoginUser;
import com.kitchen.springsecurity.entity.SysUser;
import com.kitchen.springsecurity.enums.UserStatus;
import com.kitchen.springsecurity.exception.BaseException;
import com.kitchen.springsecurity.service.ISysUserService;
import com.kitchen.springsecurity.service.ISysPermissionService;
import com.kitchen.springsecurity.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class UserDetailService implements  UserDetailsService {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // <1> 查询指定用户名对应的 SysUser
        SysUser user = userService.selectUserByUserName(username);
        // <2> 各种校验
        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.info("登录用户：{} 已被删除.", username);
            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }

        // <3> 创建 Spring Security UserDetails 用户明细
        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user) {
//        return new LoginUser(user, permissionService.getMenuPermission(user));
        Set<String> roles = new HashSet<String>();
        roles.add("admin");
        return new LoginUser(user, roles);
    }

}
