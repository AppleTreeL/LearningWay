package DayQuestionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException{

    private int age;
    private int year;

    public TestException() {
    }

    public void TestException() {
        System.out.println("i can");
    }

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "text.txt");
        try{
            new TestException().TestException();
            FileInputStream in = new FileInputStream(file);
        }catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }catch(IndexOutOfBoundsException e3){
            e3.printStackTrace();
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }
}