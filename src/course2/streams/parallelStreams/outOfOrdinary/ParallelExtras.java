package src.course2.streams.parallelStreams.outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Collect and Reduce
*/

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParallelExtras {
    public static void main(String[] args) {

        Set<String> set = new TreeSet<>(Set.of("b", "c", "d"));

        System.out.println("---------PARALLEL---------");
        // Using reduce with StringBuilder
        String firstResult = set
                .parallelStream()
                .reduce(String::concat)
                .get();

        System.out.println("1 firstResult = " + firstResult);

        // Using collect with StringBuilder
        String secondResult = set
                .parallelStream()
                // collect requires Collector argument
                .collect(Collectors.joining());
        System.out.println("2 secondResult = " + secondResult);

        // Using reduce with StringBuilder, results is not good because a new string builder is created for each element
        StringBuilder firstResult2 = set
                .parallelStream()
                .map(s -> new StringBuilder(s))
                .reduce(new StringBuilder(),
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));

        System.out.println("3 firstResult = " + firstResult2);

        // Using reduce with StringBuilder, results is good now
        firstResult2 = set
                .parallelStream()
                .map(s -> new StringBuilder(s))
                .reduce(new StringBuilder(),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));

        System.out.println("4 b.append(a) firstResult = " + firstResult2);

        // Using reduce with StringBuilder, results is good now
        firstResult2 = set
                .parallelStream()
                .map(s -> new StringBuilder(s))
                .reduce(new StringBuilder("a"),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));

        System.out.println("5 b.append(a) firstResult = " + firstResult2);

        // Using collect with StringBuilder
        StringBuilder secondResult2 = set
                .stream().parallel()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(StringBuilder::new,
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));
        System.out.println("6 secondResult = " + secondResult2);

        // Using collect with StringBuilder
        secondResult2 = set
                .stream().parallel()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(StringBuilder::new,
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));
        System.out.println("6 b.append(a) secondResult = " + secondResult2);

        // Using reduce with StringBuilder
        firstResult = set
                .parallelStream()
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce("",
                        String::concat,
                        String::concat);

        System.out.println("7 firstResult = " + firstResult);

        // Using concat with String
        // does not work because 'String.concat(String)' is not self referencing and does not return any value and here is a 'BiConsumer',
        // so the value will not be reassigned, so use a 'StringBuilder' in this case instead.
        secondResult = set
                .stream().parallel()
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(String::new,
                        String::concat,
                        String::concat);
        System.out.println("8 secondResult = " + secondResult);

        System.out.println("---------SERIAL---------");

        // Using reduce with 'String.concat(String)'
        // this works because it's treated as a 'BinaryOperator' where the value is reassigned.
        firstResult = set
                .stream()
                .reduce(String::concat)
                .get();

        System.out.println("firstResult = " + firstResult);

        // Using collect with StringBuilder
        secondResult = set
                .stream()
                // collect requires Collector argument
                .collect(Collectors.joining());
        System.out.println("secondResult = " + secondResult);

        // Using reduce with StringBuilder
        firstResult2 = set
                .stream()
                .map(s -> new StringBuilder(s))
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce(new StringBuilder(),
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));

        System.out.println("firstResult = " + firstResult2);

        // Using collect with StringBuilder
        secondResult2 = set
                .stream()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(StringBuilder::new,
                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));
        System.out.println("secondResult = " + secondResult2);


        // Using reduce with StringBuilder, results is good now
        firstResult2 = set
                .stream()
                .map(s -> new StringBuilder(s))
                .reduce(new StringBuilder(),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));

        System.out.println("firstResult = " + firstResult2);

        // Using reduce with StringBuilder, results is good now
        firstResult2 = set
                .stream()
                .map(s -> new StringBuilder(s))
                .reduce(new StringBuilder("a"),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));

        System.out.println("firstResult = " + firstResult2);
    }
}