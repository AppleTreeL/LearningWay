package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;

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

    }
}
