package com.cashsystem.service;

import com.cashsystem.dao.AccountDao;
import com.cashsystem.entity.Account;


import java.util.List;

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

    /**
     * 实现用户登录，根据用账号和密码
     * @param username
     * @param password
     * @return
     */
    public Account login(String username, String password){
        System.out.println("开始登录..........");
        return this.accountDao.login(username, password);
    }

    //我的
//    public void register(String username, String password, String name,
//                            int account_type, int account_stsatus){
//        System.out.println("开始注册......");
//        this.accountDao.register(username, password, name,
//                account_type, account_stsatus);
//    }

    /**
     * 实现用户账户的注册
     * @param account，用户对象
     * @return 成功返回true， 否则返回false
     */
    public boolean register(Account account){
        System.out.println("开始注册......");
        return this.accountDao.register(account);
    }

    /**
     * 查询虽有在册用户
     * @return 返回在册用户组成的一个列表
     */
    public List<Account> queryAllAccounts() {
        System.out.println("开始查询.....");
        return this.accountDao.queryAllAccounts();
    }

    /**
     * 根据id获取具体账户信息
     * @param id，用户唯一的一个编号
     * @return 返回一个用户对象
     */
    public Account getAccount(int id) {
        return this.accountDao.getAccount(id);
    }

    /**
     * 根据所给的新密码更新具体账户的旧密码
     * @param password，new password
     * @return a boolean value
     */
    public boolean updatePassword(int id, String password) {
        return this.accountDao.updatePassword(id, password);
    }

    /**
     * 设置账户的启用启用状态，或者禁用状态
     * @param id，要进行操作的用户编号
     * @param account_status，要设置的状态
     * @return 设置成功返回true， 否则返回false
     */
    public boolean setAccountStatus(int id, int account_status) {
        return this.accountDao.setAccountStatus(id, account_status);
    }

}