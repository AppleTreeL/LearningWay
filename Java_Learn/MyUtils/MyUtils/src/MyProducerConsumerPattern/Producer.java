package MyProducerConsumerPattern;

import java.util.Queue;
import java.util.UUID;

/**
 * @Classname Producer
 * @Description TODO
 * @Date 2019/6/11 21:13
 * @Created by AppleTree
 */
public class Producer implements Runnable {
    private final Queue<Goods> queue;

    public Producer(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true){
            synchronized (this.queue){
                    if(this.queue.size() <= 10) {
                    Goods goods = new Goods("商品生产", UUID.randomUUID().hashCode());
                    this.queue.add(goods);
                    System.out.println(Thread.currentThread().getName()+":::"+goods+">>"+this.queue.size());
                }else{
                    System.out.println("the goods is full! waiting for consumers");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
