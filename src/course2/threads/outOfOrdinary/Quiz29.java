package src.course2.threads.outOfOrdinary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Quiz29 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        service.submit(() -> {
            throw new Exception("Exception 1");     // Line 1
        });
        service.execute(() -> {
            throw new RuntimeException("Exception 2");  // Line 2
        });
        service.shutdown();
        System.out.println("All done");
    }
}

