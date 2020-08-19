package com.kitchen.springsecurity.service.impl;

import com.kitchen.springsecurity.entity.LoginUser;
import com.kitchen.springsecurity.service.ISysLoginService;
import com.kitchen.springsecurity.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysLoginServiceImpl implements ISysLoginService {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public String login(String username, String password, String code, String uuid) {
        //验证码校验 ---------略过

        //用户验证
        Authentication authentication =null;
        try {
            // 该方法会去调用 UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e){
            log.info(e.getMessage());
            //登录错误日志记录-----略过
        }

        //登录成功日志记录-----略过

        //生成token
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);

    }

    /**
     * 获取当前用户
     */
    public String currentUser(){
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        return details.toString();
    }
}
