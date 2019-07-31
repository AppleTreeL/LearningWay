package DayQuestionTest;

import java.util.Scanner;
import java.lang.StringBuilder;

/**
 * @Classname DayQuestionTest.GetSequeOdd
 * @Description TODO
 * @Date 2019/7/16 12:13
 * @Created by AppleTree
 */
public class GetSequeOdd {

    /**
     * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和
     * @param m, the data you input
     * @return a String contain the result
     */
    public static String GetSequeOdd(int m){
        if(m < 0|| m > 100) throw new UnsupportedOperationException("参数"+m+"超过支持的范围");
        int start = 1;
        //int temp = 0;
        int circleCount = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < i; j ++){
                circleCount += 1;
            }
        }
        for(int i = 0; i < circleCount-m; i ++){
            start += 2;
        }
        int res = start;
        StringBuilder nums = new StringBuilder();
        nums.append(start);
        nums.append("+");
        while (res != Math.pow(m, 3)){
            start = start + 2;
            res = res + start;
            nums.append(start);
            nums.append("+");
        }
        nums.deleteCharAt(nums.length() - 1);
        return nums.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        System.out.println(GetSequeOdd(m));
    }
}
