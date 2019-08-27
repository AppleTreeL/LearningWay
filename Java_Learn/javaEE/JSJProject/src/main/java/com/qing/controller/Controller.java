package com.qing.controller;

import com.qing.po.User;
import com.qing.po.UserDao;
import com.qing.service.Service;
import com.qing.service.ServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Classname Controller
 * @Description TODO
 * @Date 2019/8/26 20:10
 * @Created by AppleTree
 */

@WebService(name = "/query")
public class Controller extends HttpServlet {
    Service service = new ServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //1.获取表单参数
        //2.调用业务逻辑
        List<UserDao> userDaoList = this.service.queyItem();
        //3.转发
        req.setAttribute("userdaolist", userDaoList);
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
