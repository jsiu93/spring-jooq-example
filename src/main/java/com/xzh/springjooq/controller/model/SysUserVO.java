package com.xzh.springjooq.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xzh.springjooq.serializer.JsonIdSerializer;
import com.xzh.springjooq.serializer.LocalDateTimeToLongSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Authur: joshuasiu
 * @Date: 2019-05-30 15:13
 * @Description:
 */
@Data
public class SysUserVO {


    @JsonSerialize(using = JsonIdSerializer.class)
    private Long          userId;
    private String        username;
    private String        password;
    private String        salt;
    private String        email;
    private String        mobile;
    private Integer       status;
    private Long          deptId;

    @JsonSerialize(using = LocalDateTimeToLongSerializer.class)
    private LocalDateTime createTime;
}
