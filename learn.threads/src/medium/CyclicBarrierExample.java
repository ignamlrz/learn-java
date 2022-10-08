package medium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * The {@link CyclicBarrierExample} class will execute examples using the
 * {@link CyclicBarrier} class
 * <p>
 * {@link CyclicBarrier} class allows a set number of threads to all wait for
 * each other at a defined barrier point, useful in programs involving a
 * fixed-sized number of threads that must occasionally wait for each other
 * <p>
 * Is called cyclic because it can be re-used after the waiting threads are
 * released to define another barrier point or checkpoint
 * <p>
 * Can also execute a Runnable command that is run once per barrier point,
 * after the last thread in the party arrives, but before any threads are
 * releases. This action could be used for updating shared state or status
 * updates
 * <p>
 * In this example, a DEADLOCK is happening, if put
 * {@link Executors#newFixedThreadPool(int) newFixedThreadPool} contain fewer
 * threads that expect the parties of {@link CyclicBarrier}
 *
 * @author Tim Buchalka
 */
public class CyclicBarrierExample {
    public static void main(String[] args) throws Exception {

        // Construct a CyclicBarrier,
        // First arg # of parties (tasks)
        // Second arg Action is a Runnable
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                () -> {
                    System.out.println("Confirming step is complete");
                });

        // Set up a callable local variable
        Callable<Boolean> r = () -> {

            // All threads execute step 1
            step(1);
            try {
                cyclicBarrier.await(5, TimeUnit.SECONDS);
            } catch (BrokenBarrierException e) {
                System.out.println("Barrier broken = "
                        + cyclicBarrier.isBroken());
                System.out.println("Waited but then released...");
            }

            // All threads execute step 2
            step(2);

            return true;
        };

        // Fixed Threads = Will be parties on CyclicBarrier
        ExecutorService service = Executors.newFixedThreadPool(2);
        // Invoke four callable tasks, all the same
        service.invokeAll(List.of(r, r, r, r));

        System.out.println("Shutting service down");
        service.shutdown();

    }

    public static void step(int stepNo) throws Exception {
        int ms = new Random().nextInt(5) * 1000;
        System.out.println(Thread.currentThread().getName() +
                " waiting for " + ms + " milliseconds to start step " + stepNo);
        Thread.sleep(ms);

        System.out.println(Thread.currentThread().getName() +
                " completed step " + stepNo);

    }

}
