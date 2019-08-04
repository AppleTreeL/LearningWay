package com.cashsystem.cmd.impl.acount;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;

/**
 * @Classname AcountBrowseCommand
 * @Description TODO
 * @Date 2019/8/4 11:40
 * @Created by AppleTree
 */

@AdminCommand
@CommandMeta(
        name = "CKZH",
        desc = "查看账户",
        group = "账号信息"
)
public class AcountBrowseCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
