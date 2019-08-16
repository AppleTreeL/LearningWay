package com.cashsystem.cmd.impl;

import com.cashsystem.cmd.Command;
import com.cashsystem.service.AccountService;
import com.cashsystem.service.GoodsService;
import com.cashsystem.service.OrderService;

/**
 * @Classname AbstractCommand
 * @Description TODO
 * @Date 2019/8/4 11:53
 * @Created by AppleTree
 */
public abstract class AbstractCommand implements Command {
    //start all service
    public AccountService accountService;
    public GoodsService goodsService;
    public OrderService orderService;

    public AbstractCommand() {
        accountService = new AccountService();
        goodsService = new GoodsService();
        orderService = new OrderService();
    }
}
