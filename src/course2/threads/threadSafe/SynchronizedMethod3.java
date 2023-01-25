package src.course2.threads.threadSafe;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Shared data approaches
*/

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// This class represents a ball which contains information
// about who hit the ball and how many times each player hit it
class TheBallInTheAir3 {

    private String ballType = "Volleyball";
    // Total number of hits on the ball

    private volatile int hit; // not enough for writing

    // Map of players and their hits..
    private Map<String, Integer> players = Collections.synchronizedMap(new TreeMap<>());

    // Constructor
    TheBallInTheAir3() {
        players.put("Jane", 0);
        players.put("Mary", 0);
        players.put("Ralph", 0);
        players.put("Joe", 0);
    }

    // Method called by threads, adds player to map if not found
    // or increments value in map
    public int addHit(String player) { // you will get wrong results if you remove 'synchronized'
        this.hit++;
        if (players.containsKey(player)) {
            players.computeIfPresent(player, (key, val) -> ++val);
        } else {
            players.put(player, 1);

        }
        return this.hit;
    }

    // Present writeable output
    public String toString() {
        return "Total " + ballType + " hits: " + this.hit
                + ", Player hits: " + players.values().stream().mapToInt(s -> s).sum()
                + "\nPlayers List: " + players;
    }
}

public class SynchronizedMethod3 {

    // Create a shared ball.
    public static TheBallInTheAir3 sharedBall = new TheBallInTheAir3();

    public static void main(String[] args) {
        // Set up players
        String[] players = {"Jane", "Mary", "Ralph", "Joe"};
        Random r = new Random();
        // random list of player names, representing their turn to hit ball
        List<String> playerTurns =
                Stream.generate(() -> players[r.nextInt(4)])
                        .limit(100)
                        .collect(Collectors.toList());

        ExecutorService executorService = null;

        try {
            executorService = Executors.newFixedThreadPool(5);

            // Start the volleyball game...
            for (String player : playerTurns) {
                executorService.submit(() -> sharedBall.addHit(player));
            }

        } finally {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    // Wait no longer than 1 second for completion confirmation
                    executorService.awaitTermination(1, TimeUnit.SECONDS);
                    System.out.println(sharedBall);

                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}