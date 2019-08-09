package com.bittech.controller;

import com.bittech.po.User;
import com.bittech.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Classname ShowUserController
 * @Description TODO
 * @Date 2019/8/8 19:40
 * @Created by AppleTree
 */

@Controller
public class ShowUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/showUserList")
    public ModelAndView showUserList() throws Exception{

        List<User> userList =  userService.queryUserService();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userListKey",userList);
        modelAndView.setViewName("showuser");
        return modelAndView;
    }

}
