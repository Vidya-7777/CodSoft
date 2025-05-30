import java.util.Scanner;
import java.util.concurrent.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        System.out.println("Quiz on JAVA: ");
        System.out.println("Note: There are 5 questions, each with a time limit of 10 seconds.");
        System.out.println("1. Which data type is used to create a variable that should store text?");
        System.out.println("a) String");
        System.out.println("b) string");
        System.out.println("c) Txt");
        System.out.println("d) myString");
        if (getAnswerWithTimer(sc, 'a')) {
            score++;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("2. Which method can be used to find the length of a string?");
        System.out.println("a) length()");
        System.out.println("b) len()");
        System.out.println("c) getLength()");
        System.out.println("d) getSize()");
        if (getAnswerWithTimer(sc, 'a')) {
            score++;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("3. Which method can be used to return a string in upper case letters?");
        System.out.println("a) tuc()");
        System.out.println("b) touppercase()");
        System.out.println("c) toUpperCase()");
        System.out.println("d) upperCase()");
        if (getAnswerWithTimer(sc, 'c')) {
            score++;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("4. How do you call a method in Java?");
        System.out.println("a) methodName.");
        System.out.println("b) methodName()");
        System.out.println("c) (methodName)");
        System.out.println("d) methodName[]");
        if (getAnswerWithTimer(sc, 'b')) {
            score++;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("5. Which method can be used to find the highest value of x and y?");
        System.out.println("a) Math.largest(x,y)");
        System.out.println("b) Math.maxNum(x,y)");
        System.out.println("c) Math.maximum(x,y)");
        System.out.println("d) Math.max(x,y)");
        if (getAnswerWithTimer(sc, 'd')) {
            score++;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Your score is " + score + " of 5");
    }
    private static boolean getAnswerWithTimer(Scanner in, char correctAnswer) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Character> future = executor.submit(() -> {
            return in.next().charAt(0);
        });
        try {
            for (int i = 10; i >= 0; i--) {
                if (future.isDone()) {
                    char ans = future.get();
                    if (ans == correctAnswer) {
                        System.out.println("Correct!");
                        executor.shutdownNow();
                        return true;
                    } else {
                        System.out.println("Wrong! Right answer: Option " + correctAnswer);
                        executor.shutdownNow();
                        return false;
                    }
                }
                System.out.print("\rTime left: " + i + " seconds, Your Answer: ");
                Thread.sleep(1000);
            }
            System.out.println("\nTime's up! Moving to next question...");
            future.cancel(true);
        } catch (InterruptedException | ExecutionException | CancellationException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
        System.out.println("Wrong! Right answer: Option " + correctAnswer);
        return false;
    }
}