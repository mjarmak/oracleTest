package src.course2.io.files.outOfOrdinary;

import java.io.IOException;
import java.nio.file.Path;

public class Quiz33 {

    public static void main(String[] args) throws IOException {
        Path p = Path.of("c:/", "test", "root", "f.txt");

        Path p1 = p.getParent().relativize(p);  // Line 1
        Path p2 = p.getName(0);        // Line 2
        Path p3 = p.subpath(2, 3);     // Line 3

        System.out.println(p1 + " " + p2 + " " + p3);
    }
}
