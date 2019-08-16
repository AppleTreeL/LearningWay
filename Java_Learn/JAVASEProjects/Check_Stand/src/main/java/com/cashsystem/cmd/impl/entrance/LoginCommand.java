package com.cashsystem.cmd.impl.entrance;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.common.AcountStatus;
import com.cashsystem.entity.Account;

/**
 * @Classname LoginCommand
 * @Description TODO
 * @Date 2019/8/4 11:44
 * @Created by AppleTree
 */

@EntranceCommand
@CommandMeta(
        name = "DL",
        desc = "登录",
        group = "入口命令"
)
public class LoginCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        if(account != null) {
            System.out.println("已经登陆");
        }
        System.out.println("输入用户名:");
        String name = scanner.nextLine();
        System.out.println("输入密码:");
        String password = scanner.nextLine();
        System.out.println("开始登录.......");

        account = this.accountService.login(name.trim(), password.trim());

        if(account != null && account.getAcountStatus() == AcountStatus.UNLOCK) {
            System.out.println(account.getAcountType().getDesc() + "登陆成功");
            subject.setAccount(account);
        }else {
            //System.out.println(account);
            System.err.println("密码或用户名错误");
        }
    }
}
