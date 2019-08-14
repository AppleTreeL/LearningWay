package com.ming.service;

import com.ming.po.User;

import java.util.List;

public interface UserService {

    public List<User> queryUserService() throws Exception;

    public User queryUserById(int id) throws Exception;

    public void deleteUsersService(int[] ids) throws Exception;
}
