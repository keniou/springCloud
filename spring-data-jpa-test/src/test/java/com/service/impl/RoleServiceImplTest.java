package com.service.impl;

import com.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void getRolesByUserId() {
        roleService.getRolesByUserId();
    }
}
