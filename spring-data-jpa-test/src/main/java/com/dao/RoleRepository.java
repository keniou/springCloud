package com.dao;

import com.entity.Role;
import com.entity.User;
import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     *
     * 需要使用user_id查询role信息
     * 方法名定义种类
     * findByUsersId、findByUsers_Id、findByusers_id、findByusersId
     * findByUsers_Id解析为使用Role类中定义的User的users属性下面的id【实体类中的别名】作为条件
     *
     *
     *
     * */
    List<Role> findByUsersId(Long Id);
}
