// Superclass Subscription
abstract class Subscription {
    String subscriberName;
    String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public abstract double calculateMonthlyCharge();
}

// Subclass BasicPlan
class BasicPlan extends Subscription {
    public BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    public double calculateMonthlyCharge() {
        return 199;
    }
}

// Subclass PremiumPlan
class PremiumPlan extends Subscription {
    public PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    public double calculateMonthlyCharge() {
        return 499;
    }
}

// Subclass FamilyPlan
class FamilyPlan extends Subscription {
    public FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    public double calculateMonthlyCharge() {
        return 699;
    }
}

// Main class
public class StreamingPlatformSubscriptionAnalyzer {
    public static void searchBySubscriptionId(Subscription[] subscriptions, String subscriptionId) {
        for (int i = 0; i < subscriptions.length; i++) {
            if (subscriptions[i].subscriptionId.equalsIgnoreCase(subscriptionId)) {
                System.out.println("Subscriber found: " + subscriptions[i].subscriberName);
                System.out.println("Monthly charge: Rs." + subscriptions[i].calculateMonthlyCharge());
                return;
            }
        }
        System.out.println("Subscription not found");
    }

    public static void displaySubscribersByLetter(Subscription[] subscriptions, char letter) {
        System.out.println("Subscribers starting with " + letter + ":");
        for (int i = 0; i < subscriptions.length; i++) {
            if (Character.toLowerCase(subscriptions[i].subscriberName.charAt(0)) == Character.toLowerCase(letter)) {
                System.out.println(subscriptions[i].subscriberName + " (" + subscriptions[i].subscriptionId + ")");
            }
        }
    }

    public static void calculateTotalRevenue(Subscription[] subscriptions) {
        double totalRevenue = 0;
        for (int i = 0; i < subscriptions.length; i++) {
            totalRevenue = totalRevenue + subscriptions[i].calculateMonthlyCharge();
        }
        System.out.println("Total monthly revenue: Rs." + totalRevenue);
    }

    public static void displayMostExpensiveSubscription(Subscription[] subscriptions) {
        Subscription expensiveSubscription = subscriptions[0];
        for (int i = 1; i < subscriptions.length; i++) {
            if (subscriptions[i].calculateMonthlyCharge() > expensiveSubscription.calculateMonthlyCharge()) {
                expensiveSubscription = subscriptions[i];
            }
        }
        System.out.println("Most expensive subscription: " + expensiveSubscription.subscriberName + " - Rs."
                + expensiveSubscription.calculateMonthlyCharge());
    }

    public static void main(String[] args) {
        Subscription[] subscriptions = {
                new BasicPlan("Asha", "B101"),
                new PremiumPlan("Ravi", "P202"),
                new FamilyPlan("Meena", "F303"),
                new PremiumPlan("Kiran", "P404"),
                new BasicPlan("Anil", "B505")
        };

        for (int i = 0; i < subscriptions.length; i++) {
            System.out.println(subscriptions[i].subscriberName + " monthly charge: Rs."
                    + subscriptions[i].calculateMonthlyCharge());
        }

        searchBySubscriptionId(subscriptions, "P202");
        displaySubscribersByLetter(subscriptions, 'A');
        calculateTotalRevenue(subscriptions);
        displayMostExpensiveSubscription(subscriptions);
    }
}
