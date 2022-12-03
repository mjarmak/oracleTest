/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 8: Applying Encapsulation
Topic: Access Modifiers
Sub-Topic: Constructors
*/
package src.course.Encapsulation.lesson3.pkgTwo;

import src.course.Encapsulation.lesson3.pkgOne.LevelTwoClassComplete;

// Extends class from a different package
class LevelThreeClass extends LevelTwoClassComplete {

    // package-private constructor
    LevelThreeClass() {
        this("good");
        System.out.println("package LevelThreeClass " +
                "no args constructor");
    }

    // private constructor
    private LevelThreeClass(String text) {
        super();
        System.out.println("private LevelThreeClass " +
                "single params constructor");
    }
}

public class ConstructorAccessComplete {
    public static void main(String[] args) {
        // The constructor test
        LevelThreeClass c = new LevelThreeClass();

    }
}