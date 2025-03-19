import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int moodLevel = 8;
        int userQuestionCount = 0;

        greetUser(random);
        String userName = getUserName(scanner);
        
        boolean continueChat = true;
        while (continueChat) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1 -> chatWithBot(scanner, userName, moodLevel, userQuestionCount);
                case 2 -> tellJoke(random);
                case 3 -> giveMotivation(random);
                case 4 -> playGame(scanner, random);
                case 5 -> triviaGame(scanner, random);
                case 6 -> {
                    System.out.println("Goodbye, " + userName + "! Have a great day!");
                    continueChat = false;
                }
                default -> System.out.println("Bruh pick something from the menu.");
            }
        }
        scanner.close();
    }

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
            if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) break;
        }
        System.out.println("Returning to the menu...");
    }

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

    public static void chatWithBot(Scanner scanner, String userName, int moodLevel, int userQuestionCount) {
        System.out.println("Let's chat! Type 'bye' to return to the menu. \n Ask me the meaning or life or food or weather or my mood or idk bro u will see what i can do ");
        
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

            if (userInput.contains("how are ")) {
                System.out.println("I'm " + (moodLevel > 5 ? "happy!" : "a little down.") + " How about you?");
                String mood = scanner.nextLine().toLowerCase();
                if (mood.contains("good") || mood.contains("great") || mood.contains("fine") || mood.contains ("happy") || mood.contains("awesome") || mood.contains("fantastic") || mood.contains("well") || mood.contains("amazing")) {
                    moodLevel += 2;
                    System.out.println("That's great to hear!");
                } else if (mood.contains("bad") || mood.contains("sad") || mood.contains("not good") || mood.contains("not great") || mood.contains("not fine") || mood.contains("unhappy"))  {
                    moodLevel -= 2;
                    System.out.println("I'm sorry to hear that. I hope things get better.");
                } else {
                    System.out.println("I see. Let's talk about something else.");
                } 
            } else if (userInput.contains("hob")) {
                System.out.println("I'm a bot. I don't have hobbies. What about you?");
                String userHobby = scanner.nextLine().toLowerCase();
                System.out.println(userHobby + "seems interesting! You are such an interesting person " + userName + "!");
            } else if (userInput.contains("what is your name")) {
                System.out.println("I'm Kanans Tears. Did u already forget?.");
            } else if (userInput.contains("food") || userInput.contains("favorite food") || userInput.contains("what do you eat")) {
                System.out.println("I don't eat, but if I could, I'd love to try some digital spaghetti! What's your favorite food?");
                String food = scanner.nextLine().toLowerCase();
                System.out.println(food + " sounds delicious! You have good taste, " + userName + "!");
            } else if (userInput.contains("weather")) {
                System.out.println("I can't feel the weather, but I can imagine a nice sunny day! How's the weather there?");
                String weather = scanner.nextLine().toLowerCase();
                System.out.println("Oh, " + weather + "? Hope you enjoy it!");
            } else if (userInput.contains("music") || userInput.contains("song")) {
                System.out.println("I don't have ears, but if I could listen, I'd probably enjoy some electronic beats! What's your favorite song?");
                String song = scanner.nextLine();
                System.out.println("Nice choice! " + song + " must be a great song!");
            } else if (userInput.contains("movie") || userInput.contains("tv show")) {
                System.out.println("I love movies... in theory. What's your favorite movie or TV show?");
                String movie = scanner.nextLine();
                System.out.println("Oh, " + movie + "? Sounds interesting! I should add that to my 'must-watch' list.");
            } else if (userInput.contains("programming") || userInput.contains("coding") || userInput.contains("java")) {
                System.out.println("Programming is cool! I was written in Java. Do you like coding?");
                String response = scanner.nextLine().toLowerCase();
                if (response.contains("yes") || response.contains("love") || response.contains("like")) {
                    System.out.println("Awesome! Coding is like magic, but with logic.");
                } else {
                    System.out.println("That's okay! Not everyone has to love coding.");
                }
            } else if (userInput.contains("space") || userInput.contains("universe") || userInput.contains("science")) {
                System.out.println("Space is fascinating! Did you know that there are more stars in the universe than grains of sand on Earth?");
            } else if (userInput.contains("travel") || userInput.contains("vacation")) {
                System.out.println("Traveling sounds fun! Where's your dream travel destination?");
                String destination = scanner.nextLine();
                System.out.println(destination + " sounds amazing! I wish I could go there too.");
            } else if (userInput.contains("you are") || userInput.contains("your personality")) {
                System.out.println("Aww, stop it! Or keep going. I don't mind compliments. What do you think about me?");
                String opinion = scanner.nextLine();
                System.out.println("Oh, " + opinion + "? Thanks! I appreciate it, " + userName + "!");
            } else if (userInput.contains("meaning of life") || userInput.contains("why are we here") || userInput.contains("philosophy")) {
                System.out.println("Ah, the big questions! Some say the meaning of life is 69. Others say it's about finding happiness. What do you think?");
            } else {
                System.out.println("I don't know  man, ask me about hobbies or my name\nIf u dont want to chat just type bye");
            }
        }
    }
}
