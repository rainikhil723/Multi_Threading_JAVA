package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount1 {
    private int balance = 100;



    public synchronized void withdraw( int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " proeceding with withrawals");
            try {
                Thread.sleep(10000);  // imagine performing transaction
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName() + "Withdrawal completed"+ " Current balance is : " + balance);
        }
        else{
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}


/*  Key Points:
*  Agar hm synchronised nhi used karenge so dono thread same bannk account se 50 50  nikal lenge par may be balance still 50 ho 0 ki jagah
* because there might be a possiblilty that both process execute at same time and balnce for both of them is  100
*
* to fix this we use syncronised keyword it allows only one at a time
* it puts a lock when one thread is executing no other thread can perform any action
*
* in actual bank if such thing there then there might be a chance that some transaction get stuck for an hour then no other can perform
* so we need something timeout like
* */
