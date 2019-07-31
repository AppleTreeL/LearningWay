package DayTest01;

import java.util.Scanner;

/**
 * @Classname PowAndSum
 * @Description TODO
 * @Date 2019/7/31 11:02
 * @Created by AppleTree
 */
public class PowAndSum {

    public static int getSum(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum = sum + (chars[i] - 48);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            int pow = (int) Math.pow(num, 2);
            System.out.println(getSum(num)+" "+getSum(pow));
        }
    }
}
