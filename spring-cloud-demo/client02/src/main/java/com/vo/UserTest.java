package com.vo;

import java.util.List;

/**
 * @author huangfeichang.
 * @date 2019/8/23 0023.
 */
public class UserTest {
    /**
     * name : 姓名
     */

    private String name;

    private String age;

    private List<String> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
