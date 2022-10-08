package medium;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.*;

/**
 * The {@link Main} class will execute all the medium operations on his
 * {@link #main(String...) main()} method
 * <p>
 * Here we will be using {@link java.util.concurrent.Executor Executor}
 * interface, which support extensions and implementations of this interface.
 * <p>
 * The {@link java.util.concurrent.ExecutorService ExecutorService} extends
 * the {@link java.util.concurrent.Executor Executor} interface and provides
 * many of the methods to manage tasks including thread pooling and scheduling
 * <p>
 * The {@link java.util.concurrent.Executors Executors} class is a class with
 * static factory methods that return a particular type of
 * {@link java.util.concurrent.ExecutorService ExecutorService}, depending on
 * your needs
 *
 * @author ignamlrz
 */
public class Main {
    public static void main(String... args) throws InterruptedException {
        //example1_usingExecutorService();
        example2_usingSubmitOnExecutorService();
    }

    /**
     * Run the first example:
     * <p>
     * An ExecutorService not start up on its own. At least, one of the
     * following methods have to execute:
     * <ul>
     *     <li>{@link ExecutorService#execute(Runnable) ExecuteService.execute}</li>
     *     <li>{@link ExecutorService#submit(Runnable) ExecuteService.submit}</li>
     *     <li>{@link ExecutorService#invokeAll(Collection) ExecuteService.invokeAll}</li>
     *     <li>{@link ExecutorService#invokeAny(Collection) ExecuteService.invokeAny}</li>
     * </ul>
     * <p>
     * If any of these methods have been invoked, you will need to invoke
     * any of the following methods to reclaim service's resources and have
     * it terminate cleanly
     * <ul>
     *     <li>{@link ExecutorService#shutdown() ExecutorService.shutdown}</li>
     *     <ul>
     *         <li>Reclaim resources and terminates invoking thread</li>
     *         <li>Cause the service to reject new tasks</li>
     *     </ul>
     *     <li>{@link ExecutorService#shutdownNow() ExecutorService.shutdownNow}</li>
     *     <ul>
     *         <li>Reclaim resources and terminates invoking thread</li>
     *         <li>Cause the service to reject new tasks</li>
     *         <li>Prevent waiting tasks from starting</li>
     *         <li>Attempt to stop currently executing tasks</li>
     *     </ul>
     * </ul>
     */
    private static void example1_usingExecutorService() throws InterruptedException {
        System.out.println(">>>>> Running Example 1 <<<<<");
        // Get new service using Executors class, static factory method.
        ExecutorService executorService
                = Executors.newSingleThreadExecutor();

        // Fire and Forget method of execution:  ThreadOne
        executorService.execute(Utils::doSomethingThreadOne);

        // Fire and NOT forget method of execution: ThreadTwo
        executorService.submit(Utils::doSomethingThreadTwo);

        for (int i = 1; i < 11; i++) {
            System.out.println("Main thread: iteration " + i);
            Thread.sleep(250);
        }

        // Shutdown the service
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("All done!!");
    }

    /**
     * Run the second example, which will use different overloaded methods of
     * {@link ExecutorService#submit(Runnable) ExecutorService.submit}:
     * <ul>
     *     <li>{@link ExecutorService#submit(Runnable)}</li>
     *     Use {@link Runnable} interface, and return {@link Future}
     *     interface wrapped with a {@link Void} data type
     *     <li>{@link ExecutorService#submit(Runnable, Object)}</li>
     *     Use {@link Runnable} interface, and return {@link Future}
     *     interface wrapped with the second argument as result
     *     <li>{@link ExecutorService#submit(Callable)}</li>
     *     Use {@link Callable} functional interface, which will return a
     *     {@link Future} interface wrapped with the returned data type
     * </ul>
     */
    private static void example2_usingSubmitOnExecutorService() {

        ExecutorService executorService = null;

        try {
            executorService = Executors.newSingleThreadExecutor();

            // Submits Runnable and returns void
            Future<?> firstResult = executorService.submit(
                    () -> new Random().ints(1, 1000)
                            .limit(5)
                            .forEach(System.out::println));

            // Allow thread to complete before proceeding using while loop
            //  and checking Future.isDone() method.  Polling.
            while (!firstResult.isDone()) {
                Thread.sleep(250);
            }

            // Future.get() returns a null with single argument and
            // Runnable is first argument
            System.out.println("firstResult = " + firstResult);
            System.out.println("firstResult.get() = " + firstResult.get());

            // Submits Runnable and returns second argument as the result
            Future<String> secondResult = executorService.submit(
                    () -> new Random().ints(1, 1000)
                            .limit(5)
                            .forEach(System.out::println)
                    , "Thread is finished");

            // Allow thread to complete before proceeding using while loop
            //  and checking Future.isDone() method
            while (!secondResult.isDone()) {
                Thread.sleep(250);
            }

            // Future.get() returns the second argument when
            // two arguments passed to submit method
            System.out.println("secondResult = " + secondResult);
            System.out.println("secondResult = " + secondResult.get());

            // Submits a Callable that returns a value,
            // value is passed to the Future
            Future<?> thirdResult = executorService.submit(
                    () -> new Random().ints(1, 100_000)
                            .limit(1000)
                            .summaryStatistics()
            );

            // Replace while loop with Future.get() method passing specified
            // time.
            System.out.println("thirdResult = " + thirdResult.get(5, TimeUnit.SECONDS));
            System.out.println("thirdResult = " + thirdResult);

        } catch (TimeoutException | InterruptedException |
                 ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) executorService.shutdown();
        }
    }
}
