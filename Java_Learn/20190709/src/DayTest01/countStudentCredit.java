package DayTest01;

import java.util.Scanner;

/**
 * @Classname countStudentCredit
 * @Description TODO
 * @Date 2019/7/30 11:37
 * @Created by AppleTree
 */
public class countStudentCredit {

    public static double judge(int score){
        if(score >= 90 && score <= 100) return 4.0;
        if(score >= 85 && score <= 89) return 3.7;
        if(score >= 82 && score <= 84) return 3.3;
        if(score >= 78 && score <= 81) return 3.0;
        if(score >= 75 && score <= 77) return 2.7;
        if(score >= 72 && score <= 74) return 2.3;
        if(score >= 68 && score <= 71) return 2.0;
        if(score >= 64 && score <= 67) return 1.5;
        if(score >= 60 && score <= 63) return 1.0;
        if(score < 60) return 0.0;
        return 0;
    }



    public static double studentCredit(int[] credit, int[] score) {
        double jidianSum = 0;
        for (int i = 0; i < score.length; i++) {
            jidianSum += (judge(score[i]) * credit[i]);
        }
        double sumCredit = 0;
        for (int i = 0; i < credit.length; i++) {
            sumCredit += credit[i];
        }
        double res =  jidianSum / sumCredit;
        StringBuilder resRight = new StringBuilder(String.valueOf(res));
        int i = 0;
        for (i = 0; i < resRight.length(); i++) {
            if(resRight.charAt(i) == '.'){
                break;
            }
        }

        if(resRight.charAt(i + 1) == ' '){
            return Double.valueOf(resRight.toString());
        }else {
            if(resRight.charAt(i + 2) == ' '){
                return Double.valueOf(resRight.toString());
            }else {
                if(resRight.charAt(i + 3) == ' '){
                    return Double.valueOf(resRight.toString());
                }else {
                    if(resRight.charAt(i + 3) > 4){
                        int temp = resRight.charAt(i + 2) - 48;
                        temp += 1;
                        resRight.replace(i + 2, i + 3, String.valueOf(temp));
                        resRight.delete(i + 3, resRight.length());
                        return Double.valueOf(resRight.toString());
                    }else {
                        resRight.delete(i + 3, resRight.length());
                        return Double.valueOf(resRight.toString());
                    }
                }
//                if(resRight.charAt(i + 2) > 4){
//                    int temp = resRight.charAt(i + 1) - 48;
//                    temp += 1;
//                    resRight.replace(i + 1, i + 2, String.valueOf(temp));
//                    resRight.delete(i + 2, resRight.length());
//                    return Double.valueOf(resRight.toString());
//                }else {
//                    resRight.delete(i + 2, resRight.length());
//                    return Double.valueOf(resRight.toString());
//                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int subjectSum = in.nextInt();
        int[] credit = new int[subjectSum];
        int[] score = new int[subjectSum];
        for (int i = 0; i < subjectSum; i++) {
            credit[i] = in.nextInt();
        }
        for (int i = 0; i < subjectSum; i++) {
            score[i] = in.nextInt();
        }
//        int[] credit = {4, 3, 4, 2, 3};
//        int[] score = {91, 88, 72, 69, 56};
        System.out.println(studentCredit(credit, score));
    }
    //5
    //4 3 4 2 3
    //91 88 72 69 56
}
