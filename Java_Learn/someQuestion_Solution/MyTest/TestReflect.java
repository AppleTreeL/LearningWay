package MyTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname TestReflect
 * @Description TODO
 * @Date 2019/5/19 17:52
 * @Created by AppleTree
 */
public class TestReflect {
    public static void main(String[] args) {
        Person person = new Person();
        Student student = new Student();
        Class<?> object = person.getClass();
        Class<?> objectStudent = student.getClass();

        try {
            Object obj = object.newInstance();
            Method getAge = (Method) object.getMethod("getAge");
            System.out.println("Age: " + getAge.invoke(obj));
            Method getId = (Method) object.getMethod("getId");
            System.out.println("ID: " + getId.invoke(obj));


            Field[] fields = object.getFields(); // only can get the public field, and it can get super fileds and son fields
            for (Field field: fields) {
                System.out.println(field);
            }
            System.out.println("+++++++++++++");

            Field[] fields1 = object.getDeclaredFields();//can get all the fields, and it can only get son's;
            for (Field field: fields1) {
                System.out.println(field);
            }

            System.out.println("Student show:");
            Field[] fields2 = objectStudent.getDeclaredFields();
            for(Field field: fields2) {
                System.out.println(field);
            }
            System.out.println("=======");

            Field[] fields3 = objectStudent.getFields();
            for(Field field: fields3) {
                System.out.println(field);
            }



            System.out.println("operate the reflected field");
            Field nameField = object.getDeclaredField("name");

            System.out.println(nameField);

            nameField.setAccessible(true);

            nameField.set(obj, "Calvin");
            System.out.println(person.face);
            System.out.println(nameField.get(obj));


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
