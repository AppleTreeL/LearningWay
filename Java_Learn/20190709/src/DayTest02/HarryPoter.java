package DayTest02;

import java.util.Scanner;

/**
 * @Classname HarryPoter
 * @Description 如果你是哈利·波特迷，
 * 你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：
 * “十七个银西可(Sickle)兑一个加隆(Galleon)，二
 * @Date 2019/8/6 22:25
 * @Created by AppleTree
 */
public class HarryPoter {

    public static boolean judgeLegalThird(int num) {
        if(num < 0 || num >= 29) return false;
        else return true;
    }

    public static boolean judgeLegalSecond(int num) {
        if(num < 0 || num >= 17) return false;
        else return true;
    }
    public static boolean judgeLegalFirst(int num) {
        if(num < 0 || num > (Math.pow(10, 7))) return false;
        else return true;
    }

    public static String dec(String operA, String operB) {
        String[] operAs = operA.split("\\.");
        int firstA = Integer.valueOf(operAs[0]);
        if(!judgeLegalFirst(firstA)) return null;

        int secondA = Integer.valueOf(operAs[1]);
        if(!judgeLegalSecond(secondA)) return null;

        int thirdA = Integer.valueOf(operAs[2]);
        if(!judgeLegalThird(thirdA)) return null;

        String[] operBs = operB.split("\\.");
        int firstB = Integer.valueOf(operBs[0]);
        if(!judgeLegalFirst(firstB)) return null;

        int secondB = Integer.valueOf(operBs[1]);
        if(!judgeLegalSecond(secondB)) return null;

        int thirdB = Integer.valueOf(operBs[2]);
        if(!judgeLegalThird(thirdB)) return null;

        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        if(thirdA - thirdB < 0) {
            secondA -= 1;
            res3 = 29 - thirdB + thirdA;
        }else {
            res3 = thirdA - thirdB;
        }

        if(secondA - secondB < 0) {
            firstA -= 1;
            res2 = 17 - secondB + secondA;
        }else {
            res2 = secondA - secondB;
        }

        res1 = firstA - firstB;

        StringBuilder stringBuilder = new StringBuilder();
        if(res1 < 0) {
            stringBuilder.append(res1).append(".").append(res2).append(".")
                    .append(res3);
        }else {
            stringBuilder.append(res1).append(".").append(res2).append(".")
                    .append(res3);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operA = scanner.next();
        String operB = scanner.next();
        System.out.println(dec(operB, operA));
        //System.out.println(dec("13.2.0", "14.0.0"));
        //System.out.println(Integer.valueOf("-3"));
    }
}