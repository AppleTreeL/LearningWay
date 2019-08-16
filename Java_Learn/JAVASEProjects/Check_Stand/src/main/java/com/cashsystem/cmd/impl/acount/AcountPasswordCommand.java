package com.cashsystem.cmd.impl.acount;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

/**
 * @Classname AcountPasswordCommand
 * @Description TODO
 * @Date 2019/8/4 11:40
 * @Created by AppleTree
 */

@AdminCommand
@CommandMeta(
        name = "CZMA",
        desc = "重置密码",
        group = "账号信息"
)
public class AcountPasswordCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("请输入用户编号");
        int id = scanner.nextInt();
        Account account = this.accountService.getAccount(id);
        if(account == null) {
            System.err.println("查无此人");
        }else {
            System.out.println("该用户现有信息如下");
            System.out.println(account);
        }
        System.out.println("请输入新的密码");
        String password = scanner.next();
        System.out.println("请再次输入新密码");
        String passwordCheck = scanner.next();
        if(!password.equals(passwordCheck)) {
            System.err.println("两次输入不一致，已退出本进程...");
        }else {
            System.out.println("正在更新密码...");
            boolean effect = this.accountService.updatePassword(id, password);
            if(effect) {
                System.out.println("更新密码成功...");
            }else {
                System.err.println("更新失败...");
            }
        }
    }
}
