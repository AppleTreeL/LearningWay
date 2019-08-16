package com.cashsystem.entity;

import com.cashsystem.common.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    private int acount_id;
    private String acount_name;
    private LocalDateTime creat_time;
    private LocalDateTime finis_time;
    private Integer actual_amount;
    private Integer total_money;
    private OrderStatus oder_status;

    //storage all your order
    public List<OderItem> orderItemList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("【订单信息】*************************************").append("\n");
        sb.append("\t").append("【用户名称】：").append(this.getAcount_name()).append("\n");
        sb.append("\t").append("【订单编号】：").append(this.getId()).append("\n");
        sb.append("\t").append("【订单状态】：").append(this.getOder_status().getDesc()).append("\n");
        sb.append("\t").append("【创建时间】：").append(this.timeToString(this.getCreat_time())).append("\n");
        if (this.getOder_status() == OrderStatus.OK) {
            sb.append("\t").append("【完成时间】：")
                    .append(this.timeToString(this.getFinis_time())).append("\n");
        }
        sb.append("【订单明细】*************************************").append("\n");
        sb.append("\t编号   名称     数量     单位     单价（元）").append("\n");
        int i = 0;
        for (OderItem orderItem : this.getOrderItemList()) {
            sb.append("\t").append(++i).append(".  ")
                    .append(orderItem.getGoodsName()).append("   ")
                    .append(orderItem.getGoodsNum()).append("   ")
                    .append(orderItem.getGoodsUnit()).append("  ")
                    .append(this.moneyToString(orderItem.getGoodsPrice())).append("  ")
                    .append("\n");
        }
        sb.append("【订单金额】*************************************").append("\n");
        sb.append("\t").append("【总金额】：").append(this.moneyToString(this.getTotal_money()))
                .append(" 元 ").append("\n");
        sb.append("\t").append("【优惠金额】：").append(this.moneyToString(this.getDiscount()))
                .append(" 元 ").append("\n");
        sb.append("\t").append("【应支付金额】：").append(this.moneyToString(this.getActual_amount()))
                .append(" 元 ").append("\n");
        return sb.toString();
    }

    private String moneyToString(int money) {
        return String.format("%.2f", 1.00D * money / 100);
    }

    private String timeToString(LocalDateTime time) {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(time);
    }

    //优惠
    public Integer getDiscount() {
        return this.getTotal_money() - this.getActual_amount();
    }

}
