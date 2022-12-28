package src.course2.generics.outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics & Wildcards
*/

import java.util.ArrayList;
import java.util.List;

public class GenericContainerWorks<T> {

    // Container wraps an ArrayList
    List<T> wrappedList;

    // not nice
//    List<? super T> wrappedList;

    // don't work
//    List<?> wrappedList;
//    List<Object> wrappedList;
//    List<? extends T> wrappedList;
//    List wrappedList;

    // Constructor
    GenericContainerWorks(List<T> wrappedList) {
        this.wrappedList = wrappedList;
    }

    // Wrap get method with custom one
    public T myGet(int index) {
        T v = (T) wrappedList.get(index);
        return (T) v;
    }

    // Wrap add method with custom one
    public void myAdd(T o) {
        wrappedList.add(o);
    }

    // Wrap ArrayList.toString()
    public String toString() {
        return wrappedList.toString();
    }

    // Main method declares and constructs an instance
    public static void main(String[] args) {
//        List<CharSequence> l = new ArrayList<>();
//        GenericContainer<CharSequence> g = new GenericContainer<>(l);

        List<CharSequence> l = new ArrayList<>(
                List.of(new StringBuilder("bye")));
        GenericContainerWorks<CharSequence> g = new GenericContainerWorks<>(l);

        // Add elements to wrapped List
        g.myAdd("hi");

        // Get first element from wrapped List
        Object o = g.myGet(0);
        System.out.println("Element 0 = " + o);

        // Print List
        System.out.println("Wrapped List = " + g);
    }

}