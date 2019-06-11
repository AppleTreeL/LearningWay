package MyProducerConsumerPattern;

import java.util.Queue;

/**
 * @Classname Consumer
 * @Description TODO
 * @Date 2019/6/11 21:25
 * @Created by AppleTree
 */
public class Consumer implements Runnable {
    private final Queue<Goods> queue;

    public Consumer(Queue<Goods> queue) {
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
                    if(this.queue.size() != 0){
                        if(this.queue.peek() == null){
                            System.out.println("Goods is not enough, please produce quickly");
                            this.notify();
                        }
                        System.out.println(Thread.currentThread().getName()+":::"+this.queue.poll()+">> 消费>>"+this.queue.size());
                    }else {
                        System.out.println("Goods is not enough, please produce quickly");
                        this.notify();
                    }
                }
        }
    }
}
