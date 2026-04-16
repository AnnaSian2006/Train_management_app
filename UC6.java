import java.util.HashMap;
import java.util.Map;

public class UC6 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC6 ===");

        // Initializing a HashMap to map Bogie Names (Key) to their Capacity (Value)
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 1. Inserting bogie-capacity pairs using put()
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("General", 90);

        System.out.println("Bogie capacities have been mapped successfully.");

        // 2. Retrieving a specific value using a key
        String searchBogie = "Sleeper";
        System.out.println("\nCapacity for " + searchBogie + ": " + bogieCapacities.get(searchBogie) + " seats");

        // 3. Iterating through the map using entrySet() to display all details
        System.out.println("\n--- Train Consist Capacity Summary ---");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue() + " seats");
        }

        // 4. Updating a capacity (Handling a modification)
        System.out.println("\nUpdating 'AC Chair' capacity due to coach upgrade...");
        bogieCapacities.put("AC Chair", 60); // Overwrites the existing value for the key

        System.out.println("Final Bogie Count in Registry: " + bogieCapacities.size());
    }
}