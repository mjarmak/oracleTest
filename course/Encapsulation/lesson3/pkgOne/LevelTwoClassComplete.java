/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 8: Applying Encapsulation
Topic: Access Modifiers
Sub-Topic: Constructors
*/

package course.Encapsulation.lesson3.pkgOne;

class LevelOneClass {
    // Protected access constructor
    protected LevelOneClass() {
        System.out.println("protected LevelOneClass " +
                "no args constructor");
    }

    // Package-private access constructor
    LevelOneClass(String text) {
        System.out.println("package level LevelOneClass " +
                "single params constructor");
    }
}

public class LevelTwoClassComplete extends LevelOneClass {

    // Protected access constructor
    protected LevelTwoClassComplete() {
        System.out.println("protected LevelTwoClass " +
                "no args constructor");
    }

    // Package-private access constructor
    LevelTwoClassComplete(String text) {
        System.out.println("package level LevelTwoClass " +
                "single params constructor");
    }
}