package com.qing.dao;

import com.qing.po.UserDao;
import com.qing.tools.DbConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DBManager
 * @Description TODO
 * @Date 2019/8/26 20:23
 * @Created by AppleTree
 */
public class DBManager {

    public List<UserDao> queryUserItem() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        List<UserDao> userDaoList = new ArrayList<>();
        try{
            connection = DbConfig.getConnection();
            String sql = "select user.id, name, shopname from user, item where user.id=item.user_id";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                userDaoList.add(this.extractUserDao(resultSet));
            }
            return userDaoList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DbConfig.closeResource(resultSet, statement, connection);
        }
    }

    public UserDao extractUserDao(ResultSet resultSet) {
        UserDao userDao = new UserDao();
        try{
            userDao.setId(resultSet.getInt("id"));
            userDao.setShopname(resultSet.getString("shopname"));
            userDao.setName(resultSet.getString("name"));
            return userDao;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
