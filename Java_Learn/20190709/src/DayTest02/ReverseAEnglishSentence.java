package DayTest02;

import java.util.Scanner;

/**
 * @Classname ReverseAEnglishSentence
 * @Description TODO
 * @Date 2019/8/5 22:55
 * @Created by AppleTree
 */
public class ReverseAEnglishSentence {

    public static String reverseSentence(String str) {
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i --) {
            stringBuilder.append(strings[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim();
        System.out.println(reverseSentence(str));
    }
}
