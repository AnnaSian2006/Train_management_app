import java.util.ArrayList;
import java.util.List;
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
        return name + " (Capacity: " + capacity + ")";
    }
}

public class UC8 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC8 ===");

        // 1. Initialize the list of bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("General", 90));
        passengerBogies.add(new Bogie("Sleeper-B2", 72));

        System.out.println("Original Consist: " + passengerBogies);

        // 2. Filter bogies with capacity > 60 using Stream API
        int threshold = 60;
        System.out.println("\nFiltering bogies with capacity greater than " + threshold + "...");

        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());

        // 3. Display the filtered results
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies found matching the criteria.");
        } else {
            System.out.println("High Capacity Bogies found: " + highCapacityBogies.size());
            highCapacityBogies.forEach(b -> System.out.println(">> " + b));
        }

        // 4. Verify Original Collection Integrity
        System.out.println("\nVerification: Original list size remains " + passengerBogies.size());
    }
}