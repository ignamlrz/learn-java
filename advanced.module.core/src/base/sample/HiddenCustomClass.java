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

package base.sample;

/**
 * The class {@link HiddenCustomClass} is used for the purpose of been exported
 * to <b>advanced.module.utils</b> module only.
 * <p></p>
 *
 * @author Ignacio Moral Rodríguez
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html">
 *     Java Language Specification</a>
 * @since 1.0
 */
public class HiddenCustomClass {

    /**
     * This is a public constant static field
     *
     * @implNote This field would be accesible by other classes
     */
    public static final String APP_NAME = "Hidden Custom Class";
}
