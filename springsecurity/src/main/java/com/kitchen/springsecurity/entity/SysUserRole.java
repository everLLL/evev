package com.kitchen.springsecurity.entity;

import lombok.Data;

@Data
public class SysUserRole extends BaseEntity{
    private static final long serialVersionUID = 1L;
    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;
}
