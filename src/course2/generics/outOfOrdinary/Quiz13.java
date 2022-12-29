package src.course2.generics.outOfOrdinary;

import java.util.ArrayList;
import java.util.List;

public class Quiz13 {
    public static void main(String[] args) {
//        List<Number> list = new ArrayList<Integer>();  // Line 1 bad
//        list.add(10L); // Line 2 bad if Integer
//        list.add(10.0); // Line 3 bad if Integer
//        list.add(10); // Line 4
//        System.out.println(list);

//        test1(10.0f); // autoboxed to Float so doesn't work
//        test1(10L); // autoboxed to Long so doesn't work
//        test1(list);

    }

    private static void test1(Integer value) {
        System.out.println(value);
    }
    private static void test1(List<?> value) {
        System.out.println(value);
    }
}
