package src.course2.generics.collections.map;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Map to Set methods
*/

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapSetExamples {
    public static void main(String[] args) {

        // Use Map.of to populate a Map, with comma delimited values
        // representing key1, value1, key2, value2 etc.
        Map<String, Integer> hashMap = new HashMap<>(Map.of(
                "Mary", 30,
                "John", 35,
                "Ralph", 23,
                "George", 15,
                "Kate", 50));
        System.out.println("Initial Values: " + hashMap);
        // This returns a modifiable View of the Map, however, you
        // cannot add entries.
        Set entrySet = hashMap.entrySet();
        entrySet.remove("John");
        System.out.println(hashMap);

        entrySet.remove(Map.entry("John", 25));
        System.out.println(hashMap);

        entrySet.remove(Map.entry("John", 35));
        System.out.println(hashMap);

        System.out.println("---removed John using entrySet---");

        // Collection of just the values...
        Collection<Integer> values = hashMap.values();
        values.remove(23);
        System.out.println(hashMap);

        System.out.println("---removed Ralph using values---");

        // Collection of just the keys
        Collection<String> keySet = hashMap.keySet();
        keySet.remove("Mary");
        System.out.println(hashMap);

        System.out.println("---removed Mary using keys---");

        System.out.println("---Adding values to the map---");

        // Add some more values to original Map.
        hashMap.putAll(Map.of(
                "Carol", 5,
                "Martha", 46,
                "Mark", 33));
        keySet.remove("Martha"); // can still modify the views
        System.out.println(hashMap);
        System.out.println("Size of keySet Set: " + keySet.size());

        System.out.println("---keySet.retainAll(Set.of(\"Carol\", \"Kate\", \"Mary\", \"Andrew\"))---");
        keySet.retainAll(Set.of("Carol", "Kate", "Mary", "Andrew"));
        System.out.println(hashMap);

        System.out.println("---Map<String, Integer> tCopyMutable = new TreeMap<>(Map.copyOf(hashMap))---");
        Map<String, Integer> tCopyMutable =
                new TreeMap<>(Map.copyOf(hashMap));
        tCopyMutable.put("Tom", 30);
        System.out.println(tCopyMutable);

        System.out.println("---Map<String, Integer> tCopyImmutable = Map.copyOf(hashMap)---");
        Map<String, Integer> tCopyImmutable = Map.copyOf(hashMap);
//        tCopyImmutable.put("Tom", 30);
        System.out.println(tCopyImmutable);

        tCopyMutable.put("Ralph", 25);
        System.out.println(tCopyMutable);

        Map<String, Integer> immutableMap = Map.ofEntries(
                Map.entry("Joe", 5),
                Map.entry("John", 10),
                Map.entry("James", 15));
        System.out.println(immutableMap);

        tCopyMutable.putAll(Map.ofEntries(
                Map.entry("Martha", 15),
                Map.entry("Carol", 35)));
        System.out.println(tCopyMutable);
        tCopyMutable.computeIfPresent("Martha", (key, val) -> val * 100);
        System.out.println(tCopyMutable);
    }
}