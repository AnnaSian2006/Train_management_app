import java.util.LinkedList;

public class UC4 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC4 ===");

        LinkedList<String> trainConsist = new LinkedList<>();

       
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Sequence: " + trainConsist);

        
        System.out.println("\nAdding Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");
        System.out.println("After Insertion: " + trainConsist);

       
        System.out.println("\nDetaching Engine and Guard coach...");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        
        System.out.println("Final Train Consist: " + trainConsist);
        System.out.println("Bogie Count: " + trainConsist.size());
        
        System.out.println("\nFinal Sequence Check:");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println("Bogie [" + i + "]: " + trainConsist.get(i));
        }
    }
}