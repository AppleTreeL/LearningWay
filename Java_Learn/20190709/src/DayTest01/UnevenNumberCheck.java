package DayTest01;

import java.util.Scanner;

/**
 * @Classname UnevenNumberCheck
 * @Description 奇校验
 * @Date 2019/8/5 18:49
 * @Created by AppleTree
 */
public class UnevenNumberCheck {

    public static boolean checkEven(String num){
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '1'){
                count += 1;
            }
        }
        return count % 2 == 0;
    }

    public static String eightBitUnevenOut(String num) {
        StringBuilder stringBuilder = new StringBuilder(num);
        stringBuilder.reverse();
        int bitsNum = stringBuilder.length();

        while (bitsNum < 8){
            stringBuilder.append("0");
            bitsNum += 1;
        }
        if(checkEven(num)) {
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "1");
            return stringBuilder.reverse().toString();
        }else {
            return stringBuilder.reverse().toString();
        }
    }

    public static void unevenNumberCheck(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String binary = Integer.toBinaryString(chars[i]);

            System.out.println(eightBitUnevenOut(binary));

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            unevenNumberCheck(str);
        }

    }

}
