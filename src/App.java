import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            Util.greetUser(random);
            String userName = Util.getUserName(scanner);
            Chatt chat = new Chatt(userName, 8, 0); // this is the class that the professor asked for i can do it for
                                                                                // other classes too
                                                                                // but too much work so i hope yall understand 🙏
            boolean continueChat = true;
            while (continueChat) {
                Util.displayMenu();
                int choice = Util.getUserChoice(scanner);
                try {
                    switch (choice) {
                        case 1 -> chat.chatWithBot(scanner);
                        case 2 -> Util.tellJoke(random);
                        case 3 -> Util.giveMotivation(random);
                        case 4 -> NumberGame.playGame(scanner, random);
                        case 5 -> Trivia.triviaGame(scanner, random);
                        case 6 -> {
                            System.out.println("Goodbye, " + userName + "! Have a great day!");
                            continueChat = false;
                        }
                        default -> System.out.println("Bruh pick something from the menu");
                    }
                } catch (KananException e) {
                    System.out.println("Error my guy " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Idk what happened" + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Goodbye my guy");
        }
    }
}
