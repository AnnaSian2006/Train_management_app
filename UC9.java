import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie{Capacity=" + capacity + "}";
    }
}

public class UC9 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC9 ===");

        // 1. Initialize a list with multiple bogies of the same and different types
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("General", 90));

        System.out.println("Total bogies in consist: " + trainConsist.size());

        // 2. Grouping bogies by their name using Collectors.groupingBy
        // This transforms List<Bogie> into Map<String, List<Bogie>>
        Map<String, List<Bogie>> groupedBogies = trainConsist.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // 3. Display the structured reporting
        System.out.println("\n--- Categorized Train Manifest ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: [" + type + "] -> Count: " + list.size());
            System.out.println("   Details: " + list);
        });

        // 4. Validation Check
        System.out.println("\nVerification: Grouping created " + groupedBogies.size() + " distinct categories.");
    }
}