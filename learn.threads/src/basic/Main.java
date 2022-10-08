package basic;

import java.util.Random;

/**
 * The {@link Main} class will execute all the basic operations on his
 * {@link #main(String...) main()} method
 *
 * @author ignamlrz
 */
public class Main {
    public static void main(String ...args) throws InterruptedException {
        example1_usingThreadClass();
        example2_usingRunnableInterface();
    }

    /**
     * Run the first example
     */
    private static void example1_usingThreadClass() throws InterruptedException {
        System.out.println(">>>>> Running Example 1 <<<<<");
        // Will prints numbers out in increments of 5
        Thread t1 = new CustomThread("Fives", 5);
        // Will prints numbers out in increments of 7
        Thread t2 = new CustomThread("Sevens", 7);

        // Start both task using Thread.start() - which execute Thread.run()
        t1.start();
        t2.start();

        // Pauses current thread for 3 seconds allowing other asynchronous
        // tasks time to run a bit
        Thread.sleep(3000);

        // Interrupt one of the threads
        t1.interrupt();

        // Do some work in the current thread slowly
        for(int i=0; i<3; i++) {
            Thread.sleep(1000);
            System.out.println("\nmain thread executing " + i);
        }

        // Pause another one
        Thread.sleep(3000);

        // Interrupt second thread
        t2.interrupt();

        // Create a local class of type Thread, implement the run() method
        // creating a stream of 10 random numbers between 1 and 100
        Thread t3 = new Thread(){
            public void run() {
                new Random().ints(10, 1, 100)
                        .forEach(System.out::println);
            }
        };

        // Call start() which executed local class's run()
        t3.start();

        // The join method waits for the thread to complete
        t3.join();
        System.out.println("The status of the thread t3 after join: " +
                t3.getState());
        System.out.println("Is alive: " + t3.isAlive());
        System.out.println("Is interrupted: " + t3.isInterrupted());
    }

    private static void example2_usingRunnableInterface() throws InterruptedException {
        // Create a Thread, pass a Runnable object, in this case an instance
        // of NumberGenerator class
        // Thread t = new Thread(new NumberGenerator(100)::run);
        Thread t = new Thread(new NumberGenerator(100));
        t.start();

        // Sleep main thread
        Thread.sleep(3000);

        // Interrupt asynchronous task
        t.interrupt();

        while(t.isAlive()) {
            System.out.println("\nWaiting for " + t.getName() + " to finish");
            Thread.sleep(150);
        }

        System.out.println("\nAll threads interrupted, Terminating main " +
                "thread");
    }
}
