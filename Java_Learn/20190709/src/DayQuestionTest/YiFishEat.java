package DayQuestionTest;

import java.util.Scanner;

/**
 * @Classname DayQuestionTest.YiFishEat
 * @Description TODO
 * @Date 2019/7/17 12:45
 * @Created by AppleTree
 */
public class YiFishEat {

    public static int countStep(int init){
        if(init < 1 || init > 1000000006) throw new IllegalArgumentException("参数越界" + init);
        //int count = 0;
        for (int i = 0; i < 100000; i++) {

            if(init % 1000000007 == 0 && init >= 1000000007){
                return i;
            }
            if(init % 1000000007 == 0 && init >= 1000000007 && (4 * init + 7) % 1000000007 == 0){
                return i + 1;
            }
            init = 8 * init + 7;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int init = in.nextInt();
        System.out.println(countStep(init));
    }
}
