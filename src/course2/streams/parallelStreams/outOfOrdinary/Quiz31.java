package src.course2.streams.parallelStreams.outOfOrdinary;

import java.util.ArrayList;
import java.util.List;

public class Quiz31 {
    public static void main(String[] args) {
        List<Integer> result = List.of(1, 2)
                .parallelStream()  // Position 1
                .collect(ArrayList::new,
                        (x, y) -> x.add(y),  // Position 2
                        (x, y) -> x.addAll(y)  // Position 3
                );
        System.out.println(result);

        StringBuilder result2 = List.of(1, 2)
                .parallelStream()  // Position 1
                .collect(StringBuilder::new,
                        (x, y) -> x.append(y),  // Position 2
                        (x, y) -> x.append(y)  // Position 3
                );
        System.out.println(result2);

    }
}
