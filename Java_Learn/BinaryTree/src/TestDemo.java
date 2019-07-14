import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-07-09
 * Time: 19:26
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {10,2,30,4,5,6,7,8};
        TestHeap testHeap = new TestHeap();
        testHeap.initHeap(array);
        testHeap.show();
        testHeap.pushHeap(11);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();
        //testHeap.HeapSort2();
        //testHeap.show();
        testHeap.HeapSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
