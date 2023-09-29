package AlgoritmProgram;

import java.util.regex.*;

public class MessageCustomization {
    public static void main(String[] args) {
        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. Your contact number is 91-xxxxxxxxxx. Please, let us know in case of any clarification. Thank you BridgeLabz 01/01/2016.";
        
        // Define the values to replace placeholders
        String firstName = "John";
        String fullName = "John Doe";
        String contactNumber = "91-1234567890";

        // Replace <<name>> with the first name
        message = message.replaceAll("<<name>>", firstName);

        // Replace <<full name>> with the full name
        message = message.replaceAll("<<full name>>", fullName);

        // Replace mobile number (91-xxxxxxxxxx) with your contact number
        message = message.replaceAll("91-\\d{10}", contactNumber);

        // Print the customized message
        System.out.println(message);
    }
}
