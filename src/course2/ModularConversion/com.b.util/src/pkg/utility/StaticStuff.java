/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Migration to Modular Application
Topic:  Using Jdeps to identify issues before running on modular jdk
*/

package pkg.utility;

import pkg.util.Utilities;

public class StaticStuff {
    public static void doStaticStuff() {
        System.out.println("module com.b.util: pkg.util.StaticStuff does something");
        Utilities.doUniversalStuff("pkg.util.StaticStuff does something");
    }
    public static void doStaticStuff(String text) {
        System.out.println("module com.b.util: " + text);

    }
}