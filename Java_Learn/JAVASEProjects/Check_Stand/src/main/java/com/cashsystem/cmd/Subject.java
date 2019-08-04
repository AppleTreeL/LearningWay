package com.cashsystem.cmd;

import com.cashsystem.entity.Account;

/**
 * @Classname Subject
 * @Description TODO
 * @Date 2019/8/4 11:49
 * @Created by AppleTree
 */
public class Subject {

    private Account account;
    public void setAccount(Account account){
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }
}
