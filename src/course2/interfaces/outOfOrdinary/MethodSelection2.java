package src.course2.interfaces.outOfOrdinary;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Nested Class, Extras
*/

class SuperClass2 {
    public void doSomething() {
        System.out.println("SuperClass: doSomething");
    }
}

interface LessSpecificInterface2 {
    default void doSomething() {
        System.out.println("LessSpecific: doSomething");
    }
}

interface MoreSpecificInterface2 {
    default void doSomething() {
        System.out.println("MoreSpecific: doSomething");
    }
}

public class MethodSelection2 extends SuperClass2 // class method is prioritized
        implements MoreSpecificInterface2 {
    public static void main(String[] args) {
        MethodSelection2 methodSelection = new MethodSelection2();
        methodSelection.callDoSomething();
    }

    public void callDoSomething() {
        doSomething();
    }

}