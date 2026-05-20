package MultiThreading;

public class Test {
    static void main(String[] args) {

// main showing that on running this java code one thread created named main

//        System.out.println("Hello WORLD!");
//        System.out.println(Thread.currentThread().getName());

        newThread thread = new newThread(); // creating an object to use that thread

        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread Running");
            System.out.println(Thread.currentThread().getName());

        }
        // now observe that randomly printing these threads





    }
}
