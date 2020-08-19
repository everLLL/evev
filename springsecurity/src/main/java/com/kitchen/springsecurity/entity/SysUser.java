package com.kitchen.springsecurity.entity;

import lombok.Data;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

@Data
public class SysUser  {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long deptId;

    private String userName;

    private String nickName;

    private String email;

    private String phonenumber;

    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 盐加密 */
    private String salt;

    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    private String loginIp;

    private LocalDate loginDate;

//    @Transient
//    private SysDept dept;

    /** 角色对象 */
//    @Transient
    private List<SysRole> roles;

    /** 角色组 */
//    @Transient
    private Long[] roleIds;

    /** 岗位组 */
//    @Transient
    private Long[] postIds;

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }


}