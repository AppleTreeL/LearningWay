package DayQuestionTest;

import java.util.Scanner;

/**
 * @Classname DayQuestionTest.CombineSequence
 * @Description TODO
 * @Date 2019/7/20 12:58
 * @Created by AppleTree
 */
public class CombineSequence {


    public static void bubbleSequenceZ(int[] array) //使用时向整形指针array传入数组首地址，num为数组大小
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

    public static void bubbleSequenceF(int[] array) //使用时向整形指针array传入数组首地址，num为数组大小
    {
        int temp = 0;
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length - 1 - i; j++ )
            {
                if(array[j] < array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int mux(int n){
        if(n <= 1){
            return 1;
        }
        return n * mux(n - 1);
    }

    public static  void combine(int[] array){
        int[][] result = new int[mux(array.length)][array.length];
        bubbleSequenceZ(array);
        //StringBuilder stringBuilder = new StringBuilder();
        int countrow = 0;
        for (int i = 0; i < array.length; i++) {
//            stringBuilder.append(array[i]);
//            stringBuilder.append(" ");
            int j = i + 1;
            int jStart= j;
            int countcol = 0;
            while (j != jStart -1) {
                if (j < array.length) {
//                    stringBuilder.append(array[j]);
//                    stringBuilder.append(" ");
                    result[countrow][countcol] = array[j];
                    countcol += 1;
                    j += 1;
                } else {
                    j = 0;
                    //stringBuilder.append(" ");
                }
            }
//            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
//            System.out.println(stringBuilder.toString());
//            stringBuilder.delete(0, stringBuilder.length());
            countrow += 1;
        }
        bubbleSequenceF(array);
        for (int i = 0; i < array.length; i++) {
//            stringBuilder.append(array[i]);
//            stringBuilder.append(" ");
            int j = i + 1;
            int jStart= j;
            int countCol = 0;
            while (j != jStart -1) {
                if (j < array.length) {
//                    stringBuilder.append(array[j]);
//                    stringBuilder.append(" ");
                    result[countrow][countCol] = array[j];
                    countCol += 1;
                    j += 1;
                } else {
                    j = 0;
                    //stringBuilder.append(" ");
                }
            }
//            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
//            System.out.println(stringBuilder.toString());
//            stringBuilder.delete(0, stringBuilder.length());
            countrow += 1;
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = in.nextInt();
        }
        combine(a);
        //System.out.println(mux(4));
    }

}
