package com.dao;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
