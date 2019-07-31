package BIlibiliTest;

import java.util.Scanner;

/**
 * @Classname GetEggs
 * @Description TODO
 * @Date 2019/7/22 20:58
 * @Created by AppleTree
 */
public class GetEggs {

    public static void main(String[] args) {
      /* Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();*/
      Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        StringBuilder builder = new StringBuilder();
        help(N,builder);
        System.out.println(builder.reverse().toString());
    }
    public static void help(int n,  StringBuilder builder) {
        if (n <= 0) {
            return;
        }
        if (n % 2 == 0) {
            builder.append("3");
            help((n - 2) / 2, builder);
        } else {
            builder.append("2");
            help((n - 1) / 2, builder);
        }
    }


//        while (count != n){
//            if(n % 2 == 0){
//                count = 2 * count + 2;
//                res.append("3");
//            }else {
//                temp = n - 1;
//                count = 2 * count + 1;
//            }
//        }

}
