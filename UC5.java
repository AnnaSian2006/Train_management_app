import java.util.LinkedHashSet;
import java.util.Set;

public class UC5 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC5 ===");

        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Initial Formation: " + trainFormation);

       
        System.out.println("\nAttempting to re-attach 'Sleeper' bogie...");
        boolean isAdded = trainFormation.add("Sleeper");

        
        if (!isAdded) {
            System.out.println("Constraint Violated: 'Sleeper' is already part of the consist. Duplicate ignored.");
        }

        
        System.out.println("\nFinal Train Formation (Order Preserved):");
        int position = 1;
        for (String bogie : trainFormation) {
            System.out.println("Position " + position + ": " + bogie);
            position++;
        }

        System.out.println("\nTotal Unique Bogies in Formation: " + trainFormation.size());
    }
}