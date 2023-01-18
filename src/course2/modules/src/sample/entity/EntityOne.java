/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 9: Migration to Modular System.
*/

package src.course2.modules.src.sample.entity;

import src.course2.modules.sample.core.src.sample.core.UtilityClass;

public class EntityOne {
    // Constructor calls UtilityClass
    public EntityOne(String s) {
        UtilityClass.doSomethingStatic("EntityOne instantiated with " + s);
    }

}