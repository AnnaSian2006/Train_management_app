import java.util.HashSet;
import java.util.Set;

public class UC3 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC3 ===");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        
        System.out.println("Adding duplicate ID: BG101...");
        boolean isAdded = bogieIds.add("BG101");

        System.out.println("Was duplicate BG101 added? " + isAdded);

        System.out.println("\nUnique Bogie IDs in System:");
        for (String id : bogieIds) {
            System.out.println("Bogie ID: " + id);
        }

        System.out.println("\nTotal Unique Bogies: " + bogieIds.size());
    }
}