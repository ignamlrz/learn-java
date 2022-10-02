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

package org.app.entity;

import base.pck.TransitiveCustomClass;
import base.sample.interfaces.Countable;

/**
 * The class {@link BaseEntity} class is used for the purpose of import all
 * modules with advanced features.
 * <p>
 *
 * @author Ignacio Moral Rodríguez
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html">
 *     Java Language Specification</a>
 * @since 1.0
 */
public class BaseEntity implements Countable {

    /**
     * Constructor of this class
     * <p></p>
     *
     * @implNote Run implemented countable method
     */
    public BaseEntity() {
        countMe();
    }

    /**
     * Execution of this main class
     * <p></p>
     *
     * @implNote Execute the class importing another classes of custom
     * modules
     */
    public static void main(String ...args) {
        for (int i = 0; i < 5; i++) {
            new BaseEntity();
        }
        System.out.println(TransitiveCustomClass.APP_NAME + " created " +
                TransitiveCustomClass.getCounter() + " objects");
    }

    /**
     * Override countMe method from Countable
     */
    @Override
    public void countMe() {
        TransitiveCustomClass.addCounter();
    }
}
