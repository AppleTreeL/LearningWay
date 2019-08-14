package com.ming.mapper;

import com.ming.po.User;
import java.util.List;

public interface UserMapper {

    public List<User> queryUserList() throws Exception;

    //根据ID查
    public User queryUserById(int id) throws Exception;
    //根据名称查
    public User queryUserByName(String tempName) throws Exception;
    //删除
    public void deleteUsersById(int[] ids) throws Exception;
    //修改
    //插入

}
