package MultiThreading;

public class LifeCycle extends Thread{
    @Override
    public void run() {
        System.out.println("I am Running");
        try {
            Thread.sleep(200);
//            System.out.println(Thread.currentThread().getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void main(String[] args) throws InterruptedException {
        LifeCycle l1 = new LifeCycle();

       // .getState is a method in class State which is  enum means it has various types RUNNABLE , NEW etc
        System.out.println(l1.getState());  //state will be NEW
        l1.start();
        System.out.println(l1.getState());  //state will be RUNNABLE

        // there is no running state enum so it is considered in RUNNABLE only example

        //Main thread is currently running but it will display runnable

        System.out.println(Thread.currentThread().getState()); // its running but showing RUNNABLE

        Thread.sleep(100); // here it raising Unhandled exception: java.lang.InterruptedException
        //so we have to make this class able to throw excption
        // now it is pausing main thread and giving time to another waiting thread
        System.out.println(l1.getState());
        //TIMED_WAITING this is what we see as this thread paused and allowed another thread to run so another thread executed

        l1.join();
        // now this will allow main thread to continue and aquire cpu when another thread finished
        System.out.println(l1.getState()); // showing terminated becuase all task got over


    }

}
