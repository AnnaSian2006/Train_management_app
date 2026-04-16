public class UC18 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC18 ===");

        // 1. Initialize an unsorted array of Bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        // 2. Define the search keys (one existing, one missing)
        String searchKey1 = "BG309";
        String searchKey2 = "BG999";

        // 3. Perform Linear Search
        System.out.println("Searching for Bogie ID: " + searchKey1);
        performLinearSearch(bogieIds, searchKey1);

        System.out.println("\nSearching for Bogie ID: " + searchKey2);
        performLinearSearch(bogieIds, searchKey2);
    }

    /**
     * Sequential Traversal logic to find a specific Bogie ID
     */
    public static void performLinearSearch(String[] array, String key) {
        boolean found = false;
        int indexFound = -1;

        // Traverse the array one by one
        for (int i = 0; i < array.length; i++) {
            // Use .equals() for safe String comparison
            if (array[i].equals(key)) {
                found = true;
                indexFound = i;
                break; // Early Termination: Stop once found
            }
        }

        // 4. Display Results
        if (found) {
            System.out.println("[FOUND] Bogie " + key + " is located at position: " + (indexFound + 1));
        } else {
            System.out.println("[NOT FOUND] Bogie " + key + " is not in the current consist.");
        }
    }
}