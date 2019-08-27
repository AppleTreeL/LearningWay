package com.qing.tools;

import java.io.IOException;
import java.util.Properties;

/**
 * @Classname PropertiesUtils
 * @Description TODO
 * @Date 2019/8/26 19:41
 * @Created by AppleTree
 */
public class PropertiesUtils {

    static Properties properties = new Properties();

    public static boolean loadFile(String fileName) {
        try{
            properties.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getPropertyValue(String value) {
        return (String) PropertiesUtils.properties.get(value);
    }

}
