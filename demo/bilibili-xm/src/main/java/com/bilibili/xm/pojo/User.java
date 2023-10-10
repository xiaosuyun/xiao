package com.bilibili.xm.pojo;

public class User {
    private Integer id;
    private String name;
    private String type;
    private Integer age;
    private String sex;
    private String hobby;
    private String identity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public User() {
    }

    public User(Integer id, String name, String type, Integer age, String sex, String hobby, String identity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
