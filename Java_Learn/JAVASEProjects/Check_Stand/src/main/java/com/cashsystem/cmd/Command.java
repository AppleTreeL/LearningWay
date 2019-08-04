package com.cashsystem.cmd;

import java.util.Scanner;

/**
 * @Classname Coammand
 * @Description TODO
 * @Date 2019/8/4 11:47
 * @Created by AppleTree
 */
public interface Command {
    Scanner scanner = new Scanner(System.in);

    void execute(Subject subject);
}
