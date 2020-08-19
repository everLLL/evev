package com.kitchen.springsecurity.dao;


import com.kitchen.springsecurity.entity.SysRole;

import java.util.List;

public interface SysRoleMapper {

    List<SysRole> selectRolePermissionByUserId(Long userId);
}



/*
// SysRoleMapper.xml
<sql id="selectRoleVo">
        select distinct r.role_id, r.role_name, r.role_key, r.role_sort, r.data_scope,
        r.status, r.del_flag, r.create_time, r.remark
        from sys_role r
        left join sys_user_role ur on ur.role_id = r.role_id
        left join sys_user u on u.user_id = ur.user_id
        left join sys_dept d on u.dept_id = d.dept_id
</sql>

<select id="selectRolePermissionByUserId" parameterType="Long" resultMap="SysRoleResult">
<include refid="selectRoleVo"/>
        WHERE r.del_flag = '0' and ur.user_id = #{userId}
</select>*/


/*
<sql id="selectRoleVo">
        select distinct r.role_id, r.role_name, r.role_key, r.role_sort, r.data_scope,
        r.status, r.del_flag, r.create_time, r.remark
        from sys_role r
        left join sys_user_role ur on ur.role_id = r.role_id
        left join sys_user u on u.user_id = ur.user_id
        left join sys_dept d on u.dept_id = d.dept_id
</sql>

<select id="selectRolePermissionByUserId" parameterType="Long" resultMap="SysRoleResult">
<include refid="selectRoleVo"/>
        WHERE r.del_flag = '0' and ur.user_id = #{userId}
</select>*/
