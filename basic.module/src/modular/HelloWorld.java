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

package modular;
import pck.to.export.TypeToExport;

/**
 * The class {@link HelloWorld} class is used for the purpose of importing
 * the {@link TypeToExport} class, which is on <b>basic.module.utils</b> module.
 * <p>
 * For this, we have to modify <b>module-info.java</b> on <b>basic.module</b>
 * requiring the module which contain that type:
 * <blockquote><pre>
 *      module basic.module {
 *          // Modules to import
 *          requires basic.module.utils;
 *      }
 * </pre></blockquote>
 *
 * @author Ignacio Moral Rodríguez
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html">
 *     Java Language Specification</a>
 * @since 1.0
 */
public class HelloWorld {

    /**
     * Execution of this main class
     * <p></p>
     *
     * @implNote Execute the class importing another class from another custom
     * module
     */
    public static void main(String ...args) {
        System.out.println("Hello world");
        System.out.println("--> Input Args: " + TypeToExport.doSomething(args));
    }
}
