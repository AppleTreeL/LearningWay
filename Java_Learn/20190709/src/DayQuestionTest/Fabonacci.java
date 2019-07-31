package DayQuestionTest;
import java.util.Scanner;

/**
 * @Classname Fabonacci
 * @Description TODO
 * @Date 2019/7/25 23:48
 * @Created by AppleTree
 */
public class Fabonacci {

    public static int fabinacci(int month){
        if(month == 1 || month == 2){
            return 1;
        }
        if(month > 78)
            throw new IllegalArgumentException("参数越界" + month);
        int fn1 = 1;
        int fn2 = 1;
        int res = 0;
        for (int i = 3; i <= month; i++) {
            res = fn1 + fn2;
            fn1 = fn2;
            fn2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        System.out.println(fabinacci(month));
    }

}
