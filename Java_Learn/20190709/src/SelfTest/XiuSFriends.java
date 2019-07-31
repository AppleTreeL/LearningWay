package SelfTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * @Classname XiuSFriends
 * @Description TODO
 * @Date 2019/7/23 11:39
 * @Created by AppleTree
 */
class student{
    public String name;
    public int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class XiuSFriends {


    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("haha");
        set.add("hehe");
        set.add("heihei");
        for (String it:set) {
            System.out.println(it);
        }
    }

    public static void main1(String[] args) {
        //创建大集合
        ArrayList<ArrayList<student>> bigArrayList;
        bigArrayList = new ArrayList<ArrayList<student>>();

        //创建三个班级集合
        ArrayList<student> s1 = new ArrayList<student>();
        ArrayList<student> s2 = new ArrayList<student>();
        ArrayList<student> s3 = new ArrayList<student>();
        //创建第一个班级的的三个学生
        student t1 = new student("辣条", 18);
        student t2 = new student("火腿", 20);
        student t3 = new student("豆干", 16);
        s1.add(t1);
        s1.add(t2);
        s1.add(t3);
        //创建第二个班级的三个学生
        student u1 = new student("老酸奶", 5);
        student u2 = new student("安慕希", 8);
        student u3 = new student("纯甄", 6);

        s2.add(u1);
        s2.add(u2);
        s2.add(u3);
        //创建第3个班级的三个学生
        student d1 = new student("寿司", 12);
        student d2 = new student("小丸子", 8);
        student d3 = new student("烤肉", 22);
        s3.add(u1);
        s3.add(u2);
        s3.add(u3);

        bigArrayList.add(s1);
        bigArrayList.add(s2);
        bigArrayList.add(s3);
        for (ArrayList<student> w : bigArrayList) {
            for (student ww : w) {
                System.out.println(ww.name+" "+ww.age);
            }
        }
    }

}
