package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
    private  final Lock fairLock =  new ReentrantLock(true); // if fairness is true then we can see FIFo

    public void accessResource(){
        fairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            fairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " has releases the lock");
        }
    }

    static void main(String[] args) {
        FairnessLockExample test = new FairnessLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                test.accessResource();
            }
        };
        Thread t1 = new Thread(task , "Thread 1");
        Thread t2 = new Thread(task , "Thread 2");
        Thread t3 = new Thread(task , "Thread 3");
        try {
            t1.start();
            t1.sleep(50);
            t2.start();
            t2.sleep(50);
            t3.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
