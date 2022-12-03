/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 7: Creating and Using Methods
Topic: Create Methods and Constructors
*/
package src.course.Methods;
// Create a class
class ATest {
//    ATest() { // You can remove super(name) if you add this.
//    }
    ATest(String name) { // no more no-args constructor after declaring this.
        System.out.println("I am super " + name);
    }
}

// Create a sub class
class BTest extends ATest {
    private String name;

    // Constructor has one parameter
    BTest(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}

public class ConstructorExampleComplete {
    public static void main(String[] args) {

        // Instantiate the object with the one parameter constructor
        BTest btest = new BTest("Jeff");
        System.out.println(btest.getName());
    }
}