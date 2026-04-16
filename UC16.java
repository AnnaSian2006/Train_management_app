public class UC16 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC16 ===");

        // 1. Initialize an array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Initial Capacities: ");
        printArray(capacities);

        // 2. Implementation of Bubble Sort Algorithm
        // The outer loop ensures we make enough passes to move every element
        for (int i = 0; i < capacities.length - 1; i++) {
            // The inner loop compares adjacent elements
            // After each outer loop pass, the largest remaining element "bubbles" to the end
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // 3. Swapping Logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // 4. Display the sorted result
        System.out.print("Sorted Capacities (Ascending): ");
        printArray(capacities);

        System.out.println("\nSorting complete. Dataset is now optimized for capacity reporting.");
    }

    /**
     * Helper method to display array content
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}