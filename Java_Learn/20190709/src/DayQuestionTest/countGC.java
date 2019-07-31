package DayQuestionTest;

import java.util.Scanner;

/**
 * @Classname DayQuestionTest.countGC
 * @Description TODO
 * @Date 2019/7/20 20:06
 * @Created by AppleTree
 */
public class countGC {

    public static String findLongestGC(String str, int n){
        int count = 0;
        int max = 0;
        StringBuilder temp = new StringBuilder();
        String maxString = null;
        for (int i = 0; i < str.length() - n; i++) {
            for (int j = i; j < i+n; j++) {
                if(str.charAt(j) == 'G' || str.charAt(j) == 'C'){
                    count += 1;
                }
                temp.append(str.charAt(j));
            }
            if(count > max){
                max = count;
                //ount = 0;
                maxString = temp.toString();
            }
            temp.delete(0,temp.length());
            count = 0;
        }
        return maxString;
    }

    public static void main(String[] args) {
        //System.out.println(findLongestGC("AACTGTGCACGACCTGA", 5));
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != 'A' && str.charAt(i) != 'C' && str.charAt(i) != 'G' && str.charAt(i) != 'T'){
                throw new IllegalArgumentException("您传入的序列有误"+str);
            }
        }
        System.out.println(findLongestGC(str, n));
    }

}
