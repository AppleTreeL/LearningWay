package com.cashsystem.service;

import com.cashsystem.dao.AccountDao;
import com.cashsystem.entity.Account;

import java.sql.SQLException;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2019/8/4 16:28
 * @Created by AppleTree
 */
public class AccountService {
    public AccountDao accountDao;
    public AccountService() {
        this.accountDao = new AccountDao();
    }

    public Account login(String username, String password){
        System.out.println("开始登录..........");
        return this.accountDao.login(username, password);
    }

    public void register(String username, String password, String name,
                            int account_type, int account_stsatus){
        System.out.println("开始注册......");
        this.accountDao.register(username, password, name,
                account_type, account_stsatus);
    }
}