package com.cashsystem.entity;

import lombok.Data;

/**
 * @Classname Goods
 * @Description TODO
 * @Date 2019/8/4 10:35
 * @Created by AppleTree
 */

@Data
public class Goods {

    private Integer id;
    private String name;
    private String introduce;
    private Integer stock;
    private String unit;
    private Integer price;
    private Integer discount;

}
