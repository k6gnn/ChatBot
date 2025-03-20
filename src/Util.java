import java.util.*;


public class Util {
    public static void greetUser(Random random) {
        String[] greetings = {
            "Hello, my name is Kanans Tears. What is your name?",
            "Hey there! I am Kanans Tears. What's your name?",
            "HAI! You are talking to Kanans Tears. What should I call you?",
            "Greetings! I'm Kanans Tears. What should I call you?",
            "A pleasure to meet you! I'm Kanans Tears. How should I address you?"
        };
        System.out.println(greetings[random.nextInt(greetings.length)]);
    }


    public static String getUserName(Scanner scanner) {
        String userName = scanner.nextLine().trim();
        if (userName.isEmpty()) {
            System.out.println("You don't know who you're talking to, kid.\nCome back when you know your name.");
            System.exit(0);
        }
        System.out.println("\nHello " + userName + ". Please, treat me well :)");
        return userName;
    }


    public static void displayMenu() {
        System.out.println("\nHow can I assist you?");
        System.out.println("1. Chat with me");
        System.out.println("2. Tell you a joke");
        System.out.println("3. Give you a motivational quote");
        System.out.println("4. Play a simple game");
        System.out.println("5. Trivia Challenge");
        System.out.println("6. Exit");
    }


    public static int getUserChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                return choice;
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                scanner.nextLine(); 
            }
        }
    }


    public static void tellJoke(Random random) {
        String[] jokes = {
            "Why don't skeletons fight each other? Because they don't have the guts!",
            "Parallel lines have so much in common. It's a shame they'll never meet.",
            "Why did the scarecrow win an award? Because he was outstanding in his field!"
        };
        System.out.println("\n" + jokes[random.nextInt(jokes.length)] + "\n");
    }


    public static void giveMotivation(Random random) {
        String[] quotes = {
            "Believe in yourself and all that you are. You are greater than any obstacle.",
            "Hardships often prepare ordinary people for an extraordinary destiny.",
            "You don't have to be great to start, but you have to start to be great."
        };
        System.out.println("\n" + quotes[random.nextInt(quotes.length)]);
    }


}
