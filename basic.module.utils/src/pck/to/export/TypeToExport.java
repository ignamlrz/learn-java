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

package pck.to.export;

/**
 * The class {@link TypeToExport} is used for the purpose of been exported
 * to external modules.
 * <p>
 * For this reason, we have to modify <b>module-info.java</b> on
 * <b>basic.module.utils</b> module allowing export all packages of this module.
 * <blockquote><pre>
 *      module basic.module.utils {
 *          // Packages to export
 *          exports pck.to.export;
 *      }
 * </pre></blockquote>
 *
 * @author Ignacio Moral Rodríguez
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html">
 *     Java Language Specification</a>
 * @since 1.0
 */
public class TypeToExport {

    /**
     * This is a public static method
     * <p></p>
     *
     * @implNote This field would be accesible by other modules
     * @return something
     */
    public static String doSomething(String ...args) {
        return String.join(",", args);
    }
}