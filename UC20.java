import java.util.Arrays;

public class UC20 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC20 ===");

        // 1. Case A: Attempting search on an EMPTY consist
        String[] emptyConsist = {};
        try {
            System.out.println("Scenario 1: Searching an empty train consist...");
            performSafeSearch(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("[FAIL-FAST] Caught expected exception: " + e.getMessage());
        }

        System.out.println("-----------------------------------------");

        // 2. Case B: Attempting search on a VALID consist
        String[] validConsist = {"BG101", "BG205", "BG309"};
        try {
            System.out.println("Scenario 2: Searching a populated train consist...");
            performSafeSearch(validConsist, "BG205");
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] This should not happen: " + e.getMessage());
        }
    }

    /**
     * Performs a search with a state-validation guard clause.
     * @throws IllegalStateException if the array is empty.
     */
    public static void performSafeSearch(String[] bogies, String searchKey) {
        // 3. State Validation Guard Clause
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Search Denied: The train has no bogies attached yet.");
        }

        // 4. Proceed with Search logic (Linear Search used for example)
        boolean found = false;
        for (String bogie : bogies) {
            if (bogie.equals(searchKey)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("[SUCCESS] Bogie " + searchKey + " found in the consist.");
        } else {
            System.out.println("[NOT FOUND] Bogie " + searchKey + " is not attached to this train.");
        }
    }
}