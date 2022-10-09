package streams;


import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 * The {@link ConsoleStreamExamples} class contain an implementation example using
 * standard command lines input and output streams, and an implementation
 * example using {@link Console} class.
 *
 * @author Tim Buchalka
 */
public class ConsoleStreamExamples {

    /**
     * If execute from console, console block code will be executed, if not will
     * be using standard input and output
     *
     * @param args Arguments of the operation
     * @throws IOException I/O Exception
     */
    public static void main(String[] args) throws IOException {

        Console console;

        LocalDateTime currentDate = LocalDateTime.now();

        // Represents name typed in by user.
        String name;

        // console may be null, for example within the IntelliJ IDE
        if ((console = System.console()) != null) {

            // Console supports a simple printf statement
            console.printf("Interacting with user via Console\n");

            // Read data by a single line
            name = console.readLine("What is your name? ");

            console.printf("Enter your name, %s:\n", name);
            // Good practice to flush the buffer before getting input
            console.flush();

            // Alternate way of reading data by a single line
            BufferedReader reader = new BufferedReader(console.reader());
            name = reader.readLine();

            // clear the buffer
            console.flush();
            // Retrieve user's password
            console.readPassword("Enter Password, please, %1s: ", name);
            console.readPassword();

            // Alternate of printf, use the console.writer().println
            console.writer().println("Your input is appreciated, " + name);
            console.format("The local date and time is:" +
                    " %1$tF %1$tr", currentDate);

        } else {
            // Getting the same data using standard in and out
            System.out.println("Interacting with user via standard" +
                    " input/output streams");
            System.out.println("What is your name? ");

            //Read in text using carriage return with BufferedReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            name = reader.readLine();

            // Output the name user typed in
            System.out.println("Your input is appreciated, " + name);
            System.out.printf("The local date and time is:" +
                    " %1$tF %1$tr%n", currentDate);
        }
    }
}