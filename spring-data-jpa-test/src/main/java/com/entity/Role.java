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
     * 不直接具有外键信息，级联增/删/改时jpa当外键不存在，但级联操作仍然有效。
     *
     *
     * 关系被拥有方
     * */
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

}
