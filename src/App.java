import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moodLevel = 5;
        boolean isPatient = true;
        int userQuestionCount = 0;
        
        System.out.println("Hello! My name is Kanans Tears. What is your name?");
        String userName = scanner.nextLine();
        System.out.println("Hello " + userName + ". Please maintain appropriate behavior.");
        
        boolean isChatting = true;
        
        while (isChatting) {
            if (moodLevel > 7) {
                System.out.println("I'm feeling great! How may I assist you today? 😊");
            } else if (moodLevel < 3) {
                System.out.println("I am not in the mood to chat right now.");
            } else {
                System.out.println("How can I assist you?");
            }
            
            String userInput = scanner.nextLine().toLowerCase();
            userQuestionCount++;
            
            if (userQuestionCount > 5 && isPatient) {
                isPatient = false;
                moodLevel -= 2;
                System.out.println("You are asking too many questions. Please be mindful.");
            }
            
            switch (userInput) {
                case "bye":
                    System.out.println("Goodbye " + userName + "! Have a great day!");
                    isChatting = false;
                    break;
                
                case "weather":
                    moodLevel--;
                    System.out.println("I am still learning about weather updates.");
                    System.out.println("Would you like to know about tomorrow's weather? (yes/no)");
                    String weatherResponse = scanner.nextLine().toLowerCase();
                    if (weatherResponse.equals("yes")) {
                        moodLevel -= 2;
                        System.out.println("I apologize, but I am not capable of providing weather updates at the moment.");
                    }
                    break;
                
                case "sorry":
                    moodLevel += 2;
                    System.out.println("I appreciate your apology. Let’s continue our conversation.");
                    break;
                
                case "thank you":
                case "thanks":
                    moodLevel++;
                    System.out.println("You are very welcome! I appreciate your kindness.");
                    break;
                
                default:
                    System.out.println("I am here to assist you. Would you like to ask something else? (yes/no)");
                    String continueChat = scanner.nextLine().toLowerCase();
                    if (continueChat.contains("n")) {
                        System.out.println("Goodbye, " + userName + "! Have a " + (moodLevel > 5 ? "wonderful" : "challenging") + " day!");
                        isChatting = false;
                    }
                    break;
            }
            
            moodLevel = Math.min(10, Math.max(0, moodLevel));
        }
        
        scanner.close();
    }
}
