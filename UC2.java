import java.util.ArrayList;
import java.util.List;

public class UC2 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC2 ===");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Current Consist: " + passengerBogies);
        System.out.println("Total Bogies: " + passengerBogies.size());

        System.out.println("\nRemoving AC Chair...");
        passengerBogies.remove("AC Chair");

        System.out.println("Does Sleeper exist? " + passengerBogies.contains("Sleeper"));

        System.out.println("\nFinal Train Consist: " + passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());
    }
} 
    
