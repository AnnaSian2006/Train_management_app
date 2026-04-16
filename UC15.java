/**
 * Custom Runtime Exception for Operational Safety.
 * Extending RuntimeException makes this an 'Unchecked Exception'.
 */
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape;
    private String cargo = "Empty";

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    /**
     * Attempts to assign cargo. 
     * Throws CargoSafetyException if the combination is hazardous.
     */
    public void assignCargo(String newCargo) {
        System.out.println("Processing assignment: [" + newCargo + "] to [" + shape + "] bogie...");
        
        // Safety Rule: Petroleum requires Cylindrical shape
        if (newCargo.equalsIgnoreCase("Petroleum") && !shape.equalsIgnoreCase("Cylindrical")) {
            throw new CargoSafetyException("SAFETY ALERT: Petroleum cannot be loaded into a " + shape + " bogie!");
        }
        
        this.cargo = newCargo;
        System.out.println("Assignment Successful: Cargo is now " + this.cargo);
    }

    @Override
    public String toString() {
        return shape + " Bogie (Cargo: " + cargo + ")";
    }
}

public class UC15 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC15 ===");

        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");

        // Use Case A: Safe Assignment
        processAssignment(cylindricalBogie, "Petroleum");

        System.out.println();

        // Use Case B: Unsafe Assignment
        processAssignment(rectangularBogie, "Petroleum");

        System.out.println("\nFinal Train Status: Operations completed safely.");
    }

    /**
     * Demonstrates structured exception handling using try-catch-finally
     */
    private static void processAssignment(GoodsBogie bogie, String cargo) {
        try {
            bogie.assignCargo(cargo);
        } catch (CargoSafetyException e) {
            System.out.println("[HANDLED ERROR] " + e.getMessage());
        } finally {
            // This block executes no matter what happened above
            System.out.println("[LOG] Safety check completed for " + bogie);
        }
    }
}