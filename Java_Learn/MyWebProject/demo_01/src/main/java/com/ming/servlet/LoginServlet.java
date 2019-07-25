package com.ming.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname LoginServlet
 * @Description TODO
 * @Date 2019/7/24 20:18
 * @Created by AppleTree
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String form_name = req.getParameter("username");
        String form_pass = req.getParameter("password");
        if(form_name.equals("admin") && form_pass=="123"){
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("failed.jsp").forward(req,resp);
        }
    }
}
