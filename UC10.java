import java.util.ArrayList;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class UC10 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC10 ===");

        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("General", 90));

        System.out.println("Train Consist: " + trainConsist);

        int totalSeats = trainConsist.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\n--- Capacity Analytics ---");
        System.out.println("Total Bogies: " + trainConsist.size());
        System.out.println("Total Seating Capacity: " + totalSeats + " seats");

        System.out.println("Operational Status: " + (totalSeats > 300 ? "High Capacity Train" : "Standard Train"));
    }
}