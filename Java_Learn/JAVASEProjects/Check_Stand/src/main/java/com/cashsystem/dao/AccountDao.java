package com.cashsystem.dao;

import com.cashsystem.common.AcountStatus;
import com.cashsystem.common.AcountType;
import com.cashsystem.entity.Account;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    //解析用户
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

//    public void register(String username, String password, String name,
//                            int account_type, int account_stsatus) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        //Account account = null;
//        int res = 0;
//        try {
//            connection = getConnection(true);
//            System.out.println("连接成功........");
//            String sql =
//                    "insert into account (username, password, name, account_type, account_status) values (?, ?, ?, ?, ?)";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,username);
//            preparedStatement.setString(2, DigestUtils.md5Hex(password));
//            preparedStatement.setString(3, name);
//            preparedStatement.setInt(4, account_type);
//            preparedStatement.setInt(5, account_stsatus);
//            res = preparedStatement.executeUpdate();
//            if(res <= 0) {
//                System.out.println("注册失败........");
//            }else {
//                System.out.println("注册成功........");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public boolean register(Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String sql = "insert into account(username, password, name, account_type, account_status) values " +
                    "(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, DigestUtils.md5Hex(account.getPassword()));
            preparedStatement.setString(3, account.getName());
            preparedStatement.setInt(4, account.getAcountType().getFlag());
            preparedStatement.setInt(5, account.getAcountStatus().getFlag());
            effect = (preparedStatement.executeUpdate() == 1);
            resultSet = preparedStatement.getGeneratedKeys(); // 获取自增的主键
            if(resultSet.next()){
                Integer id = resultSet.getInt(1);
                account.setId(id);
            }
            //return effect;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource(resultSet, preparedStatement, connection);
        }
        return effect;
    }

    //查询所有用户
    public List<Account> queryAllAccounts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Account> list = new ArrayList<>();

        try {
            connection = this.getConnection(true);
            String sql = "select * from account";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Account account = this.extractAccount(resultSet);
                if(account != null) {
                    list.add(account);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResource(resultSet, preparedStatement, connection);
        }
        return list;
    }

    public Account getAccount(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Account account = null;

        try{
            connection = this.getConnection(true);
            String sql = "select * from account where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                account = this.extractAccount(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource(resultSet, preparedStatement, connection);
        }
        return account;
    }

    public boolean updatePassword(int id, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean effect = false;

        try {
            connection = this.getConnection(true);
            String sql = "update account set password=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, DigestUtils.md5Hex(password));
            effect = (preparedStatement.executeUpdate() == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource(null, preparedStatement, connection);
        }
        return effect;
    }
    //解析用户
//    public Account extractAccount(ResultSet resultSet) {
//        Account account = new Account();
//        try {
//            account.setId(resultSet.getInt("id"));
//            account.setUsername(resultSet.getString("username"));
//            account.setPassword(resultSet.getString("password"));
//            account.setName(resultSet.getString("name"));
//            account.setAcountType(AcountType.valueOf(resultSet.getInt("account_type")));
//            account.setAcountStatus(AcountStatus.valueOf(resultSet.getInt("account_status")));
//            return account;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return account;
//    }

    public boolean setAccountStatus(int id, int account_status) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean effect = false;

        try{
            connection = this.getConnection(true);
            String sql = "update account set account_status=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,account_status);
            preparedStatement.setInt(2, id);
            effect = (preparedStatement.executeUpdate() == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource(null, preparedStatement, connection);
        }
        return effect;
    }
}
