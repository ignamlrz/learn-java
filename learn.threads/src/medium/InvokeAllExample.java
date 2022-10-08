package medium;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * The {@link InvokeAllExample} class will execute examples using the
 * {@link ExecutorService#invokeAll(Collection) ExecutorService.invokeAll}
 * <p>
 * InvokeAll executes a given collection of tasks, returning a list of
 * {@link Future} interfaces holding the status and results of each task. A
 * completed task could have terminated either normally or by throwing an
 * exception
 *
 * @author Tim Buchalka
 */
public class InvokeAllExample {

    public static void main(String[] args) {

        // Create a collection of Callable lambda expressions
        Collection<Callable<IntSummaryStatistics>> tasks = List.of(
                () -> InvokeAllExample
                        .doSomething(3, 7),
                () -> InvokeAllExample
                        .doSomething(5, 5),
                () -> InvokeAllExample
                        .doSomething(75, 5),
                () -> InvokeAllExample
                        .doSomething(100, 5)
        );

        ExecutorService executorService = null;

        // Following variable will hold results
        List<Future<IntSummaryStatistics>> results = null;

        try {
            executorService = Executors.newFixedThreadPool(2);

            // Pass all tasks to ExecutorService
            results = executorService.invokeAll(tasks,  2, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    // Wait no longer than 2 seconds for completion confirmation
                    // executorService.awaitTermination(2, TimeUnit.SECONDS);

                    if (results != null) {
                        // Print out results of each task
                        for (Future<IntSummaryStatistics> f : results) {
                            System.out.println(f);
                            System.out.println(f.get());
                        }
                    }

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private static IntSummaryStatistics doSomething(int seed, int limit) {
        return Stream.iterate(seed, (t) -> t + seed)
                .limit(limit)
                .mapToInt((s) -> s)
                .peek((s) -> {
                    System.out.print("[" + seed + "'s] " + s + ", ");
                    if (s == limit * seed) System.out.println(" << [" + seed +
                            "'s] finished");
                })
                .summaryStatistics();

    }
}
