package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Command;
import com.cashsystem.cmd.Commands;
import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.entity.Account;

import java.util.*;

import static com.cashsystem.common.AcountType.CUSTOMER;

/**
 * @Classname HelpCommand
 * @Description TODO
 * @Date 2019/8/4 11:44
 * @Created by AppleTree
 */

@AdminCommand
@CustomerCommand
@EntranceCommand
@CommandMeta(
        name = "BZ",
        desc = "帮助信息",
        group = "公共命令"
)
public class HelpCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("helpCommand");
        Account account = subject.getAccount();
        if(account == null) {
            entranceHelp();
        }else{
            switch (account.getAcountType()){
                case CUSTOMER : customerHelp(); break;
                case ADMIN: adminHelp(); break;
            }
        }
    }

    public void entranceHelp() {
        print("欢迎", Commands.ENTRANCE_COMMANDS.values());
    }

    public void customerHelp() {
        print("客户端", Commands.CUSTOMER_COMMANDS.values());
    }

    public void adminHelp() {
        print("管理端", Commands.ADMIN_COMMANDS.values());
    }

    public void print(String title, Collection<Command> collection) {
        System.out.println("**********" + title + "*************");
        Map<String, List<String>> helpInfo = new HashMap<>();
        for (Command command : collection) {
            CommandMeta commandMeta = command.getClass().getDeclaredAnnotation(CommandMeta.class);
            String group = commandMeta.group();//Key

            List<String> func = helpInfo.get(group);
            if(func == null) {
                func = new ArrayList<>();
                helpInfo.put(group,func);
            }
            func.add(commandMeta.desc() +"(" + commandMeta.name() +")");
        }

        //entrySet:
        int i = 0;
        for (Map.Entry<String, List<String>> entry: helpInfo.entrySet()){
            i += 1;
            System.out.println(i + "." + entry.getKey());
            int j = 0;
            for (String item: entry.getValue()) {
                j ++;
                System.out.println("\t" + (i) + "." + (j) +" " + item);
            }
        }
    }
}
