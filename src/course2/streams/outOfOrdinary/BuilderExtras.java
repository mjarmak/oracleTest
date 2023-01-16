package src.course2.streams.outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  Stream.Builder
*/

import java.util.stream.Stream;

public class BuilderExtras {
    public static void main(String[] args) {

        // Builder is mutable object, so like a StringBuilder,
        // you do not need to self reference, but you can...
        Stream.Builder<String> builder = Stream.builder();
        builder = builder.add("a");  // ok but not necessary
        builder.add("b");  // this works
        builder.add("c");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);

        // Using a raw Builder with chained methods
        // no errors for raw type
        Stream.builder().add("a").add(10).build().forEach(
                System.out::println);

        // Typing builder() method returns correctly typed Stream
        // typed, so the added elements must be 'String'.
        Stream.<String>builder().add("a").add("b").build().forEach(
                System.out::println);

        Stream.Builder builder3 = Stream.<String>builder();
        builder3.add(new Object());
        builder3.add("a");
        Stream<String> s3 = builder3.build();
        s3.forEach(System.out::println);
    }
}