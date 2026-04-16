import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UC11 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC11 ===");

        // 1. Define Regex Patterns
        // TRN- followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}"; 
        // PET- followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}"; 

        // 2. Compile Patterns for efficiency
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);

        // 3. Test Cases (Valid and Invalid)
        String[] testTrainIds = {"TRN-1234", "TRN-99", "TRN-ABCD", "1234-TRN"};
        String[] testCargoCodes = {"PET-AB", "PET-xy", "PET-12", "PET-ABC"};

        System.out.println("\n--- Validating Train IDs ---");
        for (String id : testTrainIds) {
            validateInput(trainIdPattern, id, "Train ID");
        }

        System.out.println("\n--- Validating Cargo Codes ---");
        for (String code : testCargoCodes) {
            validateInput(cargoCodePattern, code, "Cargo Code");
        }
    }

    /**
     * Utility method to validate input using Matcher and matches()
     */
    private static void validateInput(Pattern pattern, String input, String type) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("[VALID]   " + type + ": " + input);
        } else {
            System.out.println("[INVALID] " + type + ": " + input + " (Format Mismatch)");
        }
    }
}