package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;

/**
 * @Classname GoodsSoldOutCommand
 * @Description TODO
 * @Date 2019/8/4 11:46
 * @Created by AppleTree
 */

@AdminCommand
@CommandMeta(
        name = "SPXJ",
        desc = "商品下架",
        group = "商品信息"
)
public class GoodsSoldOutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入想要下架的商品的编号");
        int id = scanner.nextInt();
        if(this.goodsService.getGoods(id) == null) {
            System.err.println("没有这样编号的商品");
            return;
        }
        System.out.println("确认下架吗? (Y/N)");
        String flg = scanner.next();
        if(flg.equals("Y") || flg.equals("y")) {
            System.out.println("开始下架....");
            boolean effect = this.goodsService.soldOut(id);
            if(effect)
                System.out.println("该商品已经下架....");
            else
                System.err.println("该商品下架失败....");
        }else {
            System.out.println("已经取消下架...");
        }

    }
}
