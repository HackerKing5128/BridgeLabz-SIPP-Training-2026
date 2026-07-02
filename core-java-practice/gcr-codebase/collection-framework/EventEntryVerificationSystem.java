import java.util.HashSet;

// EventEntryVerificationSystem class to manage event registrations
public class EventEntryVerificationSystem {
    private HashSet<String> participants;

    public EventEntryVerificationSystem() {
        participants = new HashSet<String>();
    }

    public void registerParticipant(String emailId) {
        if (participants.add(emailId)) {
            System.out.println("Registered: " + emailId);
        } else {
            System.out.println("Duplicate registration rejected: " + emailId);
        }
    }

    public void displayParticipants() {
        System.out.println("Unique participants:");
        for (String email : participants) {
            System.out.println(email);
        }
        System.out.println("Total attendees: " + participants.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();

        event.registerParticipant("alice@mail.com");
        event.registerParticipant("bob@mail.com");
        event.registerParticipant("alice@mail.com");
        event.registerParticipant("charlie@mail.com");

        event.displayParticipants();
    }
}
