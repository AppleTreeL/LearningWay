package com.cashsystem.entity;

import com.cashsystem.common.OrderStatus;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 * @Classname Order
 * @Description TODO
 * @Date 2019/8/4 10:37
 * @Created by AppleTree
 */

@Data
@ToString
public class Order {

    private String id;
    private String acount_id;
    private String acount_name;
    private LocalDateTime creat_time;
    private LocalDateTime finis_time;
    private Integer actual_amount;
    private Integer total_money;
    private OrderStatus oder_status;
}
