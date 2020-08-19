package com.kitchen.springsecurity.handler;

import cn.hutool.json.JSON;
import com.kitchen.springsecurity.common.Constants;
import com.kitchen.springsecurity.common.HttpStatus;
import com.kitchen.springsecurity.entity.LoginUser;
import com.kitchen.springsecurity.service.TokenService;
import com.kitchen.springsecurity.utils.ServletUtils;
import com.kitchen.springsecurity.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自定义退出处理类 返回成功
@Configuration
public class LogoutSuccessHandlerImpl //implements LogoutSuccessHandler
 {

/*
    @Autowired
    private TokenService tokenService;

    */
/**
     * 退出处理
     *//*

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // <1> 获得当前 LoginUser
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 如果有登录的情况下
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // <2> 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // <3> 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
        }
        // <4> 响应退出成功
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.SUCCESS, "退出成功")));
    }
*/

}