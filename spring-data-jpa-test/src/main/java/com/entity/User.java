package com.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private Integer enabled;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "last_password_reset_time")
    private Date lastPasswordResetTime;

    /**
     *mappedBy与@JoinColumn和@JoinTable互斥，不能同时作用于一个成员
     *@JoinColumn和@JoinTable描述了数据库表的外键信息
     *
     * @JoinTable注解而能够直接获取外键信息，增/删/改操作时jpa会同步操作外键
     *
     *
     * @ManyToMany(cascade = CascadeType.ALL)
     *
     * CascadeType.PERSIST PERSIST无法级联存储 需要使用cascade=CascadeType.MERGE
     *
     *
     *
     * name = "xxxx"  referencedColumnName = "yyyy"
     *
     * xxxx 指向的是被拥有方，是数据库中的字段名，不是实体中别名
     *
     * yyyy指向的是拥有方，在数据库中主键字段名，不是实体中别名
     *
     *
     * 关系拥有方
     *
     * fetch = FetchType.EAGER 可以关闭懒加载，实现级联查询
     *
     * */
    @ManyToMany
    @JoinTable(name = "users_roles"
            , joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;


    /**
     *
     * 使用toString()需要排除订单外键字段，否则会出错
     *
     * */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", lastPasswordResetTime=" + lastPasswordResetTime +
                '}';
    }
}
