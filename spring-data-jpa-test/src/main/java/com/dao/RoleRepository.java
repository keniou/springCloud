package com.dao;

import com.entity.Role;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findRoleByUsers(User user);
}
