package com.kitchen.springsecurity.service;

public interface ISysLoginService {
    public String login(String username, String password, String code, String uuid);
}
