package basic;

import java.util.stream.Stream;

/**
 * The {@link CustomThread} class is a class that extend from {@link Thread}
 * class
 *
 * @author ignamlrz
 */
public class CustomThread extends Thread {
    /**
     * Passing a seed value, which will print numbers in increments of the
     * seed value
     */
    private final int seed;

    /**
     * Constructor of the {@link CustomThread} class
     *
     * @param name Name of the thread
     * @param seed Seed to use
     */
    public CustomThread(String name, int seed) {
        super(name);
        this.seed = seed;
    }

    /**
     * Method overrides {@link #run()}. This is an implementation of task to
     * be executed
     *
     * @see Thread#run()
     * @see Thread#start()
     */
    @Override
    public void run() {
        Stream<Integer> infiniteStream =
                Stream.iterate(this.seed, t -> t + this.seed);
        try {
            infiniteStream.forEach(s -> {
                // must satisfy/specify for InterruptedException
                try {
                    sleep(500);
                } catch (InterruptedException ie) {
                    throw new RuntimeException("interrupted");
                }
                // Print numbers and include thread name
                System.out.print(this.getName() + ": " + s + " ");
            });
        } catch (RuntimeException re) {
            // Print a statement and terminate cleanly
            System.out.println("\nInterrupted " + this.getName() +
                    "'s execution");
        }
    }
}
