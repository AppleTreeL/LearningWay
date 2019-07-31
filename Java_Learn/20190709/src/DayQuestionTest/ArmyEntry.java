package DayQuestionTest;

import java.util.Scanner;

/**
 * @Classname ArmyEntry
 * @Description TODO
 * @Date 2019/7/26 0:24
 * @Created by AppleTree
 */
public class ArmyEntry {

    public static String removeBank(String origion){
        StringBuilder afterDeal = new StringBuilder();
        for (int i = 0; i < origion.length(); i++) {
            if(origion.charAt(i) != ' ')
                afterDeal.append(origion.charAt(i));
        }
        return afterDeal.toString();
    }

    //数组循环右移
    public static String circleRight(String origion){
        String afterDeal = removeBank(origion);
        char[] temp = afterDeal.toCharArray();
        char tempMax = temp[temp.length - 1];
        for (int i = afterDeal.length() - 1; i > 0; i--) {
            temp[i] = temp[i-1];
        }
        temp[0] = tempMax;
        return String.valueOf(temp);
    }

    //之后的第五个字母加密
    public static String entry(String origion){
        String str = removeBank(origion);
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 5; i < str.length(); i++) {
            res.append(str.charAt(i));
        }
        //res.append(" ");
        for (int i = 0; i < str.length() - 5; i++) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String origion = in.nextLine();
            String res = origion;
            for (int i = 0; i < 5; i++) {
                res = circleRight(res);
            }
            System.out.println(res);
        }
//        String str = "abd";
//        System.out.println(circleRight(str));
    }

}
