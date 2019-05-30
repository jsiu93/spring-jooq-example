package com.xzh.springjooq.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Authur: joshuasiu
 * @Date: 2019-05-30 14:41
 * @Description:
 */
@Service
@Slf4j
public class SysUserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DSLContext dslContext;


}
