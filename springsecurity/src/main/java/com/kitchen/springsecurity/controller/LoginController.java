package com.kitchen.springsecurity.controller;

import com.kitchen.springsecurity.common.Constants;
import com.kitchen.springsecurity.entity.LoginUser;
import com.kitchen.springsecurity.entity.SysMenu;
import com.kitchen.springsecurity.entity.SysUser;
import com.kitchen.springsecurity.entity.User;

import com.kitchen.springsecurity.service.ISysLoginService;
import com.kitchen.springsecurity.service.ISysMenuService;
import com.kitchen.springsecurity.service.PermissionService;
import com.kitchen.springsecurity.service.TokenService;
import com.kitchen.springsecurity.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping(value = "/admin")
public class LoginController {
    @Autowired
    private TokenService tokenService;
    @Resource
    private PermissionService permissionService;
    @Autowired
    private ISysMenuService sysMenuService;
    @Autowired
    private ISysLoginService loginService;


    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "success";
    }


    @PreAuthorize("@ss.hasPermi('system:dict:list')")
    @GetMapping("/test1")
    @ResponseBody
    public String test1() {
        return "success";
    }


    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    @PostMapping("/login")
    public Map login(String username, String password, String code, String uuid) {
        Map ajax = new HashMap();
        // 生成令牌
        String token = loginService.login(username, password, code, uuid);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }


    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public Map getInfo() {
        // <1> 获得当前 LoginUser
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // <2> 角色标识的集合
        Set<String> roles = permissionService.getRolePermission(user);
        // <3> 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        // <4> 返回结果
        Map ajax = new HashMap<>();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }


    @GetMapping("getRouters")
    public Map getRouters() {
        // 获得当前 LoginUser
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 获得用户的 SysMenu 数组
        SysUser user = loginUser.getUser();
//        List<SysMenu> menus = sysMenuService.selectMenuTreeByUserId(user.getUserId());
        // 构建路由 RouterVo 数组。可用于 Vue 构建管理后台的左边菜单
        return new HashMap();
    }
}
