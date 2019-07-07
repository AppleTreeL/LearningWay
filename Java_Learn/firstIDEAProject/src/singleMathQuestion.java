import java.util.Scanner;

/**
 * @Classname singleMathQuestion
 * @Description TODO
 * @Date 2019/7/6 16:57
 * @Created by AppleTree
 */
public class singleMathQuestion {

    public static final boolean judgeLegal(int num) {
        if(num <= 30 && num >= -30){
            return true;
        }else {
            return false;
        }
    }

    public static final void solution(int A, int B, int C, int D){//A - B, B - C, A + B, B + C
        if(!judgeLegal(A) || !judgeLegal(B)|| !judgeLegal(C) || !judgeLegal(D)){
            //throw new IllegalArgumentException("参数越界");
            System.out.println("NO");
            return;
        }
        if((A + C) % 2 != 0 || (B + D) % 2 != 0){
            System.out.println("NO");
            return;
        }
        int a = 0;
        int b1 = 0;
        int b2 = 0;
        int c = 0;
        a = (A + C) / 2;
        b1 = (B + D) / 2;
        b2 = (C - A) / 2;
        if(b1 != b2){
            System.out.println("NO");
            return;
        }
        c = (D - B) / 2;
        System.out.println(a + " " + b1 + " " + c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        d = in.nextInt();
        solution(a, b, c, d);
    }

}
