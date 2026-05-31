package MultiThreading;

public class Main {
    static void main(String[] args) {


        BankAccount1 nikhil = new BankAccount1();
        BankAccountManual shek  = new BankAccountManual();

        // here we won't create a seperate class we will implement runnable class and create thread here only
        Runnable sbi = new Runnable() {
            @Override
            public void run() {
//                nikhil.withdraw(50);
                shek.withdraw(50);
            }
        };
//        Thread t1 = new Thread(sbi, "Thread 1");  // hum thread ko object create kar rahe h jo runnable ko implement karta h and isme variety of parameter as input ho sakte h
        // obj describes ki kya task ye thread perform karne vala h
//        Thread t2 = new Thread(sbi, "Thread 2");

        Thread t3 = new Thread(sbi, "Thread 3");
        Thread t4 = new Thread(sbi, "Thread 4");
//        t1.start();
//        t2.start();
        t4.start();
        t3.start();

    }

}
