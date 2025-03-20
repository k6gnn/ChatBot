import java.util.*;


public class NumberGame {
    public static void playGame(Scanner scanner, Random random) {
        while (true) {
            System.out.println("Let's play a number guessing game! Guess a number between 1 and 5:");
            int correctNumber = random.nextInt(5) + 1;
            int userGuess = Util.getUserChoice(scanner);

            if (userGuess == correctNumber) {
                System.out.println("Congrats! You guessed the correct number.");
            } else {
                System.out.println("Oops! The correct number was " + correctNumber + ". Better luck next time!");
            }

            System.out.println("Do you want to play again? (yes/no)");
            if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) break;
        }
        System.out.println("Returning to the menu...");
    }

}
