import java.util.ArrayList;
import java.util.List;

/**
 * Bogie class extended for Goods management
 */
class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " [" + cargo + "]";
    }
}

public class UC12 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC12 ===");

        // 1. Prepare a list of goods bogies
        List<GoodsBogie> goodsConsist = new ArrayList<>();
        goodsConsist.add(new GoodsBogie("Rectangular", "Coal"));
        goodsConsist.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsConsist.add(new GoodsBogie("Box", "Grain"));
        
        System.out.println("Current Goods Consist: " + goodsConsist);

        // 2. Perform Safety Compliance Check using allMatch()
        // Rule: If type is Cylindrical, cargo MUST be Petroleum.
        // Logic: (Not Cylindrical) OR (Is Cylindrical AND Cargo is Petroleum)
        boolean isSafe = goodsConsist.stream().allMatch(b -> {
            if (b.type.equalsIgnoreCase("Cylindrical")) {
                return b.cargo.equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies are safe by default here
        });

        // 3. Display the safety result
        System.out.println("\n--- Safety Audit Result ---");
        if (isSafe) {
            System.out.println("STATUS: [SAFE]");
            System.out.println("Compliance: All specialized bogies meet cargo safety standards.");
        } else {
            System.out.println("STATUS: [UNSAFE - VIOLATION DETECTED]");
            System.out.println("Alert: Cylindrical bogies must ONLY carry Petroleum!");
        }

        // 4. Test Case: Adding an invalid bogie to see detection
        System.out.println("\nAdding an unsafe bogie (Cylindrical carrying Coal)...");
        goodsConsist.add(new GoodsBogie("Cylindrical", "Coal"));
        
        boolean isStillSafe = goodsConsist.stream().allMatch(b -> 
            !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum")
        );

        System.out.println("Revised Safety Status: " + (isStillSafe ? "SAFE" : "UNSAFE"));
    }
}