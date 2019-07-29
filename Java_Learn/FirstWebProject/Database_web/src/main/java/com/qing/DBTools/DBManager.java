package com.qing.DBTools;

import com.qing.demo.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DBManager
 * @Description TODO
 * @Date 2019/7/29 17:31
 * @Created by AppleTree
 */
public class DBManager {

    private static Connection connection = getConnection();
    private Statement preparedStatement;
    private ResultSet res = null;

    public  static Connection getConnection(){
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            System.out.println("loading driver sucess........");
            String name = "root";
            String password = "13488204166";
            //com\mysql\jdbc\Driver.class
            String url = "jdbc:mysql://localhost:3306/mytest";
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("connect to DB successfully.......");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //insert update delete
    public int nonQueuryMethod(String sql){
        int flag = 0;
        //connection = this.getConnection();
        try {
            preparedStatement = connection.createStatement();
            flag = preparedStatement.executeUpdate(sql);
            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //select
    public ResultSet queryMethod(String sql){
        //connection = getConnection();
        try {
            preparedStatement = connection.createStatement();
            res = preparedStatement.executeQuery(sql);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void closeDB(){
        try {
            if (res != null) res.close();
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        DBManager dbManager = new DBManager();
//        List<Employee> employees= new ArrayList<>();
//        ResultSet res = dbManager.queryMethod("select employeeId,employeeName,departNum from employee;");
//        try{
//            while (res.next()) {
//                Employee employee = new Employee(res.getInt("employeeId"),
//                        res.getString("employeeName"),
//                        res.getInt("departNum"));
//                employees.add(employee);
//            }
//            for (int i = 0; i < employees.size(); i++) {
//                System.out.println("employeeName[" + i + "]" + employees.get(i).getEmployeeName());
//            }
//            System.out.println("successfully select");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
