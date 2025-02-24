import java.util.HashMap;
import java.util.Map;
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
            "Hello my name is Kanans Tears. What is your name?",
            "Hey there! I am Kanans Tears. What's your name?",
            "HAI! You are talking to Kanans Tears. What should I call you?",
            "Greetings! I'm Kanans Tears. What should I call you?",
            "A pleasure to meet you! I'm Kanans Tears. How should I address you?"
        };

        System.out.println(greetings[random.nextInt(greetings.length)]);
        String userName = scanner.nextLine();
        System.out.println("Hello " + userName + ". Please, treat me well :)");

        boolean continueChat = true;
        while (continueChat) {
            displayMenu();
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Awesome! Let's chat. Ask me about hobbies, feelings, or anything on your mind.");
                    chatWithBot(scanner, userName, moodLevel, userQuestionCount, isPatient);
                    break;
                case 2:
                    System.out.println("Why don't skeletons fight each other? Because they don't have the guts!");
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
        System.out.println("How can I assist you?");
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
            scanner.nextLine(); // Consume the newline character

            if (userGuess == correctNumber) {
                System.out.println("Congrats! You guessed the correct number.");
            } else {
                System.out.println("Oops! The correct number was " + correctNumber + ". Better luck next time!");
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }
        System.out.println("Do you want to chat now? (yes/no)");
        String chatResponse = scanner.nextLine().trim().toLowerCase();
        if (chatResponse.equals("yes")) {
            System.out.println("Great! Let's chat. Ask me about hobbies, feelings, or anything on your mind.");
            chatWithBot(scanner, "User", 8, 0, true);
        } else {
            displayMenu();
        }
    }

    public static void chatWithBot(Scanner scanner, String userName, int moodLevel, int userQuestionCount, boolean isPatient) {
        Map<String, String> responses = new HashMap<>();
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("your name", "My name is Kanans Tears! What's yours?");
        responses.put("what can you do", "I can chat with you, tell jokes, share motivational quotes, and even play a game!");
        responses.put("bye", "Goodbye " + userName + "! Have a wonderful day!");
        responses.put("hobbies", "I love talking with people like you! What are your hobbies?");
        responses.put("feel", "I'm here to listen. Tell me, how are you feeling today? Happy or sad? I am feeling " + (moodLevel > 5 ? "happy" : "sad") + ".");
        
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

            boolean foundResponse = false;
            for (Map.Entry<String, String> entry : responses.entrySet()) {
                if (userInput.contains(entry.getKey())) {
                    System.out.println(entry.getValue());
                    foundResponse = true;
                    if (entry.getKey().equals("hobbies")) {
                        System.out.println("That is great to hear! Want to continue the conversation in the following aspects?");
                        displayMenu();
                        return;
                    }
                    if (userInput.equals("bye")) {
                        isChatting = false;
                    }
                    break;
                }
            }
            if (!foundResponse) {
                System.out.println("I'm not sure how to respond to that. Would you like to continue the conversation in one of the following aspects?");
                displayMenu();
                return;
            }
        }
    }
}
