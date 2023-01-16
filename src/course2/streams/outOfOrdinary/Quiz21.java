package src.course2.streams.outOfOrdinary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Quiz21 {
    public static void main(String[] args) {
        new Quiz21().useStream(10);
    }

    private void useStream(int index) {
        List<Integer> intList = new ArrayList<>(List.of(10, 20));
        intList.stream()
                .map(s -> s + index);  // Line 1

        intList.stream()
                .sorted(Comparator.reverseOrder()); // Line 2

        intList.stream()
                .forEach(System.out::print);

    }
}
