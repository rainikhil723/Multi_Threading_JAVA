package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadwriteLock {

    private int counter = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public  void increment(){ // for write locking
        writeLock.lock();
        try{
            counter++;
        }
        finally {
            writeLock.unlock();
        }
    }

    public int getCounter(){
        readLock.lock();

        try {
            return counter;
        }
        finally {
            readLock.unlock();
        }
    }


    static void main(String[] args) throws InterruptedException {
        ReadwriteLock example  = new ReadwriteLock();

        Runnable readtask = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i< 10 ;i++){
                    System.out.println(Thread.currentThread().getName() + "  read : " + example.getCounter());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i< 10 ;i++){
                    example.increment();
                    System.out.println(Thread.currentThread().getName() + "  incremented " );
                }
            }
        };
        Thread writerThread = new Thread(writeTask);
        Thread readerThread1 = new Thread(readtask);
        Thread readerThread2 = new Thread(readtask);
        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        System.out.println(" final count :" +  example.getCounter());

    }
}
