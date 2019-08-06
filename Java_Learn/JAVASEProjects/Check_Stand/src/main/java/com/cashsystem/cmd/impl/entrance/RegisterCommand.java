package com.cashsystem.cmd.impl.entrance;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.common.AcountStatus;
import com.cashsystem.common.AcountType;
import com.cashsystem.entity.Account;

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
        /*Account account = subject.getAccount();
        if(account != null){
            System.out.println("该用户已经注册");
        }
        System.out.println("构造您的用户名:");
        String name = scanner.nextLine();
        System.out.println("构造您的注册账号");
        String username = scanner.nextLine();
        System.out.println("构造您的密码");
        String password = scanner.nextLine();
        System.out.println("构造您的账户类型: (输入1表示管路员，" +
                "输入2表示普通用户)");
        Integer account_type = scanner.nextInt();
        Integer account_status = 1;

        this.accountService.register(username, password, name, account_type, account_status);
        */
        System.out.println("start register......");
        System.out.println("please input your userID");
        String username = scanner.nextLine();
        System.out.println("please input your password");
        String password = scanner.nextLine();
        System.out.println("please input your password again...");
        String passCheck = scanner.nextLine();
        if(!passCheck.equals(password)) {System.out.println("twice password is not same!...");return;}

        System.out.println("please input your name");
        String name = scanner.nextLine();
        System.out.println("please input your account type");
        Integer account_type = scanner.nextInt();
        AcountType acountType = AcountType.valueOf(account_type);
        Integer account_status = 1;
        AcountStatus acountStatus = AcountStatus.valueOf(account_status);

        final Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setName(name);
        //account.setAcountStatus(acountStatus);
        account.setAcountStatus(acountStatus);
        account.setAcountType(acountType);
        boolean effect = this.accountService.register(account);

        if(effect) System.out.println("register successfully.....");
        else System.out.println("register failed.....");
    }
}
