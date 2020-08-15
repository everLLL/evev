package com.kitchen.springsecurity.service.impl;

import com.kitchen.springsecurity.entity.User;
import com.kitchen.springsecurity.service.IUserDetailService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements IUserDetailService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public User getUserDetail() {
        return new User();
    }


}
