package MyProducerConsumerPattern;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/6/11 21:30
 * @Created by AppleTree
 */
public class Test {
//    Queue<Goods> queue = new LinkedList<>();
    static Queue<Goods> queue = new LinkedList<>();
    public static void main(String[] args) {

//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);

        for(int i = 0; i < 2; i++){
            new Thread(new Producer(queue)).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1; i++) {
            new Thread(new Consumer(queue)).start();
        }
    }
}
