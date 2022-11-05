/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 8: Applying Encapsulation
Topic: Applying Access Modifiers
*/

package course.Encapsulation.lesson1.pkgb;


import course.Encapsulation.lesson1.pkga.SuperClassComplete;

class PackageBClassComplete {
    void testAccess() {
        SuperClassComplete c = new SuperClassComplete();
        System.out.println("A non sub-class class in a different package" +
                " has access only to a public class's public fields ");
        System.out.println("- SuperClass().publicInt = " + c.publicInt);
    }
}

public class ParentClassComplete extends SuperClassComplete {
    public static void main(String[] args) {
        new PackageBClassComplete().testAccess();
        new ParentClassComplete().testAccess();
    }

    void testAccess() {
        System.out.println(this.getClass().getName() +
                " has access to only it's parent's public and protected" +
                " attributes if it's declared in another package:");
        System.out.println("- this.publicInt = " + this.publicInt);
        System.out.println("- this.protectedInt = " + this.protectedInt);

        // You can use the word super to get at it too, but superfluous
        // in this context
        System.out.println("- super.protectedInt = " + super.protectedInt);

        // Access protected variable through another instance of ParentClass
        System.out.println("- new ParentClass().protectedInt = " +
                new ParentClassComplete().protectedInt);

//        // What happens if you access through instance of SuperClass here?
//        System.out.println("- new SuperClass().protectedInt = "
//                + new SuperClassComplete().protectedInt);

        // What happens if you access through instance of SuperClass here?
        System.out.println("- new SuperClass().protectedInt not available" +
                " through SuperClass instance in " +
                this.getClass().getName());
    }
}