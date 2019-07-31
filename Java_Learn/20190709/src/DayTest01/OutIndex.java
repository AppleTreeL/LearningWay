package DayTest01;

import java.util.Scanner;

/**
 * @Classname OutIndex
 * @Description find the index of the aimed num
 * @Date 2019/7/31 15:28
 * @Created by AppleTree
 */
public class OutIndex {

    public static int getIndex(int[] array, int aim){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == aim) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numN = in.nextInt();
        if(numN < 1 || numN > 200) throw new IllegalArgumentException("参数越界"+numN);
        int[] array = new int[numN];
        for (int i = 0; i < numN; i++) {
            array[i] = in.nextInt();
        }
        int aimNum = in.nextInt();
        System.out.println(getIndex(array, aimNum));
    }

}
