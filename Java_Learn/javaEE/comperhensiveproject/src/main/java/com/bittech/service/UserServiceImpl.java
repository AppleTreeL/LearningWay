package com.bittech.service;

import com.bittech.dao.UserDAO;
import com.bittech.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/8/8 19:42
 * @Created by AppleTree
 */

@Service
public class UserServiceImpl implements IUserService{

    private SqlSessionFactory sqlSessionFactory;

    public UserServiceImpl() {
//        String file = "sqlMapConfig.xml";
//        InputStream is = null;
//        try {
//            is = Resources.getResourceAsStream(file);
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        String file = "sqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            return sqlSessionFactory;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Autowired
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> queryUserService() throws Exception {
        //return userDAO.queryUserDAO();
        SqlSession sqlSession =this.getSqlSessionFactory().openSession();
        List<User> list = sqlSession.selectList("test.queryUserById");
        return list;
    }
}
