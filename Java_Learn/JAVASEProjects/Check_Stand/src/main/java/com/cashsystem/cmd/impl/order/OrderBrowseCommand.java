package com.cashsystem.cmd.impl.order;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Order;

import java.util.List;

/**
 * @Classname OrderBrowseCommand
 * @Description TODO
 * @Date 2019/8/4 11:56
 * @Created by AppleTree
 */

@CustomerCommand
@CommandMeta(
        name = "CKDD",
        desc = "查看订单",
        group = "我的订单"
)
public class OrderBrowseCommand extends AbstractCommand{
    @Override
    public void execute(Subject subject) {
        System.out.println("我的订单列表");
        List<Order> orderList = this.orderService.queryByAccount(subject.getAccount().getId());

        if(orderList.isEmpty()) {
            System.err.println("您还没有下单记录...");
        }else {
            System.out.println("你的订单记录如下");
            for (Order it:orderList) {
                System.out.println(it);
            }
        }
    }
}
