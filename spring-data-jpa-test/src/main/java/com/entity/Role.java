package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author huangfeichang.
 * @date 2019/3/31 0031.
 */
@Entity
@Table(name = "role")
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "name")
    private String name;

    @Column(name = "remark")
    private String remark;


    /**使用mappedBy
     * 缺少描述外键信息的注解，查找时jpa似乎无法查找数据并封装到users，
     * 因此我们需要告诉jpa去哪找外键信息。
     * 显然外键信息就在User.roles(该成员保存在@JoinTable注解)，因此最终写成mappedBy="roles"
     *
     *
     * 不直接具有外键信息，级联增/删/改时jpa当外键不存在，但查询级联操作仍然有效。
     *
     *
     * 关系被拥有方
     *
     * fetch = FetchType.EAGER 可以关闭懒加载，实现级联查询
     *
     * */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> users;


    /**
     *
     * 使用toString()需要排除订单外键字段，否则会出错
     *
     * */
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}
