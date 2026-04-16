import java.util.Arrays;

public class UC17 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC17 ===");

        // 1. Initialize an array of bogie type names
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Initial Bogie Names: " + Arrays.toString(bogieTypes));

        // 2. Using Java's built-in optimized sorting utility
        // This sorts the array in-place using Natural Ordering (Alphabetical)
        Arrays.sort(bogieTypes);

        // 3. Display the sorted result using Arrays.toString() for clean output
        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieTypes));

        // 4. Demonstrating stability with duplicates
        String[] duplicatesList = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(duplicatesList);
        System.out.println("\nSorted List with Duplicates: " + Arrays.toString(duplicatesList));

        System.out.println("\nSystem Update: Standard library utilities applied for optimal performance.");
    }
}