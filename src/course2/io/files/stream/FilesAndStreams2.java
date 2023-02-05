package src.course2.io.files.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesAndStreams2 {

    public static void main(String[] args) {
        Path src = Paths.get("src");

        System.out.println("-----------------------------------");
        System.out.println("Find results for " + src +
                " Directory, Regular files starting with 'F'");
        System.out.println("-----------------------------------");
        // Need to wrap in try/resources or try/catch so that directory
        // is appropriately closed
        int maxDepth = 5;
        try (
                Stream<Path> str = Files.find(src, maxDepth,
                        (f, a) -> {
                            return
                                    f.getFileName().
                                            toString().startsWith("F")
                                            &&
                                            a.isRegularFile();
                        })
        ) {
            str
                    .limit(8)
                    .forEach(System.out::println);
        } catch (
                IOException io) {
            System.out.println("Problem with find " + io);
        }

        // Check files, interested in those modified in last x hours
        int hrsToCheck = 72;
        // Translate into milliseconds
        int elapsedMs = hrsToCheck * 60 * 60 * 1000;
        // Get the current time in milliseconds
        long now = System.currentTimeMillis();

        System.out.println("-----------------------------------");
        System.out.println("Find results for " + src + " Directory, " +
                "Regular files modified in last " + hrsToCheck + " hours");
        System.out.println("-----------------------------------");

        // Need to wrap in try/resources or try/catch so that stream
        // is appropriately closed
        try (Stream<Path> str = Files.find(src, maxDepth,
                // f below represents the Path element on the stream,
                // a below represents the BasicFileAttributes belong to f
                (f, a) -> {
                    return
                            // Check modified time to the elapsed time in ms.
                            (now - a.lastModifiedTime().toMillis())
                                    < elapsedMs
                                    &&
                                    a.isRegularFile();
                })
        ) {
            str
                    .forEach(System.out::println);

        } catch (IOException io) {
            System.out.println("Problem with find " + io);
        }
    }
}
