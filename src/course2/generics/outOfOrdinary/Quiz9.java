package src.course2.generics.outOfOrdinary;

import java.util.LinkedHashMap;
import java.util.Map;

public class Quiz9 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Ralph", 55);

        map.merge("Ralph", 100, Quiz9::mergeFunction);  // Line 1
        map.merge("Ros", 56, Quiz9::mergeFunction);  // Line 2
        System.out.println(map);

    }

    static Integer mergeFunction(Integer i1, Integer i2) { // existing value and passed value
        if (i2 < 55) return null;
        return i1 + i2;  // Line 3
    }
}
