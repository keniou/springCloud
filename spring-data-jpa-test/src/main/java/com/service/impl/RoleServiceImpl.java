package com.service.impl;

import com.dao.RoleRepository;
import com.entity.Role;
import com.entity.User;
import com.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void getRolesByUserId() {
        List<Role> res = roleRepository.findByUsersId(1L);
        log.info(String.valueOf(res));
    }
}
