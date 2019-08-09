package com.qing.MybatisTest;

import com.qing.bz.UserBz;
import com.qing.mapper.UserMapper;
import com.qing.po.User;
import com.qing.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname TestMyBatis
 * @Description TODO
 * @Date 2019/8/9 16:17
 * @Created by AppleTree
 */


public class TestMyBatis {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void initMethod() {
        String file = "sqlMapConfig.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByZH () {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try{
//        UserEx userEx = new UserEx();
//        userEx.setSex("2");
//        userEx.setUsername("vin");
//
//        UserBz userBz = new UserBz();
//        userBz.setUserEx(userEx);
//
//        System.out.println(userBz);
//
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//            List<UserEx> userExList = userMapper.queryUserZH(userBz);
//            System.out.println(userExList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("vin");
            UserBz userBz = new UserBz();
            userBz.setUserEx(userEx);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExList = userMapper.queryUserZH(userBz);
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void queryUserToItemsTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper ordersMapper =  sqlSession.getMapper(UserMapper.class);
            List<User> ordersList =  ordersMapper.queryUserToItems();
            System.out.println(ordersList);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

}
