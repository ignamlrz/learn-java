package path;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The {@link PathMethods} class contain a set of examples using advanced
 * methods on {@link Path} API
 */
public class PathMethods {
    public static void main(String[] args) {
        // Testing Path.normalize() method
        testNormalize();
        testRelativize();
        testResolve();
        testResolveSibling();
        testTheRest();
    }

    // Normalizing a path, simplifies it.
    public static void testNormalize() {

        System.out.println("--- Results for the normalize() method ---");
        // Directory Structure shown below, -- represents a level
        // ---------------------
        // LearnProgrammingAcademy
        // -- ParallelStreams
        // -- IOProject
        // -- -- out
        // -- -- -- production
        // -- -- src
        Path p = Path.of("IOProject/../ParallelStreams");
        System.out.println("Normalize transforms \n\t" + p
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("out/production/IOProject/../../../src/.");
        System.out.println("Normalize transforms \n\t" + p
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("LearnProgrammingAcademy/IOProject/src/../../../.");
        System.out.println("Normalize transforms \n\t" + p
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("/a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p
                + "\n to: \n\t" + p.normalize() + "\n---------------");

    }

    // Testing the relativize method, accepts another Path as argument
    public static void testRelativize() {
        System.out.println("--- Results for the p1.relativize(p2) method ---");

        Path p1 = Path.of("LearnProgrammingAcademy/IOProject/out/production");
        Path p2 = Path.of("LearnProgrammingAcademy/ParallelStreams");

        // Relativize p1.relativize(p2)
        System.out.println("Relativize transforms \n\t"
                + p1 + "\n\t" + p2
                + "\n to: \n\t" + p1.relativize(p2)
                + "\n---------------");

        // Relativize p2.relativize(p1)
        System.out.println("Relativize transforms \n\t"
                + p2 + "\n\t" + p1
                + "\n to: \n\t" + p2.relativize(p1)
                + "\n---------------");

        p1 = Path.of("garden/fruit/apple");
        p2 = Path.of("pear");
        // Relativize p1.relativize(p2)
        System.out.println("Relativize transforms \n\t" +
                p1 + "\n\t" + p2
                + "\n to: \n\t" + p1.relativize(p2) +
                "\n---------------");

        // Relativize p2.relativize(p1)
        System.out.println("Relativize transforms \n\t"
                + p2 + "\n\t" + p1
                + "\n to: \n\t" + p2.relativize(p1) +
                "\n---------------");

        p1 = Path.of("/a/b");
        p2 = Path.of("a/b");
        try {
            // Relativize p1.relativize(p2)
            System.out.println("Relativize transforms \n\t" +
                    p1 + "\n\t" + p2
                    + "\n to: \n\t" + p1.relativize(p2) +
                    "\n---------------");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }
        try {
            // Relativize p2.relativize(p1)
            System.out.println("Relativize transforms \n\t" +
                    p2 + "\n\t" + p1
                    + "\n to: \n\t" + p2.relativize(p1) +
                    "\n---------------");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        }
    }

    // Testing resolve method which accepts a Path or String as argument
    public static void testResolve() {

        // Set up test data
        Path p1 = Path.of("IOProject");
        String p2String = "/LearnProgrammingAcademy";
        Path p2 = Path.of(p2String);

        System.out.println("--- Results for the p1.resolve(p2) method ---");

        // If Path argument (other) is absolute, method returns passed arg
        System.out.println("resolve transforms \n\t"
                + p1 + "\n\t" + p2
                + "\n to: \n\t" + p1.resolve(p2) +
                "\n---------------");

        // If Path argument (other) does not have root component,
        // joins the given path to this path
        System.out.println("resolve transforms \n\t"
                + p2 + "\n\t" + p1
                + "\n to: \n\t" + p2.resolve(p1) +
                "\n---------------");

        // If Path argument (other) is empty path, method returns self reference.
        // Note that resolve accepts a String or Path, for other path
        p2String = "";
        System.out.println("resolve transforms \n\t"
                + p1 + "\n\tempty Path/String"
                + "\n to: \n\t" + p1.resolve(p2String) +
                "\n---------------");

        // Two relative paths..
        p2String = "out/production";
        System.out.println("resolve transforms \n\t"
                + p1 + "\n\t" + p2String
                + "\n to: \n\t" + p1.resolve(p2String) +
                "\n---------------");
    }

    // Testing resolveSibling method, accepts Path or String as arg
    public static void testResolveSibling() {

        Path p1 = Path.of("IOProject/src");

        String p2String = "/LearnProgrammingAcademy";
        Path p2 = Path.of(p2String);

        System.out.println(
                "--- Results for the p1.resolveSibling(p2) method ---");

        // If Path argument (other) is absolute, method returns passed arg
        System.out.println("resolveSibling transforms \n\t"
                + p1 + "\n\t" + p2
                + "\n to: \n\t" + p1.resolveSibling(p2) +
                "\n---------------");

        // If Path argument (other) does not have root component,
        // joins the given path to the parent's path
        p2 = Path.of("/LearnProgrammingAcademy/IOProject");
        System.out.println("resolveSibling transforms \n\t"
                + p2 + "\n\t" + p1
                + "\n to: \n\t" + p2.resolveSibling(p1) +
                "\n---------------");

        // If Path argument (other) is empty path, method returns
        // parent's path
        p2String = "";
        System.out.println("resolveSibling transforms \n\t"
                + p1 + "\n\tempty Path/String"
                + "\n to: \n\t" + p1.resolveSibling(p2String) +
                "\n---------------");

        // Two relative paths..
        p2String = "out/production";
        System.out.println("resolveSibling transforms \n\t"
                + p1 + "\n\t" + p2String
                + "\n to: \n\t" + p1.resolveSibling(p2String) +
                "\n---------------");

        // Two relative path, parent of current Path is null.
        p1 = Path.of("fruit");
        System.out.println("Parent = " + p1.getParent());
        p2String = "fruit/apple";
        System.out.println("resolveSibling transforms \n\t"
                + p1 + "\n\t" + p2String
                + "\n to: \n\t" + p1.resolveSibling(p2String) +
                "\n---------------");
    }

    // Test other methods on Path
    public static void testTheRest() {

        Path p1 = Path.of("Nacho/Repos/ignamlrz/learn/java");
        Path p2 = Path.of("Nacho/Repos/ignamlrz/learn/java/src");
        Path p3 = Path.of("src");

        // Using startsWith method, passing String
        System.out.println(
                "p1.startsWith(\"LearningAcademy\") = " +
                        p1.startsWith("LearningAcademy"));

        // Using endsWith method, passing String
        System.out.println(
                "p1.endsWith(\"production\") = " +
                        p1.endsWith("production"));

        // Using endsWith method, passing Path
        System.out.println(
                "p2.endsWith(\"" + p3 + "\") = " +
                        p2.endsWith(p3));

        // Using compareTo method, passing Path
        System.out.println(
                "p1.compareTo(p2) = " +
                        p1.compareTo(p2));

        // Using compareTo method, passing Path
        System.out.println(
                "p1.compareTo(p2) = " +
                        p1.compareTo(p2));

        // Getting Real path of a relative path may throw
        // NoSuchFileException
        try {
            System.out.println(
                    "p1.toRealPath() = " +
                            p1.toRealPath());
        } catch (IOException io) {
            io.printStackTrace();
        }

        // Getting Real path of current working directory:
        try {
            System.out.println(
                    "p1.toRealPath() = " +
                            Path.of("").toRealPath());
        } catch (IOException io) {
            io.printStackTrace();
        }

        // Getting Real path of a file on relative path
        try {
            System.out.println(
                    "p1.toRealPath() = " +
                            Path.of("../java/src")
                                    .toRealPath());
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
