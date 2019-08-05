package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname QuitCommand
 * @Description TODO
 * @Date 2019/8/4 11:44
 * @Created by AppleTree
 */

@AdminCommand
@CustomerCommand
@EntranceCommand
@CommandMeta(
        name = "TC",
        desc = "退出系统",
        group = "公共命令"
)
public class QuitCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        //String path = "mspaint";

        Runtime run = Runtime.getRuntime();

        try {

            Process process = run.exec("cmd.exe /k start ");

            InputStream in = process.getInputStream();

            while (in.read() != -1) {

                System.out.println(in.read());

            }

            in.close();

            process.waitFor();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
