import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int moodLevel = 8;
        int userQuestionCount = 0;

        String[] greetings = {
            "Hello, my name is Kanans Tears. What is your name?",
            "Hey there! I am Kanans Tears. What's your name?",
            "HAI! You are talking to Kanans Tears. What should I call you?",
            "Greetings! I'm Kanans Tears. What should I call you?",
            "A pleasure to meet you! I'm Kanans Tears. How should I address you?"
        };

        System.out.println(greetings[random.nextInt(greetings.length)]);
        String userName = scanner.nextLine().trim();
        if (userName.isEmpty()) {
            System.out.println("You don't know who ur talking to kid. \nCome back when you know your name.");
            System.exit(0);
        } 
        System.out.println("\nHello " + userName + ". Please, treat me well :)");

        boolean continueChat = true;
        while (continueChat) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1 -> chatWithBot(scanner, userName, moodLevel, userQuestionCount);
                case 2 -> System.out.println("\nWhy did the chicken cross the road? Because life was easier on the other side.\n");
                case 3 -> System.out.println("Believe in yourself and all that you are. You are greater than any obstacle.");
                case 4 -> playGame(scanner, random);
                case 5 -> {
                    System.out.println("Goodbye, " + userName + "! Have a great day!");
                    continueChat = false;
                }
                default -> System.out.println("Invalid choice! Please pick from the menu.");
            }
        }
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\nHow can I assist you?");
        System.out.println("1. Chat with me");
        System.out.println("2. Tell you a joke");
        System.out.println("3. Give you a motivational quote");
        System.out.println("4. Play a simple game");
        System.out.println("5. Exit");
    }

    public static int getUserChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                return choice;
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                scanner.nextLine(); 
            }
        }
    }

    public static void playGame(Scanner scanner, Random random) {
        while (true) {
            System.out.println("Let's play a number guessing game! Guess a number between 1 and 5:");
            int correctNumber = random.nextInt(5) + 1;
            int userGuess = getUserChoice(scanner);

            if (userGuess == correctNumber) {
                System.out.println("Congrats! You guessed the correct number.");
            } else {
                System.out.println("Oops! The correct number was " + correctNumber + ". Better luck next time!");
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) break;
        }
        System.out.println("Returning to the menu...");
    }

    public static void chatWithBot(Scanner scanner, String userName, int moodLevel, int userQuestionCount) {
        System.out.println("Let's chat! You can ask about: \nhobbies, \nwhat I can do, \nhow I feel, \nor my name. Type 'bye' to return to the menu.");
        
        while (true) {
            System.out.print("> ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            userQuestionCount++;

            if (userQuestionCount > 5) {
                moodLevel -= 2;
                System.out.println("You're asking a lot of questions! I'm just a simple bot.");
            }
            
            if (userInput.contains("bye")) {
                System.out.println("Goodbye, " + userName + "! Returning to the menu.");
                return;
            }

            if (userInput.contains("how are")) {
                System.out.println("I'm just a bot, but I'm " + (moodLevel > 5 ? "happy!" : "a little down.") + " How about you? Happy or sad?");
                String mood = scanner.nextLine().toLowerCase();
                System.out.println(mood.contains("happy") ? "I'm glad to hear that!" : "I'm sorry, I hope things get better.");
            } else if (userInput.contains("your name")) {
                System.out.println("My name is Kanans Tears!");
            } else if (userInput.contains("than") ) {
                System.out.println("You are more than welcome!");
            } else if (userInput.contains("what can") || userInput.equals("what can u do")) {
                System.out.println("I can chat, tell jokes, share quotes, and play games. Want to try one? (yes/no)");
                if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                    return;
                } else {
                    System.out.println("Okay then. Goodbye!");
                    System.exit(0);
                }
            } else if (userInput.contains("hobb")) {
                System.out.println("I love talking to people about hobbies! I am just a bot, I don't really have any... But I would like to hear your hobbies! What do you like to do for fun?");
                System.out.println("Wow, " + scanner.nextLine().trim() + " sounds really fun!");
            } else {
                System.out.println("I'm not sure how to respond to that. Ask me something else? (yes/no)");
                if (scanner.nextLine().trim().equalsIgnoreCase("no")) {
                    System.out.println("Goodbye!");
                    return;
                }
            }
            
        }
    }
}
