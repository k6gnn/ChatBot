import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pmolvl = 5;
        boolean ChillBot = true;
        int questionCount = 0;
        
        System.out.println("Hello! My name is Kanans Tears. What is yours?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ". Dont pmo.");
        
        boolean chatting = true;
        while (chatting) {
            if (pmolvl > 7) {
                System.out.println("I'm super happy! What can I do for you? 😊");
            } else if (pmolvl < 3) {
                System.out.println("leave me alone bruh");
            } else {
                System.out.println("What can I do for u?");
            }
            
            String input = scanner.nextLine();
            questionCount++;
            
            if (questionCount > 5 && ChillBot) {
                ChillBot = false;
                pmolvl -= 2;
                System.out.println("gtfo curious george");
            }
            
            if (input.toLowerCase().equals("bye")) {
                System.out.println("Goodbye " + name + "! Have a great day!");
                chatting = false;
            } else {
                if (input.toLowerCase().contains("weather")) {
                    pmolvl--; // dont ask ts guy about weather he doesnt know how to use APIs bruh
                    System.out.println("I am still learning");
                    System.out.println("Would you like to know about tomorrow's weather? (yes/no)");
                    String weatherResponse = scanner.nextLine();
                    if (weatherResponse.toLowerCase().equals("yes")) {
                        pmolvl -= 2;
                        System.out.println("DAWG I SAID I'M STILL LEARNING ");
                    }
                } else if (input.toLowerCase().contains("sorry")) {
                    pmolvl += 2; 
                    System.out.println("I forgive u but dont let it happen again dawg");
                } else if (input.toLowerCase().contains("thank")) {
                    pmolvl++; 
                    System.out.println("Bro js said thanks to a bot. Appreciate it gng");
                } else {
                    System.out.println("Respect the newbies bro. Would you like to ask me something else? (yes/no)");
                    String continue_chat = scanner.nextLine();
                    if (continue_chat.toLowerCase().contains("n")) {
                        System.out.println("bye " + name + "! Have a " + 
                            (pmolvl > 5 ? "wonderful" : "shitty") + " day!");
                        chatting = false;
                    }
                }
            }
            
            pmolvl = Math.min(10, Math.max(0, pmolvl)); //dont make my bot suicidal yall
        }
        scanner.close();
    }
}
