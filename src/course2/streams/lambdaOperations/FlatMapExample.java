package src.course2.streams.lambdaOperations;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic:  Extract stream data using map, peek and flatMap
*/

import src.course2.streams.lambdaOperations.element.Course;
import src.course2.streams.lambdaOperations.element.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {

        // Local Variable studentList will contain results
        List<Student> studentList = Stream.of(
                // Stream of courses created
                new Course("Geometry 101", 3),
                new Course("Java 101", 5),
                new Course("History 101", 4))
                .peek(System.out::println)
                // Map from course object to a stream of student objects
                .flatMap(course ->
                        course.getStudentList().stream()
                )

                // doesn't work because '.map()' won't flatten the resulting List/Stream.
//                .map(course ->
//                        course.getStudentList()
//                )
                // Terminal operation returns list of student
                .collect(Collectors.toList());

        // Print the entire student list for all courses
        System.out.println("Complete Student Population: ");
        studentList.forEach(System.out::println);
    }
}