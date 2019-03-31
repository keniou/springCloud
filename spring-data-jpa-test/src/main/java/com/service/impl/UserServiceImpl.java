package com.service.impl;

import com.dao.UserRepository;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void getAllUser() {
        List<User> r = userRepository.findAll();
        System.err.println(r);
    }


}
