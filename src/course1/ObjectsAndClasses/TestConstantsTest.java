package src.course1.ObjectsAndClasses;

class TestConstants {
    public static boolean debugFlag ;
    public static final String APP_NAME ;  // Line 1
    static {
        System.out.println("Initialized");   // Line 4
        if (debugFlag) APP_NAME="FooBarApp";  // Line 2
        else  APP_NAME="GreatApp";
    }
}

public class TestConstantsTest {
    public static void main(String[] args) {
        // The act of setting the debugFlag actually executes the static initializer, which uses the current value of debugFlag (false) to set the APP_NAME to "GreatApp".
        TestConstants.debugFlag=true;
        System.out.println(TestConstants.APP_NAME);   // Line 4
    }
}