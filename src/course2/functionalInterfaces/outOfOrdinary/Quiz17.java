package src.course2.functionalInterfaces.outOfOrdinary;

interface FunctionableQuiz {

    int performFunction(String s, int i1, Integer i2);

    public String toString();
}

public class Quiz17 {
    public static void main(String[] args) {
        FunctionableQuiz lambdaA = (s, i, j) -> 1;  // Lambda A
//        FunctionableQuiz lambdaB = (String s, int i, int j) -> 1;  // Lambda B doesn't work
//        FunctionableQuiz lambdaC = (var s, var i, Integer j) -> 1;  // Lambda C doesn't work
        FunctionableQuiz lambdaD = (var s, var i, var j) -> 1;  // Lambda D

        FunctionableQuiz lambdaB = (String s, int i, Integer j) -> 1; // works
    }
}
