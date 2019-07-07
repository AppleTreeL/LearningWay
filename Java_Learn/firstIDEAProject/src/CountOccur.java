import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname CountOccur
 * @Description TODO
 * @Date 2019/7/6 18:04
 * @Created by AppleTree
 */
public class CountOccur {

    public static final void count(){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (in.hasNextInt()){
            arrayList.add(in.nextInt());

            if(arrayList.size() >= 100) return;

            int[] temp = new int[arrayList.size()];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arrayList.get(i);
            }

            quickSort(temp, 0, temp.length - 1);// 1 1 1 1 2 2 3
            int count = 1;
            for (int i = 0; i < temp.length - 1; i++) {
                if(temp[i] == temp[i+1]) {
                    count += 1;
                }else {
                    if(count >= (temp.length>>1)) {
                        System.out.print(temp[i]);
                        return;
                    }
                    count = 1;
                }
            }

        }

//        int count = 0;
//        for (int i = 0; i < arrayList.size(); i++) {
//            for (int j = 0; j < arrayList.size(); j++) {
//                if(arrayList.get(i).equals(arrayList.get(j))){
//                    count += 1;
//                }
//            }
//            if(count >= (arrayList.size()>>2)){
//                System.out.print(arrayList.get(i));
//            }
//            if(i + 1 < arrayList.size()){
//                System.out.print(" ");
//            }
//        }
    }

    /**
     * 快速排序
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high){
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }


    public static void main(String[] args) {
        count();//3 9 3 2 5 6 7 3 2 3 3 3
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
