package src.course2.io.serialization;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Serialization / Deserialization
*/

import java.io.*;

class Animal1 {
    int age;
    int weight;

    Animal1() {
        System.out.println("Inside a no-args Animal constructor");
    }

    Animal1(int age) {
        System.out.println("Inside single args Animal constructor");
    }
}

// Class must implement Serializable if it does not extend
// a class that implements Serializable...
class Pet1 extends Animal1 implements Serializable {
    private String name;
    private String type;
    private transient String breed = "Unknown";

    // No arguments constructor
    Pet1() {
        super(0);
        System.out.println("Inside no args Pet constructor");
    }

    // Constructor takes name and type of Pet
    Pet1(String name, String type) {
        super(0);
        this.name = name;
        this.type = type;
        System.out.println("Inside Pet(name,type) constructor");
    }

    // Use IntelliJ generated toString() method
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

}

public class SerializationExample1 {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        System.out.println("--------- Serialization -----------");

        String fileName = "Brandy2.ser";

        Pet1 originalPet = new Pet1("Brandy", "Dog");
        originalPet.age = 5;
        originalPet.weight = 30;

        System.out.println("--------- Original State -----------");
        System.out.println(originalPet);

        // Use try with resources (automatically closes file) to output
        // the Pet object
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(
//                new FileOutputStream(fileName))) {
//            // write the Pet to a file
//            outputStream.writeObject(originalPet);
//        }

        System.out.println("--------- Deserialization -----------");

        Pet1 deserializedPet = null;
        // Use try with resources (automatically closes file) to input
        // the Pet object
        try (ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            try {
                // read the Pet from a file
                deserializedPet = (Pet1) inStream.readObject();

                // Need to check for EOFException    
            } catch (EOFException e) {
                // Ignore, end of file
            }
        }

        System.out.println("------- Deserialized State ------");
        System.out.println(deserializedPet);

    }
}