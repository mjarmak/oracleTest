package src.course1.exceptions;

public class Quiz1 {
    public static void main(String[] args) {
        int i;
        try {
            i = 0;
//            System.out.println("i =" + 10 / i++);
        } catch (RuntimeException e) {

        } finally {
//            Error because i is not initialized outside the try block.
//            Even if i is initialized in the try block, it is still seen as uninitialized here.
//            System.out.println("i = " + i);
        }
    }
}
