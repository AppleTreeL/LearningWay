package com.qing.demo1;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname Phone
 * @Description TODO
 * @Date 2019/8/2 13:26
 * @Created by AppleTree
 */
public class Phone {

    public String color;
    public String name;
    public double price;
    public double weight;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Phone() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", createTime=" + createTime +
                '}';
    }
}
