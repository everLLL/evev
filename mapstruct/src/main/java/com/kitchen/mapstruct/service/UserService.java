package com.kitchen.mapstruct.service;

import com.kitchen.mapstruct.entity.UserDTO;

public class UserService {

    public void convertTest(){
        UserDTO dto = new UserDTO(1, "张三", 1, "教师");

    }
}
