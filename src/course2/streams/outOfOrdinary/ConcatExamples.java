package src.course2.streams.outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  Stream concat method
*/

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class ConcatExamples {
    public static void main(String[] args) {

        // Set up some test data
        Set tree1 = new TreeSet(List.of("Ralph", "Larry", "Carol", "Mark"));
        Set tree2 = new TreeSet(List.of("Mark", "Mary", "Maggie"));

        // Print each set's elements
        System.out.println("TreeSet orders naturally, " +
                "print using Set.forEach --");
        System.out.println("---First TreeSet---");
        tree1.forEach(System.out::println);
        System.out.println("---Second TreeSet---");
        tree2.forEach(System.out::println);

        System.out.println("TreeSet orders naturally, " +
                "print using stream().forEach() --");

        // Create streams for each Set, print each stream's elements
        Stream<String> stream1 = tree1.stream();
        stream1 = stream1.sorted(Comparator.reverseOrder());

        System.out.println("---First Stream---");
        stream1.forEach(System.out::println);

        Stream<String> stream2 = tree2.stream();
        stream2 = stream2.filter(s-> s.charAt(s.length()-1) != 'y');

        System.out.println("---Second Stream---");
        stream2.forEach(System.out::println);

        // fails because streams are already terminated
//        Stream<String> merged1 = Stream.concat(stream1, stream2);
//        merged1.forEach(System.out::println);

        Stream<String> stream3 = tree1.stream();
        stream3 = stream3.peek(s -> System.out.print("-- 1 -- "));

        Stream<String> stream4 = tree2.stream();
        stream4 = stream4.peek(s -> System.out.print("-- 2 -- "));


        System.out.println("---Merged---");
        Stream<String> merged2 = Stream.concat(stream3, stream4);

//        fails because stream3 and stream4 are closed after concatenation
//        Stream<String> merged3 = Stream.concat(stream3, stream4);
//

//        merged2.distinct().forEach(System.out::println);
//
//        Stream<String> newMerge = Stream.concat(stream3, Stream.of("Zoe","Pete"));

        merged2 = merged2.distinct();

//        Stream<String> newMerge = Stream.concat(stream3, Stream.of("Zoe", "Pete"));

//        stream3 = stream3.sorted(Comparator.reverseOrder());

        tree1.add("Zoe");

        merged2.forEach(System.out::println);
    }
}