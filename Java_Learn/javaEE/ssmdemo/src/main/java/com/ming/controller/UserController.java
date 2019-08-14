package com.ming.controller;


import com.ming.po.User;
import com.ming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
//@RequestMapping(value = "/do")
public class UserController{

    @Autowired
    private UserService userService;

     //query all users
    @RequestMapping(value = "/queryUser")
    public ModelAndView queryUserController() throws Exception{

        List<User> userList =  userService.queryUserService();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userListKey",userList);
        modelAndView.setViewName("userlist");

        return modelAndView;
    }


    @RequestMapping(value = "/queryUserById")
    public ModelAndView queryUserById(String id) throws Exception{
        User user = userService.queryUserById(Integer.parseInt(id));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userKey", user);
        modelAndView.setViewName("userShow");

        return modelAndView;
    }

    @RequestMapping(value = "/deleteUsersById")
    public ModelAndView deleteUsersById(int[] ids) throws Exception {
        for (int it:ids) {
            System.out.println(it);
        }
        userService.deleteUsersService(ids);

        return new ModelAndView("redirect:/queryUser");
    }

//    @RequestMapping(value = "/queryUserById")
//    public ModelAndView queryUserByName(User user) {
//        //TODO
//    }
}
