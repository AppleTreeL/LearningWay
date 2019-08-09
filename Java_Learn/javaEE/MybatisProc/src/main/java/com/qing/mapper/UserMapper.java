package com.qing.mapper;

import com.qing.bz.UserBz;
import com.qing.po.User;
import com.qing.po.UserEx;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2019/8/9 16:06
 * @Created by AppleTree
 */
public interface UserMapper {

    public List<UserEx> queryUserZH (UserBz userBz) throws Exception;
    public List<User> queryUserToItems() throws Exception;
    public List<UserEx> queryOrderToItems() throws Exception; //queryUserToItems

}
