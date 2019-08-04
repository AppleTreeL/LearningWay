package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.impl.AbstractCommand;

/**
 * @Classname GoodsBrowseCommand
 * @Description TODO
 * @Date 2019/8/4 11:45
 * @Created by AppleTree
 */

@AdminCommand
@CustomerCommand
@CommandMeta(
        name = "SPLL",
        desc = "商品浏览",
        group = "商品信息"
)
public class GoodsBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
