/**
 * @Classname perchaseApple
 * @Description TODO
 * @Date 2019/7/6 13:57
 * @Created by AppleTree
 */
import java.util.Scanner;

public class perchaseApple {

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            System.out.println(solve(n));
        }
        scan.close();
    }


    private static int solve(int n) {
        if(n > 100 && n < 1) throw new IllegalArgumentException("参数" + n + "越界");

        int ans = 0;
        while (n >= 6) {
            if (n % 8 == 0) {
                ans += (n >> 3);
                n = 0;
            }else {
                n -= 6;
                ++ans;
            }
        }
        return n == 0 ? ans : -1;
    }

}