package medium;

/**
 * the {@link Utils} class is a Utility class which contain methods to use on
 * another classes of {@link medium} package
 *
 * @author ignamlrz
 */
public class Utils {

    /**
     * Method which will be printing numbers 1-5
     */
    static void doSomethingThreadOne() {
        for (int i = 1; i <= 5; i++) {

            System.out.println("--> First Thread: iteration " + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException iex) {
                break;
            }
        }
    }

    /**
     * Method which will be printing numbers 10-5
     */
    static void doSomethingThreadTwo() {
        for (int i = 10; i > 5; i--) {

            System.out.println("--> Second thread: iteration " + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException iex) {
                break;
            }
        }
    }
}
