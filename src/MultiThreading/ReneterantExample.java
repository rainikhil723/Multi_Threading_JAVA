package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReneterantExample {
    public final Lock lock = new ReentrantLock();

    public void OuterMethod(){
        lock.lock();
        try{
            System.out.println("Hello i am in Outer Method");
            InnerMethod();
        }
        finally {
            lock.unlock();
        }
    }
    public void InnerMethod(){
        lock.lock();
        try{
            System.out.println("Hello i am in Inner Method");

        }
        finally {
            lock.unlock();
        }
    }

    static void main(String[] args) {
        ReneterantExample test = new ReneterantExample();
        test.OuterMethod(); // both method printed

        //but first method lock hua then uske ander ek method jo lock maang rha h par lock khula nhi
        // deadlock but java handles smartly
        // java create another child lock
        //multiple lock ban jaaega
//        inner ka alag lock and outer vala main lock
//                just like lock me lock
//                ya ek main ghar me enter then usme lock and then uske rooms me lock
    }
}
