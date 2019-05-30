package com.xzh.springjooq.controller.model;

import lombok.Data;

/**
 * @Authur: joshuasiu
 * @Date: 2019-05-30 15:56
 * @Description:
 */
@Data
public class SysUserRequest {


    private Long          userId;
    private String        username;
    private String        password;
    private String        email;
    private String        mobile;
    private Integer       status;
    private Long          deptId;


}
