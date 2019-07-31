package DayQuestionTest;

import java.util.Scanner;
import java.util.Stack;

public class TestSquare{

    /**
     * print Square
     * @param n
     * @param c
     */
    public static void printSquare(int n, char c) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
        System.out.println();
        int k = 0;
        if(n % 2 == 0) k = n / 2;
        else k = n / 2 + 1;
        for(int i = 0; i < k - 2; i ++){
            System.out.print(c);
            for(int j = 0; j < n - 2; j ++){
                System.out.print(" ");
            }
            System.out.print(c);
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }

    /**
     * long integer add
     * @param addend
     * @param augend
     * @return
     */
    public static String AddLongInteger(String addend, String augend) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        StringBuilder res = new StringBuilder();
        String temp = null;
        int count = 0;
        for(int i  = 0; i < addend.length(); i++){
            stack1.add(addend.charAt(i) - 48);
        }
        for (int i = 0; i < augend.length(); i++) {
            stack2.add(augend.charAt(i) - 48);
        }
        while (!stack1.empty() && !stack2.empty()){
            temp = String.valueOf(stack1.pop() + stack2.pop()) + count;
            if(temp.length() > 1){
                count = temp.charAt(0) - 48;
                res.append(temp.charAt(1));
            }else {
                count = 0;
                res.append(temp);
            }
        }
        while (!stack1.empty()){
            temp = String.valueOf(stack1.pop() + count);
            if(temp.length() > 1){
                count = temp.charAt(0) - 48;
                res.append(temp.charAt(1));
            }else {
                count = 0;
                res.append(temp);
            }
        }
        while (!stack2.empty()){
            temp = String.valueOf(stack1.pop() + count);
            if(temp.length() > 1){
                count = temp.charAt(0) - 48;
                res.append(temp.charAt(1));
            }else {
                count = 0;
                res.append(temp);
            }
        }
        if(count != 0){
            res.append(count);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        char c = in.next().charAt(0);
//        printSquare(num, c);
        Scanner in = new Scanner(System.in);
        String num1 = in.next();
        String num2 = in.next();
        System.out.println(AddLongInteger(num1, num2));

    }
}