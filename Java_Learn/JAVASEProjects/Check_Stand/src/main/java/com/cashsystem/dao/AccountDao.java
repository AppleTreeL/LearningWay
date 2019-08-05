package com.cashsystem.dao;

import com.cashsystem.common.AcountStatus;
import com.cashsystem.common.AcountType;
import com.cashsystem.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Classname AccountDao
 * @Description TODO
 * @Date 2019/8/4 16:30
 * @Created by AppleTree
 */
public class AccountDao extends BaseDao {

    //操作数据库
    public Account login(String username, String password){
        //System.out.println("SQL 链接开始......");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = null;
        try {
            //get the connection to database
            connection = this.getConnection(true);
            System.out.println("获取连接成功.........");
            String sql = "select id, username, password, name, account_type, account_status from account where username=? and password=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //解析ResultSet,拿到对应的account
                account = this.extractAccount(resultSet);
                System.out.println("已经获取");
            }
            return account;
        }catch (SQLException e) {
            System.out.println("??????");
        }
        return account;
    }

    private Account extractAccount(ResultSet resultSet) {
        Account account = new Account();
        try {
            account.setId(resultSet.getInt("id"));
            account.setUsername(resultSet.getString("username"));
            account.setName(resultSet.getString("name"));
            account.setPassword(resultSet.getString("password"));
            account.setAcountType(AcountType.valueOf(resultSet.getInt("account_type")));
            account.setAcountStatus(AcountStatus.valueOf(resultSet.getInt("account_status")));
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void register(String username, String password, String name,
                            int account_type, int account_stsatus) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //Account account = null;
        int res = 0;
        try {
            connection = getConnection(true);
            System.out.println("连接成功........");
            String sql =
                    "insert into account (username, password, name, account_type, account_status) values (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, DigestUtils.md5Hex(password));
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, account_type);
            preparedStatement.setInt(5, account_stsatus);
            res = preparedStatement.executeUpdate();
            if(res <= 0) {
                System.out.println("注册失败........");
            }else {
                System.out.println("注册成功........");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
