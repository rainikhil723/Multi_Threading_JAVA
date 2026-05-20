package MultiThreading;

import javax.crypto.spec.PSource;

public class newThread extends Thread{

    // now what if we want to create our own personal thread then how
    // for that you have to inherit from thread class and override a function cotaining in that class


    @Override
    public void run() {
        for(int i = 0; i < 100;i++ ){
            System.out.println("Crazy! this thread is running");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
