package MyTest;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2019/5/19 17:48
 * @Created by AppleTree
 */
public class Person {
    public String name;
    private int age;
    private int id;
    public String face;

    public Person() {
    }

    public Person(String name, int age, int id, String face) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
