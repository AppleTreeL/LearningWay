package com.cashsystem.cmd.impl.order;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.common.OrderStatus;
import com.cashsystem.entity.Goods;
import com.cashsystem.entity.OderItem;
import com.cashsystem.entity.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname OrderPayCommand
 * @Description TODO
 * @Date 2019/8/4 11:56
 * @Created by AppleTree
 */

@CustomerCommand
@CommandMeta(
        name = "ZFDD",
        desc = "支付订单",
        group = "我的订单"
)
public class OrderPayCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入你要购买的货物的id以及多个货物之间用逗号隔开， 格式：1-8, 2-6");
        String string = scanner.next();

        String[] strings = string.split(",");

        //take all your buy to goodsList
        List<Goods> goodsList = new ArrayList<>();
        for (String goodsString : strings) {
            //[0] = "1", [1] = "8"
            String[] str = goodsString.split("-");
            Goods goods = this.goodsService.getGoods(Integer.parseInt(str[0]));
            goods.setBuyGoodsNumber(Integer.parseInt(str[1]));
            if(goods != null)
                goodsList.add(goods);
        }

        Order order = new Order();
        order.setId(String.valueOf(System.currentTimeMillis()));
        order.setAcount_id(subject.getAccount().getId());
        order.setAcount_name(subject.getAccount().getName());
        order.setCreat_time(LocalDateTime.now());

        int totalMoney = 0;
        int actualMoney = 0;
        for (Goods goods:goodsList) {
            OderItem orderItem = new OderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setGoodsId(goods.getId());

            orderItem.setGoodsName(goods.getName());
            orderItem.setGoodsUnit(goods.getUnit());
            orderItem.setGoodsIntroduce(goods.getIntroduce());
            orderItem.setGoodsNum(goods.getBuyGoodsNumber());
            orderItem.setGoodsPrice(goods.getPrice());
            orderItem.setGoodsDisacount(goods.getDiscount());
            order.orderItemList.add(orderItem);//storage orderItem

            int currentMoney = goods.getBuyGoodsNumber() * goods.getPrice();
            totalMoney += currentMoney;
            actualMoney += currentMoney * goods.getDiscount() / 100;
        }

        order.setTotal_money(totalMoney);
        order.setActual_amount(actualMoney);
        order.setOder_status(OrderStatus.PLAYING);

        System.out.println(order);
        System.out.println("确认支付吗? Y/N");
        String confirm = scanner.next();
        if("Y".equalsIgnoreCase(confirm)) {
            order.setFinis_time(LocalDateTime.now());
            order.setOder_status(OrderStatus.OK);

            boolean effect = this.orderService.commitOrder(order);
            if(effect) {
                //插入订单和订单项成功
                for (Goods goods: goodsList) {
                    boolean isUpdate = this.goodsService.updateAfterPay(goods, goods.getBuyGoodsNumber());
                    if(isUpdate) {
                        System.out.println("库存更新成功....");
                    }else {
                        System.err.println("库存更新失败....");
                    }
                }
                System.out.println("支付成功....");
            }
        }else {
            System.err.println("已经取消，请重新下单....");
        }


    }
}
