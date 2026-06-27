// LuggageScanner interface 
interface LuggageScanner {
    boolean scanLuggage(int bagCount);

    default void displaySecurityGuidelines() {
        System.out.println("Security guideline: Keep luggage within allowed limit");
    }
}

// PassportVerifier interface
interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Security guideline: Carry a valid passport");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z]{2}[0-9]{7}");
    }
}

// AirportSecuritySystem class implementing both interfaces
public class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    public boolean scanLuggage(int bagCount) {
        return bagCount <= 2;
    }

    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
        System.out.println("Airport security guideline: Follow all boarding checks");
    }

    public static void main(String[] args) {
        AirportSecuritySystem system = new AirportSecuritySystem();
        String[] passengerNames = {"Rahul", "Sonia", "Amit", "Neha"};
        String[] passportNumbers = {"AB1234567", "XY7654321", "A12345678", "MN2345678"};
        int[] bagCounts = {1, 3, 2, 0};

        system.displaySecurityGuidelines();
        System.out.println();

        for (int i = 0; i < passengerNames.length; i++) {
            boolean passportValid = system.verifyPassport(passportNumbers[i]);
            boolean luggageValid = system.scanLuggage(bagCounts[i]);
            boolean canBoard = passportValid && luggageValid;

            System.out.println("Passenger: " + passengerNames[i]);
            System.out.println("Passport: " + passportNumbers[i] + " -> " + (passportValid ? "Valid" : "Invalid"));
            System.out.println("Bags: " + bagCounts[i] + " -> " + (luggageValid ? "Allowed" : "Too many bags"));
            System.out.println("Boarding status: " + (canBoard ? "Allowed" : "Not Allowed"));
            System.out.println();
        }
    }
}
