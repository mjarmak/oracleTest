/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 3: Working with Java Primitive Data Types and String APIs
Topic: Create and Manipulate Strings
Sub-Topic:  Counting String Objects
*/
 
public class StringCount {
    public static void main(String[] args) {
 
        String stringOriginal = "aaabbb";
 
        // The behavior is the same for all the replace methods,
        // if there is no match, a new String object is NOT created.
        String stringReplaced = stringOriginal.replace('C', 'a');
        System.out.println("1.  stringOriginal==stringReplaced = " +
                (stringOriginal == stringReplaced));
 
        stringReplaced = stringOriginal.replace("CC", "aa");
        System.out.println("2.  stringOriginal==stringReplaced = " +
                (stringOriginal == stringReplaced));
 
        stringReplaced = stringOriginal.replaceAll("CC", "aa");
        System.out.println("3.  stringOriginal==stringReplaced = " +
                (stringOriginal == stringReplaced));
 
        stringReplaced = stringOriginal.replaceFirst("CC", "aa");
        System.out.println("4.  stringOriginal==stringReplaced = " +
                (stringOriginal == stringReplaced));
 
    }
}