// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;
import java.util.Map;

class java {
    public static void main(String[] args) {

//        System.out.println("j");
//        String s = solution("aba");
//        s = solution("aaa");
//        s = solution("zz");
//        s = solution("codility");
//        s = solution("jaj");
//        s = solution("jarmak");
//        s = solution("mohanad");
//        s = solution("boom");
//        s = solution("qwertyuiopasdfghjklzxcvbnmq");

        long n = 100_0;
        long nn;
        Long Nn = null;

//        while (n > 0) {
//            nn = n;
//        }
//        System.out.println(nn); // error because nn is not initialized

//        do {
//            nn = n;
//        } while(n > 0);
//        System.out.println(nn);

        float f = (float) 0.0D;
//        f = 0.0D; // cant narrow implicitely

        double d = 0.0F; // can widen implicitely

        char c1 = 1;
//        int i2 = 1; char c2 = i2;

        int i3_1 = 1;
        int i3_2 = 2;
        int i3 = i3_1 ++ + i3_2;
        int i4 = i3_1 + i3_2;

        short s5 = 1;
        var k = + s5; //promotes to int
        var test = 1 + s5; //promotes to int
    }

    public static String solution(String S) {
        // write your code in Java SE 8
        Map<Character, Integer> counts = new HashMap<>();
        for (char s : S.toCharArray()) {
            if (!counts.keySet().contains(s)) {
                counts.put(s, 1);
            }
            counts.put(s, counts.get(s) + 1);
        }
        return counts.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey().toString();
    }
}
