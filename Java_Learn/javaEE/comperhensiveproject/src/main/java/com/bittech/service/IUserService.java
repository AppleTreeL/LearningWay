package com.bittech.service;

import com.bittech.po.User;

import java.util.List;

/**
 * @Classname IUserService
 * @Description TODO
 * @Date 2019/8/8 19:41
 * @Created by AppleTree
 */
public interface IUserService {

    public List<User> queryUserService() throws Exception;

}
