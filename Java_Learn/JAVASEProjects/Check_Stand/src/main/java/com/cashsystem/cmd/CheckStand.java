package com.cashsystem.cmd;

import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

/**
 * @Classname CheckStand
 * @Description TODO
 * @Date 2019/8/4 15:02
 * @Created by AppleTree
 */
public class CheckStand extends AbstractCommand {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new CheckStand().execute(subject);
    }

    @Override
    public void execute(Subject subject) {
        Commands.getCacheHelpCommands().execute(subject);
        while (true) {
            System.out.println(">>");
            String line = scanner.nextLine();
            String commandCode = line.trim().toUpperCase();
            Account account = subject.getAccount();
            if(account == null) {
                Commands.getEntranceCommand(commandCode).execute(subject);
            }else {
                switch (account.getAcountType()){
                    case ADMIN:Commands.getAdminCommand(commandCode).execute(subject);break;
                    case CUSTOMER:Commands.getCustomerCommand(commandCode).execute(subject);break;
                    default:break;
                }
            }
        }
    }
}
