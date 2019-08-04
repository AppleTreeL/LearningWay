package com.cashsystem.cmd.impl.entrance;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;

/**
 * @Classname RegisterCommand
 * @Description TODO
 * @Date 2019/8/4 11:45
 * @Created by AppleTree
 */

@EntranceCommand
@CommandMeta(
        name = "ZC",
        desc = "注册",
        group = "入口命令"
)
public class RegisterCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

    }
}
