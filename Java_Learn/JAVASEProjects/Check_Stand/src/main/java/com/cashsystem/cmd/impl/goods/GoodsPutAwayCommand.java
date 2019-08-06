package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Goods;

/**
 * @Classname GoodsPutAwayCommand
 * @Description TODO
 * @Date 2019/8/4 11:45
 * @Created by AppleTree
 */

@AdminCommand
@CommandMeta(
        name = "SPSP",
        desc = "商品上架",
        group = "商品信息"
)
public class GoodsPutAwayCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("上架商品....");
        System.out.println("请输入商品的名称");
        String name = scanner.nextLine();
        System.out.println("商品的简介");
        String introduce = scanner.nextLine();
        System.out.println("商品库存");
        int stock = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("商品数量单位");
        String unit = scanner.nextLine();
        System.out.println("商品单价(元)");
        int price = new Double(100 * scanner.nextDouble()).intValue();
        System.out.println("请输入商品折扣值");
        int discount = scanner.nextInt();

        Goods goods = new Goods();
        goods.setUnit(unit);
        goods.setPrice(price);
        goods.setDiscount(discount);
        goods.setStock(stock);
        goods.setIntroduce(introduce);
        goods.setName(name);

        boolean effect = this.goodsService.putAwayGoods(goods);
        if(effect) System.out.println("上架成功....");
        else System.out.println("上架失败....");

    }
}
