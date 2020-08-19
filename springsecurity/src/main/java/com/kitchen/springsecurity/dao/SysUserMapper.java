package com.kitchen.springsecurity.dao;

import com.kitchen.springsecurity.entity.SysUser;

public interface SysUserMapper {
    SysUser selectUserByUserName(String userName);
}

/*
// SysUserMapper.XML
<sql id="selectUserVo">
        select u.user_id, u.dept_id, u.user_name, u.nick_name, u.email, u.avatar, u.phonenumber, u.password, u.sex, u.status, u.del_flag, u.login_ip, u.login_date, u.create_by, u.create_time, u.remark,
        d.dept_id, d.parent_id, d.dept_name, d.order_num, d.leader, d.status as dept_status,
        r.role_id, r.role_name, r.role_key, r.role_sort, r.data_scope, r.status as role_status
        from sys_user u
        left join sys_dept d on u.dept_id = d.dept_id
        left join sys_user_role ur on u.user_id = ur.user_id
        left join sys_role r on r.role_id = ur.role_id
</sql>

<select id="selectUserByUserName" parameterType="String" resultMap="SysUserResult">
<include refid="selectUserVo"/>
        where u.user_name = #{userName}
</select>*/
