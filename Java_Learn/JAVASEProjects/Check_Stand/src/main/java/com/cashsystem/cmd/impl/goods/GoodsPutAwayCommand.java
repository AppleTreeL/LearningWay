package com.cashsystem.cmd.impl.goods;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;

/**
 * @Classname GoodsPutAwayCommand
 * @Description TODO
 * @Date 2019/8/4 11:45
 * @Created by AppleTree
 */

@AdminCommand
@CommandMeta(
        name = "SPSJ",
        desc = "商品上架",
        group = "商品信息"
)
public class GoodsPutAwayCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
