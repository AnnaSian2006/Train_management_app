import java.util.Arrays;

public class UC19 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC19 ===");

        // 1. Initial bogie IDs (Unsorted to demonstrate handling)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        
        // 2. Precondition: Data must be sorted for Binary Search
        Arrays.sort(bogieIds);
        System.out.println("Sorted Bogie IDs: " + Arrays.toString(bogieIds));

        // 3. Define search keys
        String searchKey1 = "BG309";
        String searchKey2 = "BG999";

        // 4. Execute Search
        System.out.println("\nSearching for " + searchKey1 + "...");
        performBinarySearch(bogieIds, searchKey1);

        System.out.println("\nSearching for " + searchKey2 + "...");
        performBinarySearch(bogieIds, searchKey2);
    }

    /**
     * Binary Search implementation using Low, High, and Mid pointers
     */
    public static void performBinarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid potential integer overflow
            
            // compareTo returns 0 if strings are equal
            int comparison = key.compareTo(array[mid]);

            if (comparison == 0) {
                System.out.println("[FOUND] Bogie " + key + " located at index: " + mid);
                found = true;
                break;
            } 
            else if (comparison > 0) {
                // Key is alphabetically after mid, ignore left half
                low = mid + 1;
            } 
            else {
                // Key is alphabetically before mid, ignore right half
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("[NOT FOUND] Bogie " + key + " is not in the system.");
        }
    }
}