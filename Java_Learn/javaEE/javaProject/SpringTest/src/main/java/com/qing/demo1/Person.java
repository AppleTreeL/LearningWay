package com.qing.demo1;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2019/8/2 13:26
 * @Created by AppleTree
 */
public class Person {

    private String name;
    private int id;
    private char sex;

    private Phone myPhone;

    public Phone getMyPhone() {
        return myPhone;
    }

    public void setMyPhone(Phone myPhone) {
        this.myPhone = myPhone;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex=" + sex +
                ", myPhone=" + myPhone +
                '}';
    }
}
