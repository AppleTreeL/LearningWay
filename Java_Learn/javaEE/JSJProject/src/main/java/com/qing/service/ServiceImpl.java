package com.qing.service;

import com.qing.dao.DBManager;
import com.qing.po.UserDao;

import java.util.List;

/**
 * @Classname ServiceImpl
 * @Description TODO
 * @Date 2019/8/26 20:18
 * @Created by AppleTree
 */
public class ServiceImpl implements Service {

    DBManager dbManager = new DBManager();

    @Override
    public List<UserDao> queyItem() {
        return this.dbManager.queryUserItem();
    }
}
