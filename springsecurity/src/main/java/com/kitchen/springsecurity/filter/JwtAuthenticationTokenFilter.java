package com.kitchen.springsecurity.filter;

import com.kitchen.springsecurity.entity.LoginUser;
import com.kitchen.springsecurity.service.TokenService;
import com.kitchen.springsecurity.utils.SecurityUtils;
import com.kitchen.springsecurity.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
// <1> 获得当前 LoginUser
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 如果存在 LoginUser ，并且未认证过
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication())) {
            // <2> 校验 Token 有效性
            tokenService.verifyToken(loginUser);
            // <3> 创建 UsernamePasswordAuthenticationToken 对象，设置到 SecurityContextHolder 中
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        // <4> 继续过滤器
        chain.doFilter(request, response);
    }
}
