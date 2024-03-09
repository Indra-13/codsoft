
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main loop for user interaction
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive matching

            // Exit the loop if the user says goodbye
            if (userInput.matches("(?i)(bye|goodbye)")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            String response = simpleChatbot(userInput);
            System.out.println("Chatbot: " + response);
        }

        // Close the scanner
        scanner.close();
    }

    private static String simpleChatbot(String userInput) {
        // Define rules and responses
        String[][] rules = {
                {"(?i)(hello|hi|hey)", "Hello! How can I help you?"},
                {"(?i)how are you", "I'm just a computer program, but thanks for asking!"},
                {"(?i)(bye|goodbye)", "Goodbye! Have a great day!"},
                {"(?i)what is your name", "I'm a simple chatbot."},
                {"(?i)your name", "I'm just a bot."},
                {"(?i)thanks|thank you", "You're welcome!"},
                {"(?i)(.*) weather (.*)", "I'm sorry, I don't know the weather. I'm just a basic chatbot."},
                {"(?i)(.*) help (.*)", "Sure, I can help. What do you need assistance with?"},
                {"(?i)(.*) joke (.*)", "Why don't scientists trust atoms? Because they make up everything!"},
                {"(?i)(.*) age (.*)", "I don't have an age. I'm just a program."},
                {"(?i)(.*) favorite color (.*)", "I don't have a favorite color. I'm a chatbot."},
                {"(?i)tell me a story", "Once upon a time, in a digital world far, far away..."},
                {"(?i)how does (.*) work", "I'm not an expert in that, but I can try to provide some information."},

                // Add more rules as needed
        };

        // Check user input against rules
        for (String[] rule : rules) {
            String pattern = rule[0];
            String response = rule[1];

            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(userInput);

            if (m.matches()) {
                return response;
            }
        }

        // If no match found, provide a default response
        return "I'm sorry, I didn't understand that. Can you please rephrase or ask another question?";
    }
}
