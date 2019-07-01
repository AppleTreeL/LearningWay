/**
 * @Classname SortMethod
 * @Description 一些排序算法
 * @Date 2019/7/1 8:17
 * @Created by AppleTree
 */
public class SortMethod{

    //直接插入排序越有序越快
    /**
     * 直接插入排序
     * @param array
     */
    public static void insertSort(int[] array){
        int tmp = 0;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            int j = 0;
            for (j = i-1; j >= 0 ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
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

    public static int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, a.length-1);
        return a[a.length - K];
    }

    public static void main(String[] args) {
//        int[] a = {1,2,3,5,4};
//        insertSort(a);
//        for (int it: a) {
//            System.out.println(it);
//        }
        int[] a = {1, 3, 5, 2, 4}; //1  2  3   4   5
        System.out.println(findKth(a, 5, 5));
    }
}
