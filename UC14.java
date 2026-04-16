/**
 * Custom Exception for Bogie Capacity validation.
 * Extending Exception makes this a 'Checked Exception'.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * PassengerBogie class with built-in validation.
 */
class PassengerBogie {
    private String type;
    private int capacity;

    // Constructor that enforces business rules
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid Capacity: [" + capacity + 
                                               "]. Capacity must be greater than zero.");
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + " (Seats: " + capacity + ")";
    }
}

public class UC14 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC14 ===");

        // 1. Attempting to create a Valid Bogie
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("[SUCCESS] Created: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.err.println("[ERROR] Failed to create bogie: " + e.getMessage());
        }

        // 2. Attempting to create an Invalid Bogie (Zero Capacity)
        try {
            System.out.println("\nAttempting to create a bogie with 0 capacity...");
            PassengerBogie brokenBogie = new PassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("[CAUGHT] Custom Exception: " + e.getMessage());
        }

        // 3. Attempting to create an Invalid Bogie (Negative Capacity)
        try {
            System.out.println("\nAttempting to create a bogie with negative capacity...");
            PassengerBogie ghostBogie = new PassengerBogie("First Class", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("[CAUGHT] Custom Exception: " + e.getMessage());
        }

        System.out.println("\nSystem continues to run safely after handling exceptions.");
    }
}