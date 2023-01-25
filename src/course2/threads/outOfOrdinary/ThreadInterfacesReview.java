package src.course2.threads.outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Submitting Callable vs Runnable vs Supplier
*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

// Don't forget that Thread implements Runnable interface but
// Thread itself has a run() method which does nothing in this instance
class ThreadDoesNothing extends Thread {
    ThreadDoesNothing() {
        System.out.println("ThreadDoesNothing created");
    }
}

// Custom thread overrides the run() method
class ThreadDoesSomething extends Thread {

    public void run() { // throws Exception { // clash with the interface's method
        // Unchecked Exception
        throw new RuntimeException("Extended Thread chokes");
//        throw new Exception(); // impossible
    }
}

public class ThreadInterfacesReview {
    public static void main(String[] args) {

        //  Custom Thread does not override Thread's run() method
        new ThreadDoesNothing().start();

        // Custom Thread implements run(), throws RuntimeException
        new ThreadDoesSomething().start();

        // Get instance of SingleThreadExecutor
        ExecutorService service = Executors.newSingleThreadExecutor();

        // Call execute on service, and pass it an instance of Thread
        service.execute(new ThreadDoesNothing());

        // Call submit on service, and pass it an instance of Thread
        Future<?> f = service.submit(new ThreadDoesSomething());

        // Runnable variable assigned a lambda expression that
        // throws unchecked exception
        Runnable r1 = () -> {
            throw new RuntimeException(
                    "Runnable chokes in service.execute()");
        };
        try {
            // execute method called which is void
            service.execute(r1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Runnable variable assigned a lambda expression that
        // throws unchecked exception
        Runnable r2 = () -> {
            // cannot throw a checked exception
//            throw new Exception(
//                    "Runnable chokes in service.submit()");
            throw new RuntimeException(
                    "Runnable chokes in service.submit()");
        };
        // submit method called which returns a Future
        Future<?> f1 = service.submit(r2);

        // Callable variable assigned a lambda expression that
        // throws unchecked exception
        Callable c = () -> {
            throw new Exception(
                    "Callable chokes in service.submit()");
        };
        // submit method called returns a Future
        Future f2 = service.submit(c);

        // Supplier
        Supplier s = () -> {
            throw new RuntimeException(
                    "Suppplier::get chokes in service.submit()");
        };
        Future f3 = service.submit(s::get);

        service.shutdown();

        System.out.println(f);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        new Thread(() -> {
            throw new RuntimeException(
                    "Lambda chokes in Thread constructed with Runnable");
        }).start();

    }
}