package MyTest;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2019/5/19 20:57
 * @Created by AppleTree
 */
public class Student extends Person {
    private int studentId;
    private int college;

    public Student() {

    }

    public Student(int studentId, int college) {
        this.studentId = studentId;
        this.college = college;
    }

    public Student(String name, int age, int id, String face, int studentId, int college) {
        super(name, age, id, face);
        this.studentId = studentId;
        this.college = college;
    }

}
