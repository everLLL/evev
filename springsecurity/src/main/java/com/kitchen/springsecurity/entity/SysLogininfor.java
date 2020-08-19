package com.kitchen.springsecurity.entity;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SysLogininfor extends BaseEntity  {

    private static final long serialVersionUID = 1L;

//    @Excel(name = "序号", cellType = ColumnType.NUMERIC)
    private Long infoId;

//    @Excel(name = "用户账号")
    private String userName;

//    @Excel(name = "登录状态", readConverterExp = "0=成功,1=失败")
    private String status;

//    @Excel(name = "登录地址")
    private String ipaddr;

//    @Excel(name = "登录地点")
    private String loginLocation;

//    @Excel(name = "浏览器")
    private String browser;

//    @Excel(name = "操作系统")
    private String os;

//    @Excel(name = "提示消息")
    private String msg;

//    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDate loginTime;

}
