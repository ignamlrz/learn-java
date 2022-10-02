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

package base.sample.interfaces;

import base.pck.TransitiveCustomClass;
import base.sample.HiddenCustomClass;

/**
 * The class {@link Countable} is used for the purpose of been exported to
 * <b>advanced.module.app</b> module. Also, we can see that we can import all
 * packages declared on <b>advanced.module.core</b>
 * <p></p>
 *
 * @author Ignacio Moral Rodríguez
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html">
 *     Java Language Specification</a>
 * @since 1.0
 */
public interface Countable {
    void countMe();

    /**
     * Execution of this main class
     * <p></p>
     *
     * @implNote Use all packages of advanced.module.core
     */
    static void main(String ...args) {
        // We can use packages base.pck and base.sample from
        // advanced.module.core because this is a friend module
        System.out.println(TransitiveCustomClass.APP_NAME);
        System.out.println(HiddenCustomClass.APP_NAME);
    }
}
