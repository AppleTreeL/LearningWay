package com.ming.service;

import com.ming.mapper.UserMapper;
import com.ming.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * query all users
     * @return List<User> UserList
     * @throws Exception
     */
    @Override
    public List<User> queryUserService() throws Exception {
        return userMapper.queryUserList();
    }

    @Override
    public User queryUserById(int id) throws Exception {
        return userMapper.queryUserById(id);
    }

    /**
     * delete users by given IDs
     * @param ids, the number of id recorded Users who are pointed
     * @throws Exception
     */
    @Override
    public void deleteUsersService(int[] ids) throws Exception {
        userMapper.deleteUsersById(ids);
    }



}
