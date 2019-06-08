package ThreadClass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname MyTick
 * @Description TODO
 * @Date 2019/6/8 22:18
 * @Created by AppleTree
 */
//public class MyTick implements Runnable {
//    private int tick = 10;
//
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (this){
//            while(tick > 0) {
//                System.out.println(Thread.currentThread().getName() + "买了" + (-- this.tick));
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Runnable tick = new MyTick();
//        //Runnable tick1 = new MyTick();
//        Thread thread1 = new Thread(tick);
//        Thread thread2 = new Thread(tick);
//        thread1.setName("黄牛A");
//        thread2.setName("黄牛B");
//        thread1.start();
//        thread2.start();
//    }
//}

public class MyTick implements Runnable {
    private int tick = 10;
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while(tick > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.lock.lock();
            try {
                if(tick > 0)
                System.out.println(Thread.currentThread().getName() + "买了" + (--this.tick));
            }finally {
                this.lock.unlock();
            }
        }
//        synchronized (this){
//            while(tick > 0) {
//                System.out.println(Thread.currentThread().getName() + "买了" + (-- this.tick));
//            }
//        }

    }

    public static void main(String[] args) {
        Runnable tick = new MyTick();
        //Runnable tick1 = new MyTick();
        Thread thread1 = new Thread(tick);
        Thread thread2 = new Thread(tick);
        thread1.setName("黄牛A");
        thread2.setName("黄牛B");
        thread1.start();
        thread2.start();
    }
}
