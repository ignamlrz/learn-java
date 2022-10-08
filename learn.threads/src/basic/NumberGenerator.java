package basic;

import java.util.stream.Stream;

/**
 * The {@link NumberGenerator} class is a class which extends from
 * {@link Number} class and implements {@link Runnable} interface
 *
 * @author ignamlrz
 */
public class NumberGenerator extends Number implements Runnable {
    private final int seed;

    NumberGenerator(int seed) {
        this.seed = seed;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Stream<Integer> infiniteStream =
                Stream.iterate(this.seed, (t) -> t + this.seed);
        try {
            infiniteStream.forEach(s -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    throw new RuntimeException("interrupted");
                }
                // Print numbers and include thread name
                System.out.print(": " + s + " ");
            });
        } catch (RuntimeException re) {
            System.out.println("\nInterrupted the thread's execution");
        }
    }

    /* -- Override Number methods -- */
    /**
     * Returns the value of the specified number as an {@code int}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code int}.
     */
    @Override
    public int intValue() {
        return this.seed;
    }

    /**
     * Returns the value of the specified number as a {@code long}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code long}.
     */
    @Override
    public long longValue() {
        return this.seed;
    }

    /**
     * Returns the value of the specified number as a {@code float}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code float}.
     */
    @Override
    public float floatValue() {
        return this.seed;
    }

    /**
     * Returns the value of the specified number as a {@code double}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code double}.
     */
    @Override
    public double doubleValue() {
        return this.seed;
    }
}
