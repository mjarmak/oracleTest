package src.course2.interfaces.outOfOrdinary;
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Method clashing
*/

interface FirstInterface2 {
    // private method
    private void methodA() { // would crash if was default
        System.out.println("FirstInterface's default method A");
    }
}

interface SecondInterface2 extends FirstInterface2 {
    // static (and public) method
    static void methodA() {
        System.out.println("SecondInterface's default method A");
    }
}
public class ClashingMethods2 implements SecondInterface2 {
    public static void main(String[] args) {
        ClashingMethods2 first = new ClashingMethods2();
        // Calling static method on an interface
        SecondInterface2.methodA(); // error without the qualifier SecondInterface2

// cannot call static method without interface qualifier
//        first.methodA();

    }
}