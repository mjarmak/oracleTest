package src.course2.funfamentals.outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Nested Class, Extras
*/

public class TestInheritance extends OuterMost {
    public static void main(String[] args) {
        new OuterMost().new ProtectedInner(); // works
//        this.new PublicInner(); doesnt work because main is static and 'this'
//        or instance variables and methods don't work in static.
        new TestInheritance().testInnerClassMembers();
    }

    private void testInnerClassMembers() {
        // non-static method - instance of current class exists so inner
        // classes (with the right access modifiers) are available...
        new ProtectedInner();
        // First Level
        new PublicInner();

        // classes (with the right access modifiers) are available...
        this.new ProtectedInner();
        // First Level
        this.new PublicInner();

        this.new ProtectedInner();
        // First Level
        this.new PublicInner();

        // Second Level
        new PublicInner().new NestedInnerSecondLevel();

//        doesn't work
//        new PublicInner().NestedInnerSecondLevel();

        // Customized Second Level
        new KeepExtending();
    }

    // This inner class extends the inner class that was inherited
    // from the OuterMost class
//    class KeepExtending extends PublicInner.NestedInnerSecondLevel { doesnt work, need an instance of OuterMost first
    class KeepExtending extends OuterMost.PublicInner {
        KeepExtending() {
            System.out.println("Extend the inner class as an " +
                    "inherited member");
        }

        class ExtendingFurther extends
                PublicInner.NestedInnerSecondLevel {
            ExtendingFurther() {
                System.out.println("Extending a deeper level of " +
                        "an inherited member");
            }
        }
    }
}