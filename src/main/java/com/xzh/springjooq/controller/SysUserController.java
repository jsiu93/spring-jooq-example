package com.xzh.springjooq.controller;

import com.xzh.springjooq.controller.model.SysUserRequest;
import com.xzh.springjooq.controller.model.SysUserVO;
import com.xzh.springjooq.db.Tables;
import com.xzh.springjooq.db.tables.pojos.SysUser;
import com.xzh.springjooq.db.tables.records.SysUserRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.n3r.idworker.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Authur: joshuasiu
 * @Date: 2019-05-30 15:07
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("sysUser")
public class SysUserController {


    @Autowired
    private DSLContext dslContext;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IdWorker idWorker;

    @PostMapping("save")
    public String save(@RequestBody SysUserRequest request) {

        SysUserRecord sysUserRecord = modelMapper.map(request, SysUserRecord.class);
        sysUserRecord.setUserId(idWorker.nextId());
        sysUserRecord.setCreateTime(LocalDateTime.now());
        int i = dslContext.insertInto(Tables.SYS_USER).set(sysUserRecord).execute();

        return i + "";
    }

    @PostMapping("list")
    public List<SysUserVO> list(@RequestBody SysUserRequest request) {
        List<SysUserVO> sysUsers = dslContext.selectFrom(Tables.SYS_USER).fetch().into(SysUserVO.class);

        return sysUsers;

    }



}
