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
 * Module which contain examples about Java modules and packages
 * relationship exports<p></p>
 *
 * @since 1
 */
module advanced.module.core {
    // ...allow use base.pck on both advanced.module.utils and
    //    advanced.module .app modules
    exports base.pck to advanced.module.utils, advanced.module.app;
    // ...only allow use base.sample on advanced.module.utils
    exports base.sample to advanced.module.utils;
}