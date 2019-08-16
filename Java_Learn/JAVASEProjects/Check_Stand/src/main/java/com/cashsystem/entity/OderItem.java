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

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("【订单信息】*************************************").append("\n");
//        sb.append("\t").append("【用户名称】：").append(this.getAccountName()).append("\n");
//        sb.append("\t").append("【订单编号】：").append(this.getId()).append("\n");
//        sb.append("\t").append("【订单状态】：").append(this.getOrderStatus().getDesc()).append("\n");
//        sb.append("\t").append("【创建时间】：").append(this.timeToString(this.getCreateTime())).append("\n");
//        if (this.getOrderStatus() == OrderStatus.OK) {
//            sb.append("\t").append("【完成时间】：")
//                    .append(this.timeToString(this.getFinishTime())).append("\n");
//        }
//        sb.append("【订单明细】*************************************").append("\n");
//        sb.append("\t编号   名称     数量     单位     单价（元）").append("\n");
//        int i = 0;
//        for (OrderItem orderItem : this.getOrderItemList()) {
//            sb.append("\t").append(++i).append(".  ")
//                    .append(orderItem.getGoodsName()).append("   ")
//                    .append(orderItem.getGoodsNum()).append("   ")
//                    .append(orderItem.getGoodsUnit()).append("  ")
//                    .append(this.moneyToString(orderItem.getGoodsPrice())).append("  ")
//                    .append("\n");
//        }
//        sb.append("【订单金额】*************************************").append("\n");
//        sb.append("\t").append("【总金额】：").append(this.moneyToString(this.getTotalMoney()))
//                .append(" 元 ").append("\n");
//        sb.append("\t").append("【优惠金额】：").append(this.moneyToString(this.getDiscount()))
//                .append(" 元 ").append("\n");
//        sb.append("\t").append("【应支付金额】：").append(this.moneyToString(this.getActualAmount()))
//                .append(" 元 ").append("\n");
//        return sb.toString();
//    }
//
//    private String moneyToString(int money) {
//        return String.format("%.2f", 1.00D * money / 100);
//    }
//
//    private String timeToString(LocalDateTime time) {
//        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(time);
//    }
//
//    //优惠
//    public Integer getDiscount() {
//        return this.getTotalMoney() - this.getActualAmount();
//    }

}
