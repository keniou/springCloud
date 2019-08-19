package com.service.impl;

import com.dao.UserRepository;
import com.entity.Role;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getAllUser() {
        List<User> r = userRepository.findAll();
        System.err.println(r);
    }

    @Override
    public void getUserAndRole() {
        Optional<User> res = userRepository.findById(1L);

        System.err.println(res.get());

    }

    @Override
    public void add() {
        User user = new User();
        user.setAvatar("wwww");
        user.setCreateTime(new Date());
        user.setEmail("rrrr");
        user.setEnabled(1);
        user.setLastPasswordResetTime(new Date());
        user.setUsername("1234567");
        user.setPassword("12345578");
        Role role = new Role();
        role.setId(100L);
        Role role1 = new Role();
        role1.setId(1L);
        Set<Role> set = new HashSet<>();
        set.add(role);
        set.add(role1);
        user.setRoles(set);
        userRepository.save(user);
    }


}
