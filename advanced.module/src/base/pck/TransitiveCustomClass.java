/*
 * Academic Free License ("AFL") v. 3.0
 *
 * This Academic Free License (the "License") applies to any original work
 * of authorship (the "Original Work") whose owner (the "Licensor") has placed
 * the following licensing notice adjacent to the copyright notice for the
 * Original Work:
 *
 * Licensed under the Academic Free License version 3.0
 */

package base.pck;

/**
 * The class {@link TransitiveCustomClass} class is used for the purpose of been
 * imported as transitive package, concatenating import-export flow.
 *
 * @author Ignacio Moral Rodríguez
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html">
 *     Java Language Specification</a>
 * @since 1.0
 */
public class TransitiveCustomClass {
    /**
     * This is a public constant static field
     *
     * @implNote This field would be accesible by other classes
     */
    public static final String APP_NAME = "Transitive Custom Class";

    /**
     * This is a private constant static field
     *
     * @implNote This field would not be accesible by other classes
     */
    private static int counter;

    /**
     * This is a public static method which update counter
     *
     * @implNote This field would be accesible by other classes
     */
    public static void addCounter() {
        counter++;
    }

    /**
     * This is a public static method which get counter state
     *
     * @implNote This field would be accesible by other classes
     */
    public static int getCounter() {
        return counter;
    }
}
