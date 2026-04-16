import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }
}

public class UC13 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC13 ===");

        // 1. Prepare a large dataset to make the time difference measurable
        List<Bogie> largeTrainConsist = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            largeTrainConsist.add(new Bogie("Sleeper", i % 100));
        }

        System.out.println("Processing " + largeTrainConsist.size() + " bogies...");

        // 2. Measure Performance: Traditional Loop
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : largeTrainConsist) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 3. Measure Performance: Java Stream
        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = largeTrainConsist.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // 4. Display Benchmarking Results
        System.out.println("\n--- Performance Comparison ---");
        System.out.println("Loop Execution Time   : " + durationLoop + " ns");
        System.out.println("Stream Execution Time : " + durationStream + " ns");
        
        // 5. Result Consistency Check
        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("\nVerification: Both methods produced identical results (" + loopFiltered.size() + " items).");
        }

        // Analysis
        double factor = (double) durationStream / durationLoop;
        System.out.printf("Stream was %.2fx slower than Loop in this run.%n", factor);
    }
}