package src.course2.generics.outOfOrdinary;

import java.util.Map;
import java.util.TreeMap;

public class Quiz10 {
    public static void main(String[] args) {
        Map<String, Integer> treemap = new TreeMap<>();

        // Ralph a new employee
        int employeeNo = 1;
        treemap.compute("Ralph",
                (s1, s2) -> (s2 == null) ? employeeNo : s2 + 1);  // Line 1

        int s2 = 3;  // Line 2

//        employeeNo++; compiler error because it must be final.

        // Anne a  new employee
        treemap.compute("Anne",
                (s1, s3) -> (s1 == null) ? employeeNo + 1 : s2 + 1);  // Line 3

        System.out.println(treemap);

    }
}
