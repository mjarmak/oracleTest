// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;
import java.util.Map;

class java {

    static String s;
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

        var i5 = 1;
//        i5 = 0.05F; // needs manual casting

        var i6 = 1;
//        i6 = 1L; // needs manual casting

        Object person1 = new Person();
        Person person2 = new Person();
        person1 += "nope";
//        person2 += "nope"; // error, only works on Object
        System.out.println(person1); // acutally concatenated

        String s7 = "Hello";
        String s7_2 = null;
        String[] s7_3 = new String[]{"Hello"};
        String s7_4 = new String("Hello");
        String[] s7_5 = new String[]{new String("Hello")};
        Object o7 = new StringBuilder("Hello").toString();
        Object o7_2 = new String("Hello");
        Object o7_3 = new StringBuilder("Hello").toString().intern();
        Object o7_4 = new String("Hello").intern();
        boolean b7 = s7.equals(null); // ok
        boolean b7_6 = s7.equals(new String("Hello")); // ok
        boolean b7_3 = s7.equalsIgnoreCase(null); // ok
        boolean b7_4 = s7.equalsIgnoreCase(new String("Hello")); // ok
//        int i7 = s7.compareTo(null); // NOT ok
//        boolean b7_2 = s7.contentEquals(null); // NOT ok

        boolean b7_7 = s7.equals(o7); // ok
        boolean b7_8 = s7.equalsIgnoreCase(o7.toString()); // ok
//        IMPORTANT
        boolean b7_9 = s7.equals(o7); // ok but false, this is why .equals is better because o7 was not directly assigned to "Hello" but through an object, changing the reference to the string in the pool
        boolean b7_10 = s7.equals(o7_2); // ok but false, this is why .equals is better because o7 was not directly assigned to "Hello" but through an object, changing the reference to the string in the pool
        boolean b7_11 = s7 == o7_3; // ok and true because of .intern()
        boolean b7_12 = s7 == o7_4; // ok and true because of .intern()
        boolean b7_13 = s7.equals(new StringBuilder("Hello")); // false, you're comparing an object to a string
        boolean b7_13_2 = s7 == (new StringBuilder("Hello").toString()); // ok but false, this is why .equals is better because o7 was not directly assigned to "Hello" but through an object, changing the reference to the string in the pool

        boolean b7_14 = s7 == s7_4; // false because of new String() creates new object
        boolean b7_14_2 = s7 == s7_4.intern(); // true because of .inter()

        boolean b7_15 = false;
        for (var s7_3_s : s7_3) { // true because string was assigned as litteral and not an object
            b7_15= s7 == s7_3_s;
        }
        boolean b7_16 = false;
        boolean b7_16_1 = false;
        boolean b7_16_2 = false;
        for (var s7_5_s : s7_5) {
            b7_16= s7 == s7_5_s; //false because of new String() creates new object
            b7_16_1 = s7 == s7_5_s.toString().intern(); //false, doesnt change anything unless .intern()
            b7_16_2= s7.equals(s7_5_s); //true because .equals compares the value of string and not the object instance
        }

        CharSequence c8 = "nopenope".subSequence(2,5);
        System.out.println(c8);

        String s9 = new String(new char[]{'H', 'e', 'l', 'l', 'o'}, 2, 2);

        String s10 = java.s + "nope";
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
