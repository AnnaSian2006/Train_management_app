import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Defining a simple Bogie class to hold properties
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

public class UC7 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC7 ===");

        // 1. Create a List of Bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Unsorted Consist: " + passengerBogies);

        // 2. Applying Comparator to sort by capacity (Ascending)
        // We use a Lambda expression for concise comparison logic
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nBogies Sorted by Capacity (Low to High):");
        for (Bogie b : passengerBogies) {
            System.out.println(">> " + b);
        }

        // 3. Sorting in Descending order for high-capacity planning
        passengerBogies.sort((b1, b2) -> b2.capacity - b1.capacity);

        System.out.println("\nBogies Sorted by Capacity (High to Low):");
        passengerBogies.forEach(System.out::println);
    }
}