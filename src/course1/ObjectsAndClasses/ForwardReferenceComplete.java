/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 6: Describing and Using Objects and Classes
Topic: Declare and Instantiate Objects
Sub-Topic: Initializers, Forward References
*/

// For all the examples below, the initializers reference variables
// declared after the blocks.

package src.course1.ObjectsAndClasses;

class Thing {

    // Constructor
    Thing() {
        secondString = "b" + secondString;
    }

    // Initializer
    {
        firstString = "a" + thirdString;
    }

    // Static Initializer
    static {
//        System.out.println(thirdString);
        thirdString = "c";
    }

    // Two instance variables
    String firstString;
    String secondString;

    // static variable
    static String thirdString;

    public String toString() {
        return firstString + secondString + thirdString;
    }
}

public class ForwardReferenceComplete {
    public static void main(String[] args) {
        Thing one = new Thing();
        System.out.println(one.thirdString);
        System.out.println(one);
    }
}