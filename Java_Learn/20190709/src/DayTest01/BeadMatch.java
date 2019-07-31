package DayTest01;

import java.util.Scanner;

/**
 * @Classname BeadMatch
 * @Description TODO
 * @Date 2019/7/26 20:34
 * @Created by AppleTree
 */
public class BeadMatch {

    public static void judgeBuy(String merchant, String iNeed){
        int countI = 0;
        int countB = 0;
        int lack = 0;
        for (int i = 0; i < iNeed.length(); i++) {
            char temp = iNeed.charAt(i);
            for (int j = 0; j < iNeed.length(); j++) {
                if(temp == iNeed.charAt(j)){
                    countI += 1;
                }
            }
            for (int j = 0; j < merchant.length(); j++) {
                if(merchant.charAt(j) == temp){
                    countB += 1;
                }
            }
            if(countI > countB) {
                lack = lack + (countI - countB);
                if(i == iNeed.length() - 1){
                    System.out.println("No" + " " + lack);
                    return;
                }
            }

            if((i == iNeed.length() - 1) && countB >= countI){
                System.out.println("Yes" + " " + (merchant.length() - iNeed.length()));
                return;
            }

            countB = countI = 0;
        }
        //System.out.println("No" + " " + lack);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String merchant = in.nextLine();
        String iNeed = in.nextLine();
        judgeBuy(merchant, iNeed);
    }

}
