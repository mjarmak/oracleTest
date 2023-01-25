package src.course2.threads.outOfOrdinary;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Quiz30 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        Iterator<Integer> iterator = list.iterator();

        Thread t1 = new Thread(() -> list.add(10));
        Thread t2 = new Thread(() -> list.add(20));
        t2.start();
        t1.start();
        t1.join();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}

