package DayQuestionTest;

import java.util.*;

/**
 * @Classname DayQuestionTest.SortScore
 * @Description TODO
 * @Date 2019/7/22 20:11
 * @Created by AppleTree
 */

//class DayQuestionTest.Student {
//    public String name;
//    public int score;
//
//    public DayQuestionTest.Student(String name, int score) {
//        this.name = name;
//        this.score = score;
//    }
//}

class Student implements Comparable<Student> {

    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }
}

public class SortScore {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<Student> students = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            String name = in.next();
            int score = in.nextInt();
            students.add(new Student(name, score));
        }
        Collections.sort(students);
        for (int i = 0; i < num; i++) {
            System.out.println(students.get(i).name + " " + students.get(i).score);
        }
    }
}
/*
3
fang 90
yang 50
ning 70
 */
