package com.kitchen.springsecurity.service;

import cn.hutool.core.lang.UUID;

import com.kitchen.springsecurity.common.Constants;


import com.kitchen.springsecurity.entity.LoginUser;
import com.kitchen.springsecurity.entity.SysUser;
import com.kitchen.springsecurity.utils.AddressUtils;
import com.kitchen.springsecurity.utils.IpUtils;
import com.kitchen.springsecurity.utils.ServletUtils;
import eu.bitwalker.useragentutils.UserAgent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class TokenService {
    protected static final long MILLIS_SECOND = 1000;
    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;
    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Value("${token.expireTime}")
    private int expireTime;
    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;
    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

//    @Autowired
//    private RedisCache redisCache;

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser){
        // 设置 LoginUser 的用户唯一标识。注意，这里虽然变量名叫 token ，其实不是身份认证的 Token
        String token = UUID.fastUUID().toString();
        loginUser.setToken(token);
        // 设置用户终端相关的信息，包括 IP、城市、浏览器、操作系统
        setUserAgent(loginUser);

        // 记录缓存
        refreshToken(loginUser);

        // 生成 JWT 的 Token
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        return createToken(claims);
    }


    /**
     * 设置用户终端相关的信息
     * @param loginUser
     */
    public void setUserAgent(LoginUser loginUser) {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        loginUser.setIpaddr(ip);
        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        loginUser.setBrowser(userAgent.getBrowser().getName());
        loginUser.setOs(userAgent.getOperatingSystem().getName());
    }

    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据 uuid 将 loginUser 缓存
        String userKey = getTokenKey(loginUser.getToken());
//        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    /**
     *
     * @param uuid
     * @return
     */
    private String getTokenKey(String uuid) {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }

    private String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }


    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // <1.1> 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            // <1.2> 解析 JWT 的 Token
            Claims claims = parseToken(token);
            // <1.3> 从 Redis 缓存中，获得对应的 LoginUser
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
//            return redisCache.getCacheObject(userKey);
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setExpireTime(1597722760L);
        SysUser sysUser = new SysUser();
        sysUser.setUserName("user1");
        sysUser.setPassword("123");
        loginUser.setUser(sysUser);
        return loginUser;
//        return null;
    }


    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 验证令牌有效期，相差不足 20 分钟，自动刷新缓存
     *
     * @param loginUser 用户
     */
    public void verifyToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        // 相差不足 20 分钟，自动刷新缓存
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            String token = loginUser.getToken();
            loginUser.setToken(token);
            refreshToken(loginUser);
        }
    }


    public void delLoginUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            // 删除缓存
//            redisCache.deleteObject(userKey);
        }
    }

}
