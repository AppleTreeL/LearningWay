package DayQuestionTest;

/**
 * @Classname FindMoreThanHalf
 * @Description TODO
 * @Date 2019/7/23 21:50
 * @Created by AppleTree
 */
public class FindMoreThanHalf {

    public static int findMoreThanHalf(int[] ints){
        insertSort(ints);
        int res = 0;
        int length = ints.length;
        int count = 1;
        for (int i = 0; i < length - 1; i++) {
            if(ints[i] == ints[i + 1]){
                count += 1;
            }else {
                if(count > length >> 1){
                    res = ints[i];
                    break;
                }else {
                    count = 1;
//                if(i + 1 < length)
//                    i = i + 1;
                }
            }
        }
        return res;
    }

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

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 2, 2};
        System.out.println(findMoreThanHalf(ints));
    }

}
