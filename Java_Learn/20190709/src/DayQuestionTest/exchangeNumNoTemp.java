package DayQuestionTest;

import java.util.HashMap;

/**
 * @Classname DayQuestionTest.exchangeNumNoTemp
 * @Description TODO
 * @Date 2019/7/15 0:20
 * @Created by AppleTree
 */

//class Base{
//    public Base(String s){
//        System.out.print("B");
//    }
//}
//public class DayQuestionTest.exchangeNumNoTemp extends Base{
//    public DayQuestionTest.exchangeNumNoTemp(String s) {
//
//        System.out.print("D");
//    }
//    public static void main(String[] args){
//        new DayQuestionTest.exchangeNumNoTemp("C");
//    }
//}


public class exchangeNumNoTemp {

    public int[] exchangeAB(int[] AB){
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(null, "jayce");
        hashMap.put(null, "yuanxiuchao");

        System.out.println(hashMap);
    }

}
