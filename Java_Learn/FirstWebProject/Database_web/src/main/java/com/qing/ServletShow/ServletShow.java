package com.qing.ServletShow;

import com.qing.DBTools.DBManager;
import com.qing.demo.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ServletShow
 * @Description TODO
 * @Date 2019/7/29 19:02
 * @Created by AppleTree
 */

@WebServlet(urlPatterns = "/servletShow")
public class ServletShow extends HttpServlet {

    //public static DBManager dbManager = new DBManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<Employee> employees= new ArrayList<>();
        DBManager dbManager = new DBManager();
        ResultSet res = dbManager.queryMethod("select employeeId,employeeName,departNum from employee;");

        try {
            while (res.next()) {
                Employee employee = new Employee(res.getInt("employeeId"),
                        res.getString("employeeName"),
                        res.getInt("departNum"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //ServletShow.java
        for (int i = 0; i < employees.size(); i++) {
            req.setAttribute("employeeName" + i + "", employees.get(i).getEmployeeName());
        }
        for (int i = 0; i < employees.size(); i++) {
            req.setAttribute("employeeLocation" + i + "", employees.get(i).getLocation());
        }
        req.getRequestDispatcher("employeeShow.jsp").forward(req,resp);
        //dbManager.closeDB();
    }
}
