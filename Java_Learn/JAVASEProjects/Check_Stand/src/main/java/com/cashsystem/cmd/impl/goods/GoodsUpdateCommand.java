package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

/**
 * @Classname GoodsUpdateCommand
 * @Description TODO
 * @Date 2019/8/4 11:46
 * @Created by AppleTree
 */

@AdminCommand
@CommandMeta(
        name = "SPGX",
        desc = "商品更新",
        group = "商品信息"
)
public class GoodsUpdateCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("更新商品....");
        System.out.println("请输入更新商品的编号");
        int goodsId = scanner.nextInt();
        Goods goods = this.goodsService.getGoods(goodsId);
        if(goods == null) {
            System.err.println("没有此编号的商品....");
            return;
        }else {
            System.out.println("该商品现有信息如下");
            System.out.println(goods);
        }

        System.out.println("商品的简介");
        String introduce = scanner.next();
        System.out.println("商品库存");
        int stock = Integer.parseInt(scanner.next().trim());
        System.out.println("商品数量单位");
        String unit = scanner.next();
        System.out.println("商品单价(元)");
        int price = new Double(100 * scanner.nextDouble()).intValue();
        System.out.println("请输入商品折扣值");
        int discount = scanner.nextInt();

        System.out.println("确认更新吗？(Y/N)");
        String flg = scanner.next();
        if("y".equals(flg) || "Y".equals(flg)){
            goods.setIntroduce(introduce);
            goods.setStock(stock);
            goods.setUnit(unit);
            goods.setPrice(price);
            goods.setDiscount(discount);
            //update darabase table goods
           boolean effect =  this.goodsService.modifyGoods(goods);
           if(effect) {
               System.out.println("商品更新成功.....");
           }else{
               System.err.println("商品更新失败....");
           }
        }else {
            System.err.println("已经取消更新.....");
        }
    }
}
