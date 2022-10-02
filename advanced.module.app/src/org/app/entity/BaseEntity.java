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
 * The class {@link BaseEntity} is used for the purpose of import all
 * <b>advanced.module.*</b> modules, showing how it works Java packages and
 * modules relationship
 * <p>
 *
 * @author Ignacio Moral Rodríguez
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html">
 * Java Language Specification</a>
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
     * @implNote Use other custom packages and modules
     */
    public static void main(String... args) {
        for (int i = 0; i < 5; i++) {
            new BaseEntity();
        }
        System.out.println(TransitiveCustomClass.APP_NAME + " created " +
                TransitiveCustomClass.getCounter() + " objects");
    }

    /**
     * Override countMe method from Countable<p>
     *
     * @implNote We can see that can access to <b>base.pck</b> package
     * of <b>advanced.module.core</b> (because of friend module), but we can
     * not access to <b>base.sample</b> of <b>advanced.module.core</b> due to
     * not is explicitly exported to this module on his <b>module-info.java</b>
     */
    @Override
    public void countMe() {
        // ...TransitiveCustomClass is used from base.pck, which is accesible
        TransitiveCustomClass.addCounter();
        // ...HiddenCustomClass can not be used because not is qualified
        //    specified on his module-info.java and does not export explicitly
        // HiddenCustomClass.addCounter();
    }
}
