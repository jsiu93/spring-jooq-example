package com.xzh.springjooq;

import com.xzh.springjooq.db.Tables;
import com.xzh.springjooq.db.tables.daos.SysUserDao;
import com.xzh.springjooq.db.tables.pojos.SysUser;
import com.xzh.springjooq.db.tables.records.SysUserRecord;
import com.xzh.springjooq.util.JsonUtil;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.n3r.idworker.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJooqExampleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DSLContext dslContext;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private SysUserDao sysUserDao;


    @Test
    public void testInsert() {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(idWorker.nextId());
        sysUser.setCreateTime(LocalDateTime.now());
        sysUser.setUsername("user1");

        sysUserDao.insert(sysUser);

    }

    @Test
    public void testList() {
        List<SysUser> sysUsers = dslContext.selectFrom(Tables.SYS_USER).fetch().into(SysUser.class);
        System.err.println(JsonUtil.toJson(sysUsers));
    }




}
