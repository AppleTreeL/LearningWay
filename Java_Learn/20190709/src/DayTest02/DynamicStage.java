package DayTest02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname DynamicStage
 * @Description TODO
 * @Date 2019/8/7 21:14
 * @Created by AppleTree
 */
public class DynamicStage {

    public static int countWays(int n) {
        // write code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        int res = 0;
        if(n == 1) return arrayList.get(0);
        if(n == 2) return arrayList.get(1);
        if(n == 3) return arrayList.get(2);
        for (int i = 0; i < n - 3; i++) {
            arrayList.add((arrayList.get(i) + arrayList.get(i + 1) + arrayList.get(i + 2)));
        }
        return arrayList.get(arrayList.size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stage = scanner.nextInt();
        System.out.println(countWays(stage));
    }

}
