package src.course2.streams.lambdaOperations.outOfOrdinary;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Quiz22 {
    public static void main(String[] args) {

        List aList = List.of("January", "February");
        List bList = List.of("January", "September");
        List cList = List.of("February", "April");

        Stream.of(aList, bList, cList)
                .distinct()     // Line 1
                .flatMap(Collection<String>::stream)  // Line 2
                .peek(s -> System.out.print(s + ","))
                .allMatch(s -> s.length() >= 5);  // Line 3

    }
}
