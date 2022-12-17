package src.course2.interfaces.defaultMethods;
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Default methods
*/

// Interface extends Defaultable, and overrides the default method
public interface MoreSpecificDefaultable extends Defaultable {
     void defaultNotAbstractMethod();

//    default void defaultNotAbstractMethod() {
//        System.out.println("MoreSpecificDefaultable Default");
//    }
}

// Class implements both interfaces
class MoreSpecific extends DefaultClass implements
        Defaultable, MoreSpecificDefaultable {

    // implements the abstractMethod and calls the default method
    public void abstractMethod() {
        // Which default method is used?
//        DefaultClass > MoreSpecificDefaultable > Defaultable
        defaultNotAbstractMethod();


//        doesnt't work because DefaultClass implements Defaultable
//        Defaultable.super.defaultNotAbstractMethod();
    }

    // to call the method inside Defaultable
//    public void defaultNotAbstractMethod() {
//        new Defaultable() {
//            public void abstractMethod() {
//            }
//        }.defaultNotAbstractMethod();
//    }

    // invokes the abstract method
    public static void main(String[] args) {
        new MoreSpecific().abstractMethod();
    }
}