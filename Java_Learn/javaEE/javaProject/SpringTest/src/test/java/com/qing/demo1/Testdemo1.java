package com.qing.demo1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname Testdemo1
 * @Description TODO
 * @Date 2019/8/2 13:32
 * @Created by AppleTree
 */
public class Testdemo1 {

    private ApplicationContext context = null;

    @Before
    public void initMethod(){
        context = new ClassPathXmlApplicationContext("applicationContext-beans.xml");
    }

    @Test
    public void testDemo1() {
        Person person = (Person)context.getBean("person");
        System.out.println(person);
    }

}
