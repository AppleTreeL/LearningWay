package DayQuestionTest;

import java.util.Scanner;

/**
 * @Classname DayQuestionTest.countStudents
 * @Description TODO
 * @Date 2019/7/19 21:15
 * @Created by AppleTree
 */
public class countStudents {

    public static int count(int[] array, int aimCore) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == aimCore){
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int students = in.nextInt();
        int[] array = new int[students];
        for (int i = 0; i < students; i++) {
            array[i] = in.nextInt();
        }
        int aimCore = in.nextInt();
        System.out.println(count(array, aimCore));
    }

}
