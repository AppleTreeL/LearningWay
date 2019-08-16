package com.cashsystem.cmd.impl.acount;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("浏览用户...");
        List<Account> list = this.accountService.queryAllAccounts();
        if (list.isEmpty()) {
            System.out.println("无已经注册的用户");
        } else {
            for (Account it : list) {
                System.out.println(it);
            }
        }
    }
}
