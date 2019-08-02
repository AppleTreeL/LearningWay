package com.qing.demo1;

import org.springframework.format.annotation.DateTimeFormat;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname ConvertDate
 * @Description TODO
 * @Date 2019/8/2 14:12
 * @Created by AppleTree
 */
public class ConvertDate extends PropertyEditorSupport {

    public String pattern = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text=" + text);

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = simpleDateFormat.parse(text);
            this.setValue(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
