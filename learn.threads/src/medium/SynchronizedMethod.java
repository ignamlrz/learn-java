package medium;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@link TheBallInTheAir} class represents a ball which contains
 * information about who hit the ball and how many times each player hit it
 */
class TheBallInTheAir {

    private String ballType = "Volleyball";
    // Total number of hits on the ball

    private AtomicInteger hit = new AtomicInteger(0);
    // Map of players and their hits..
    private Map<String, Integer> players = Collections.synchronizedMap(new TreeMap<>());

    // Constructor
    TheBallInTheAir() {
        players.put("Jane", 0);
        players.put("Mary", 0);
        players.put("Ralph", 0);
        players.put("Joe", 0);
    }

    // Method called by threads, adds player to map if not found
    // or increments value in map
    public int addHit(String player) {

        if (players.containsKey(player)) {
            players.computeIfPresent(player, (key, val) -> ++val);
        } else {
            // A null is returned if no mapping was found
            if (players.putIfAbsent(player, 1) != null) {
                System.out.println("Encountered race condition");
                players.computeIfPresent(player, (key, val) -> ++val);
            }

        }
        return hit.incrementAndGet();
    }

    // Present writeable output
    public String toString() {
        return "Total " + ballType + " hits: " + this.hit.get()
                + ", Player hits: " + players.values().stream().mapToInt(s -> s).sum()
                + "\nPlayers List: " + players;
    }
}

/**
 * The {@link SynchronizedMethod} class will execute examples using the
 * synchronized methods.
 * <p>
 * Before write Thread-safe Code, we have to identify the following problems:
 * <ul>
 *     <li>
 *         <b>Interference</b>: Occurs when two interleaving operations
 *         (multiple  steps and the sequences of steps of each operation
 *         overlap) create results that are not consistent if a single thread
 *         were executing (Thread interfered with another thread)
 *     </li>
 *     <li>
 *         <b>Race condition</b>: The correctness of the program depends on
 *         the relative timing of events in computations (One thread is in a
 *         race to complete its operations before another thread access the
 *         shared data)
 *     </li>
 * </ul>
 * <p>
 * Both are hard to identify and debug. You should try to write code that
 * manages access to shared data, by establishing something java calls a
 * <b>happens-before-relationship</b>. If one action happens-before another,
 * then the first is visible to and ordered before the second
 * <p>
 * There are several actions to create <b>happens-before-relationship</b>:
 * <ul>
 *     <li>The synchronized construct</li>
 *     <li>The volatile modifier</li>
 *     <li>Thread.start() method</li>
 *     <li>Thread.join() method</li>
 *     <li>
 *         The methods of all the classes in {@link java.util.concurrent} and
 *         its subpackages extend these guarantees
 *     </li>
 * </ul>
 * <p>
 * Java supports a {@code synchronized} method and a {@code synchronized}
 * statement (NOTE: {@code synchronized} modifier can NOT be used for
 * constructors) - only the thread creating the object will have access to
 * the constructor
 * <p>
 * The benefits of a synchronized methods are:
 * <ul>
 *     <li>
 *         It prevents two invocations of the same method on the same object
 *         to interleave
 *     </li>
 *     <li>
 *         When a synchronized method exists, it establishes a happens-before
 *         relationship with any subsequent invocations for the same instance
 *     </li>
 *     <li>
 *         When a thread invokes a synchronized method, the thread
 *         automatically acquires the intrinsic lock for that method's object
 *         and releases it when the method returns
 *     </li>
 * </ul>
 * <p>
 * Rather than introduce the <b>synchronized</b> modifier you can use the
 * <b>volatile</b> modifier on specific fields where you want to ensure safe
 * access by multiple threads
 * <p>
 * Java Memory Model ensures that all threads see a consistent value for the
 * variable
 *
 * Updates on double or long attributes are not atomic (occurs in a single
 * operation). A single write to a non-volatile long or double value is
 * treated as two separate writes: one to each 32-bit half.
 *
 * Java provides the {@link java.util.concurrent.atomic} classes to support
 * lock-free thread-safe programming on single variables
 */
public class SynchronizedMethod {

    // Create a shared ball.
    public static TheBallInTheAir sharedBall = new TheBallInTheAir();

    public static void main(String[] args) {
        // Set up players
        String[] players = {"Jane", "Mary", "Ralph", "Joe"};
        Random r = new Random();
        // random list of player names, representing their turn to hit ball
        List<String> playerTurns =
                Stream.generate(() -> players[r.nextInt(4)])
                        .limit(100)
                        .collect(Collectors.toList());

        ExecutorService executorService = null;

        try {
            executorService = Executors.newFixedThreadPool(5);

            // Start the volleyball game...
            for (String player : playerTurns) {
                executorService.submit(() -> sharedBall.addHit(player));
            }

        } finally {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    // Wait no longer than 1 second for completion confirmation
                    executorService.awaitTermination(1, TimeUnit.SECONDS);
                    System.out.println(sharedBall);

                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
