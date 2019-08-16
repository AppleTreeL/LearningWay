package com.cashsystem.cmd.impl.acount;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

import java.security.AccessControlContext;

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
        System.out.println("请输入要修改的用户的编号");
        int id = scanner.nextInt();
        Account account = this.accountService.getAccount(id);
        if(account == null) {
            System.err.println("查无此人");
            return;
        }else {
            System.out.println("该用户现在的信息如下:");
            System.out.println(account);
        }
        System.out.println("设置用户启停，(输入1：表示启用该账户，输入2：表示禁用该账户)");
        int account_status= scanner.nextInt();

        String status = null;
        if(account_status == 1) status = "启用";
        else status = "禁用";

        System.out.println("确认要"+ status + "吗？(Y/N)");
        String modify = scanner.next();
        if(modify.equalsIgnoreCase("Y")) {
            System.out.println("开始设置 " + status + "....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean effect = this.accountService.setAccountStatus(id, account_status);

            if (effect) {
                System.out.println("设置成功...");
            } else {
                System.err.println("设置失败...");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("已经取消设置....");
        }

    }
}
