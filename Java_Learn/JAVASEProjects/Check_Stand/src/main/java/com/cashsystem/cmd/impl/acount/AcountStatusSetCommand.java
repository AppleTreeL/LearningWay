package com.cashsystem.cmd.impl.acount;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;

/**
 * @Classname AcountStatusSetCommand
 * @Description TODO
 * @Date 2019/8/4 11:41
 * @Created by AppleTree
 */

@AdminCommand
@CommandMeta(
        name = "QTZH",
        desc = "启停账号",
        group = "账号信息"
)
public class AcountStatusSetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
