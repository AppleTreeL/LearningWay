/**
 * @Classname countReverseNum
 * @Description TODO
 * @Date 2019/7/2 12:55
 * @Created by AppleTree
 */
public class countReverseNum {

    /**
     * count the reverse num
     * @param a the araay
     * @param n the count
     * @return
     */
    public static final int countReNum(int[] a, int n){
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if(a[i] > a[j]){
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(countReNum(a,8));
    }

}
