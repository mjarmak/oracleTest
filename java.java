// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

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

        char[] cs11 = new char[5]; // capacity must suffice
        s7.getChars(0, s7.length(), cs11, 0);
        System.out.println(cs11);
        s7.getChars(1, 1, cs11, 0); // does not change anything, calue is still the same
        System.out.println(cs11);
        s7.getChars(1, 3, cs11, 0); // characters are replaced
        System.out.println(cs11);

        int i8 = 10;
        int r8 = i8--; // doesnt change

        int i9 = 10;
        int r9 = --i9 - i9--; // 0, r9 = 9 - 9 --, r9 = 0, i9 becomes 8

        int i10 = 10;
        int r10 = i10-- - --i10; // 2, r10 = 10 - --9 = 2, r10 = 2,  i10 becomes 8
        // the first i10 is not reduced, but by when it is when it gets to the second i10
        // check MoreOdditiesComplete

        // for -- or  ++ you move right to left but for == += -= you move left to right

        Object i11 = 10/3; // returns int

        boolean b12 = true;
        int i12 = 0;
        if (b12 = false) { // doesnt go in
            i12 = 1;
        }

        byte b13 = 127; // largest value for a byte
        int i13 = b13 * 10; // byte converted to an int

        switch (i13) { // i13 must be initialized
            case 10:
            case 11:
            case 12:
            case 13:
                i13 = 0;
                break;
            default:
                i13 = 0;

        }

        int[] i14, i14_2[];
        String[] i15[] = { { "1", "1" }, { "1", "1" } };
        String[] i16[] = new String[2][]; // the first must always have a size, nested array size is optional since it can be initialized later

        // invalid, requires 'new'
//        String[] i17[] = String[][] { { "1", "1" }, { "1", "1" } };

        int[] i17, i17_2 = { 1,2 };

        // invalid, only works for non-arrays
//        int[] i18, i18_2 = i18 = { 1,2 };



        Integer[] integerArray = {0, 1, 2, 3, 4};
        int[] intArray = {0, 1, 2, 3, 4};
        // auto boxing (widerning) will not work in these cases
//        int misMatchedIndex = Arrays.mismatch(intArray, integerArray);
//        boolean theSame = Arrays.equals(intArray, integerArray);
//        int compared = Arrays.compare(intArray, integerArray);
//        but this works because Integer extends Number
        Number[] myNumberArray = {0, 1, 2, 4, 5};
        System.out.println("Arrays.mismatch(myNumberArray, integerArray) = "
                + Arrays.mismatch(myNumberArray, integerArray));
        System.out.println("Arrays.equals(myNumberArray, integerArray) = "
                + Arrays.equals(myNumberArray, integerArray));
//        except this because Number doesn't implement Compara ble
//        int compare = Arrays.compare(myNumberArray, integerArray);

        Integer i18 = (Integer) 10;
        int i19 = i18;

        List<String> s19 = new ArrayList<>();

//      ERRORS
//        typedList.set(typedList.size(), new BaseClass("def"));
//        typedList.add(typedList.size() + 1, new BaseClass("def"));
//        typedList.set(0, typedSubList);
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
