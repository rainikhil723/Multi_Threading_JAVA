package MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountManual {
    private int balance = 100;

    //Lock class ko implement karne vala reennterent class object
    //in built hota h  isme lock , unlock , tryunlock ;
    private final Lock lock = new ReentrantLock();


    public void withdraw( int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) { // try karo ki gate open h ki nhi for 1 sec
                if(balance >= amount){

                    try {
                        System.out.println(Thread.currentThread().getName() + " proeceding with withrawals");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Withdrawal completed" + " Current balance is : " + balance);
                    }
                    catch (Exception e){
                        Thread.currentThread().interrupt(); // ye good practise h if any exception to current state pe hi ruk jaae
                    }
                    finally {
                        lock.unlock(); // process over ke baad unlock kar do
                    }

                }
                else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            }
            else{
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

}
