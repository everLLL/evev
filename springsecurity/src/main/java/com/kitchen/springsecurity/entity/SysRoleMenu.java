package com.kitchen.springsecurity.entity;

import lombok.Data;

@Data
public class SysRoleMenu extends BaseEntity {
    /** 角色ID */
    private Long roleId;

    /** 菜单ID */
    private Long menuId;
}
