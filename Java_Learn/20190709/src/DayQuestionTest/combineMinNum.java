package DayQuestionTest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname DayQuestionTest.combineMinNum
 * @Description TODO
 * @Date 2019/7/16 11:22
 * @Created by AppleTree
 */
public class combineMinNum {

    public static void bubbleSequence(int[] array) //使用时向整形指针array传入数组首地址，num为数组大小
    {
        int temp = 0;
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length - 1 - i; j++ )
            {
                if(array[j] > array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static int[] minNum(int[] ints){
        bubbleSequence(ints);
        if(ints[0] == 0){
            int i =1;
            int temp;
            while (ints[i] == 0){
                i ++;
            }
            temp = ints[0];
            ints[0] = ints[i];
            ints[i] = temp;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = new int[10];
        Stack<Integer> stack = new Stack<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            ints[i] = in.nextInt();
        }
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < ints[i]; j++) {
                num.add(i);
            }
        }
        int[] fina = new int[num.size()];
        for (int i = 0; i < num.size(); i++) {
            fina[i] = num.get(i);
        }
        int[] res = minNum(fina);

        StringBuilder haha = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            haha.append(res[i]);
        }
        System.out.println(haha.toString());
    }

}
