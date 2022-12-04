/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Anonymous classes
*/

abstract class AnAbstractClass {
    int i;

    public abstract void doSomething();
}

interface Doable {
    void doSomething();
}

public class AnonymousInnerExample {
    String name = "Default";

    public void testAnonymous() {

        // Declare a variable of type AnAbstractClass and immediately
        // define the class body
        AnAbstractClass a = new AnAbstractClass() {
            // Implementing the abstract method on AnAbstractClass
            public void doSomething() {
                System.out.println("Anonymous AnAbstractClass " +
                        "will doSomething with " + i);
            }
        };  // Declaration occurs in an expression and must end with ';'

        a.doSomething();

    }

    public static void main(String[] args) {
        new AnonymousInnerExample().testAnonymous();
    }
}