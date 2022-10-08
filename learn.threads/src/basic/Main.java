package basic;

/**
 * The {@link Main} class will execute all the basic operations
 *
 * @author ignamlrz
 */
public class Main {
    public static void main(String ...args) throws InterruptedException {
        runExample1();
    }

    /**
     * Run the first example
     */
    private static void runExample1() throws InterruptedException {
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

        // Await t2 is not alive
        while(t2.isAlive()) {
            System.out.println("\nWaiting for " + t2.getName() +
                    " to terminate");
            Thread.sleep(150);
        }

        System.out.println("All threads interrupted, terminating");
    }
}
