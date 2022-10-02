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

/**
 * Intermediate module which contain examples about Java modules and packages
 * relationship exports and transitive imports<p></p>
 *
 * @since 1
 */
module advanced.module.utils {
    requires transitive advanced.module.core;
    exports base.sample.interfaces;
}