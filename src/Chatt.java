import java.util.*;


public class Chatt {
    private int moodLevel;
    private int userQuestionCount;
    private final String userName;


    public Chatt(String userName, int moodLevel, int userQuestionCount) {
        this.userName = userName;
        this.moodLevel = 8;
        this.userQuestionCount = 0;
    }


    private String getUserInput(Scanner scanner) throws KananException { //yall I added this for another kind of error handling
        if (!scanner.hasNextLine()) {
            throw new KananException("Scanner input is unavailable!");
        }
        
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.isEmpty()) {
            throw new KananException("Input cannot be empty!");
        }
        return input;
    }




    public void chatWithBot(Scanner scanner) throws KananException {
        System.out.println("Let's chat! Type 'bye' to return to the menu. \n Ask me the meaning or life or food or weather or my mood or idk bro u will see what i can do ");
        
        while (true) {
            System.out.print("> ");
            String userInput = getUserInput(scanner);
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
                System.out.println("I'm a bot. I don't have hobbies. Whatare your hobbies?");
                String userHobby = scanner.nextLine().toLowerCase();
                System.out.println(userHobby + " seems interesting! You are such an interesting person " + userName + "!");
            } else if (userInput.contains("ur name")) {
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
