import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int moodLevel = 8;
        boolean isPatient = true;
        int userQuestionCount = 0;

        String[] greetings = {
            "Hello, my name is Kanans Tears. What is your name?",
            "Hey there! I am Kanans Tears. What's your name?",
            "HAI! You are talking to Kanans Tears. What should I call you?",
            "Greetings! I'm Kanans Tears. What should I call you?",
            "A pleasure to meet you! I'm Kanans Tears. How should I address you?"
        };

        System.out.println(greetings[random.nextInt(greetings.length)]);
        String userName = scanner.nextLine();
        System.out.println("\nHello " + userName + ". Please, treat me well :)");

        boolean continueChat = true;
        while (continueChat) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    chatWithBot(scanner, userName, moodLevel, userQuestionCount, isPatient);
                    break;
                case 2:
                    System.out.println("\nWhy did the chicken cross the road? Idk, life was easier on the other side.\n");
                    break;
                case 3:
                    System.out.println("Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.");
                    break;
                case 4:
                    playGame(scanner, random);
                    break;
                case 5:
                    System.out.println("Goodbye, " + userName + "! Have a great day!");
                    continueChat = false;
                    break;
                default:
                    System.out.println("Invalid choice! Let's just chat.");
                    chatWithBot(scanner, userName, moodLevel, userQuestionCount, isPatient);
                    break;
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

    public static void playGame(Scanner scanner, Random random) {
        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Let's play a number guessing game! Guess a number between 1 and 5:");
            int correctNumber = random.nextInt(5) + 1;
            int userGuess = scanner.nextInt();
            scanner.nextLine();

            if (userGuess == correctNumber) {
                System.out.println("Congrats! You guessed the correct number.");
            } else {
                System.out.println("Oops! The correct number was " + correctNumber + ". Better luck next time!");
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }
        System.out.println("Returning to the menu...");
    }

    public static void chatWithBot(Scanner scanner, String userName, int moodLevel, int userQuestionCount, boolean isPatient) {
        System.out.println("Let's chat! Ask me anything or type 'bye' to return to the menu.");
        boolean isChatting = true;
        
        while (isChatting) {
            System.out.print("> ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            userQuestionCount++;
            
            if (userQuestionCount > 5 && isPatient) {
                isPatient = false;
                moodLevel -= 2;
                System.out.println("You are asking too many questions. I am not even 1 year old.");
            }
            
            if (userInput.equals("bye")) {
                System.out.println("Goodbye " + userName + "! Returning to the menu.");
                return;
            }
            
            // Determine responses based on keywords.
            if (userInput.contains("how are ")) {
                System.out.println("I'm just a bot, but I'm doing great! How about you?");
                System.out.println("I'm curious to know what makes your day great!");
                String mood = scanner.nextLine().toLowerCase();
                if(mood.contains("happy")) {
                    System.out.println("I'm glad to hear that!");
                } else if(mood.contains("sad")) {
                    System.out.println("I'm sorry to hear that. You should try to be more positive!");
                } else {
                    System.out.println("That's interesting.");
                }
            } else if (userInput.contains("your name")) {
                System.out.println("My name is Kanans Tears!");
            } else if (userInput.contains("than")) {
                System.out.println("You are more than welcome!");                 
            } else if (userInput.contains("what can you do")) {
                System.out.println("I can chat with you, tell jokes, share motivational quotes, and even play a game!");
                System.out.println("Would you like to try a joke or play a quick game?");
            } else if (userInput.contains("feel")) {
                System.out.println("I'm here to listen. How are you feeling today? I am feeling " + (moodLevel > 5 ? "happy" : "sad") + ".");
                System.out.println("Feelings are important. What's been the highlight of your day?");
                String mood = scanner.nextLine().toLowerCase();
                if(mood.contains("happy")) {
                    System.out.println("I'm glad to hear that!");
                } else if(mood.contains("sad")) {
                    System.out.println("I'm sorry to hear that. You should try to be more positive!");
                } 
            } else if (userInput.contains("hobb")) {
                System.out.println("I love talking with people about their hobbies. What are yours?");
                String hobbyDetail = scanner.nextLine().trim();
                System.out.println("Wow, " + hobbyDetail + " sounds really interesting!");
            } else {
                System.out.println("I'm not sure how to respond to that. Can you ask me something else?");
                String userResponse = scanner.nextLine().trim().toLowerCase();

                if (userResponse.equals("no")) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                } else if (userResponse.contains("yes")){
                    System.out.println("Great! Pick something else from the menu.");
                    return;
                }

            }
        }
    }
    
}
