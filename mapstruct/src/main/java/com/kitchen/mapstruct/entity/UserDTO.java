package com.kitchen.mapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Integer uid;
    private String name;
    private Integer sex;
    private String job;
}
