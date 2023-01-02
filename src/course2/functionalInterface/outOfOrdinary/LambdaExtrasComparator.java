package src.course2.functionalInterface.outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 5: Functional Interface and Lambda Expressions
Topic:  Lambda Expression Examples
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

interface ConfuseableComparator<String> extends Comparator<String> {

    default int compare(String s1, String s2) {
        System.out.println("In compare method");
        Random r = new Random();
        int i = r.nextInt();
        if (i % 2 == 0) i = -i;
        return i;
    }

    int dummy(String s1, String s2);
}

class ConfusedComparator<T> implements ConfuseableComparator<String> {
    private String name;

    ConfusedComparator(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public int dummy(String s1, String s2) {
        return 0;
    }
}

public class LambdaExtrasComparator {
    public static void main(String[] args) {
        Comparator c = (s, t) -> -1;
        List<ConfusedComparator> list = new ArrayList<>();
        list.add(new ConfusedComparator<String>("Jane"));
        list.add(new ConfusedComparator<String>("Mark"));
        list.add(new ConfusedComparator<String>("Emily"));

        Collections.sort(list, c); // calls compare
//        c.dummy("",""); // Comparator doesn't contain this method
        System.out.println(list);
    }
}