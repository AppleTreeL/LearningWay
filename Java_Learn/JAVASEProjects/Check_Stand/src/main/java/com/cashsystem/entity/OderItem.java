package com.cashsystem.entity;

import lombok.Data;

/**
 * @Classname OderItem
 * @Description TODO
 * @Date 2019/8/4 10:41
 * @Created by AppleTree
 */

@Data
public class OderItem {
    private Integer id;
    private String orderId;
    private Integer goodsId;
    private String goodsName;
    private String goodsIntroduce;
    private Integer goodsNum;
    private String goodsUnit;
    private Integer goodsPrice;
    private Integer goodsDisacount;
}
