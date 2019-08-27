package com.qing.tools;

import java.sql.*;

/**
 * @Classname DbConfig
 * @Description TODO
 * @Date 2019/8/26 16:15
 * @Created by AppleTree
 */
public class DbConfig {

    @Deprecated
    public static Connection getConnectionOld() {
        String username = "root";
        String password = "13488204166";
        String url = "jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection() {
        PropertiesUtils.loadFile("db.properties");
        String url = PropertiesUtils.getPropertyValue("jdbc.url");
        String username = PropertiesUtils.getPropertyValue("jdbc.username");
        String password = PropertiesUtils.getPropertyValue("jdbc.password");
        String driver = PropertiesUtils.getPropertyValue("jdbc.driver");
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
