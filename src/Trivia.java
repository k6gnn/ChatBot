import java.util.*;



public class Trivia {
    public static void triviaGame(Scanner scanner, Random random) {
        System.out.println("Welcome to Trivia Challenge! Answer the following question:");
        String question = "What is the capital of France?";
        String answer = "paris";
        System.out.println(question);
        String userAnswer = scanner.nextLine().trim().toLowerCase();
        if (userAnswer.equals(answer)) {
            System.out.println("Correct! You know your stuff.");
        } else {
            System.out.println("Wrong! The correct answer is Paris.");
        }
    }

}
