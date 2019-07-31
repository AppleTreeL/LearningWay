package DayTest01;

import java.util.Scanner;

/**
 * @Classname DayTest01.SearchTwodimensional
 * @Description TODO
 * @Date 2019/7/26 13:51
 * @Created by AppleTree
 */
public class SearchTwodimensional {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int res = in.nextInt();
            int result = (int) (Math.pow(2, res) - 1);
            System.out.println(result);
        }
    }

    public static void main1(String[] args) {
        int srcArray[] = { 3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81,
                95, 101 };
        System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));
    }


    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(binSearch(array[i], 0, array[i].length, target) != -1)
                    return true;
            }
        }
        return false;
    }

    /**
     * 二分查找递归实现
     *
     * @param srcArray
     * @param start
     * @param end
     * @param key
     * @return
     */
    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }
    /**
     * 二分查找普通循环实现
     *
     * @param srcArray
     * @param key
     * @return
     */
    public static int binSearch(int srcArray[], int key) {
        int mid = srcArray.length / 2;
        if (key == srcArray[mid]) {
            return mid;
        }
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            // 使用 (low + high) / 2 会有整数溢出的问题
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                // 继续在R[low..mid-1]中查找
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                // 继续在R[mid+1..high]中查找
                start = mid + 1;
            } else {
                return mid;
            }
        }

        // 当low>high时表示查找区间为空，查找失败
        return -1;
    }

}
