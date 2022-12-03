/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 4: Using Operators and Decision Constructs
Topic: Operators
Sub-Topic: Out of Ordinary
*/

package src.course;

public class OperatorOdditiesComplete {
    public static void main(String[] args) {

//        Promote a byte to an int
        byte byte1 = 1;
        var byte2 = +byte1;  // What is byte2?
        System.out.println("byte2" + TestVar(byte2));

        var negativeByte = -byte1;
        System.out.println("negativeByte" + TestVar(negativeByte));

        short short1 = 2;
        var result = byte1 + short1;
        System.out.println("result" + TestVar(result));

        long long1 = 10L;
        double result2 = long1 + (1.0);
        System.out.println("result2" + TestVar(result2));
    }

    // This method works because of the way Java
    // autoboxes and evaluates method parameters...
    public static String TestVar(Object var) {
        String returnValue = " is unknown";
        if (var instanceof Byte) {
            returnValue = " is a byte";
        } else if (var instanceof Character) {
            returnValue = " is a char";
        } else if (var instanceof Short) {
            returnValue = " is a short";
        } else if (var instanceof Integer) {
            returnValue = " is an int";
        } else if (var instanceof Long) {
            returnValue = " is a long";
        } else if (var instanceof Double) {
            returnValue = " is a double";
        } else if (var instanceof Float) {
            returnValue = " is a float";
        }
        return returnValue;
    }
}