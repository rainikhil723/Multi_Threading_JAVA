package MultiThreading;

public class MyThread extends Thread{
    MyThread(String name){
        super(name);
    }

    @Override
    //Method 2 Thread is executing
    public void run() {

        //Method 6 : Interuppt
//        for(int i = 0 ;i<2 ;i++){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                System.out.println("Thread was Interuptted "+ e);
//            }
//
//        }

        for(int  i = 0 ; i<20 ; i++){
            System.out.println(Thread.currentThread().getName() +" is running");
            //Method 7 YEILD
            Thread.yield();
        }

////        System.out.println("Thread is Running");
//
//        for (int i = 0; i < 100000; i++) {
//            String a = "";
//            a+=" ";
//
//        }
//        for (int i = 0; i <=7; i++) {
////            try {
////
////                //METHOD 3 (SLEEP) : ye thread execution ko rok dega for 1 sec then execute
////                Thread.sleep(1000);
////                System.out.println("Hello");
////
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
//
//            //Method 6 set priority
//            System.out.println(Thread.currentThread().getName() + "current Priority is : " + Thread.currentThread().getPriority() + " and -count : "+ i);
//
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }

    }

    static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        MyThread t3 = new MyThread("Thread 3");


        t1.start();
        t2.start();
        t3.start();
//        t1.interrupt();
        System.out.println("Done");
//        MyThread l = new MyThread("Low Priority Thread");
//        MyThread m = new MyThread("Medium Priority Thread");
//        MyThread h = new MyThread("High Priority Thread");
//
//        //Method  1 Start
//        l.start(); //Runnable thread ready to execute
//        m.start();
//        h.start();
//        l.setPriority(Thread.MIN_PRIORITY);
//        m.setPriority(Thread.NORM_PRIORITY);
//        h.setPriority(Thread.MAX_PRIORITY);


        //Method 4 : other thread will continue only after completion of thread t1
//        t1.join();
//        System.out.println("so Finally the threaed t1 finishes now i can join ");


    }
}
