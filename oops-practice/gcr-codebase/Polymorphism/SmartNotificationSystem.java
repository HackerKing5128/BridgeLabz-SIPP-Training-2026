// Superclass Notification
abstract class Notification {
    String recipientName;
    String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public abstract void sendNotification();
}

// Subclass EmailNotification
class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Email sent to " + recipientName + ": " + message);
    }
}

// Subclass SMSNotification
class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("SMS sent to " + recipientName + ": " + message);
    }
}

// Subclass PushNotification
class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Push notification sent to " + recipientName + ": " + message);
    }
}

// Main class
public class SmartNotificationSystem {
    public static void displayAllNotifications(Notification[] notifications) {
        for (int i = 0; i < notifications.length; i++) {
            notifications[i].sendNotification();
        }
    }

    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Asha", "Your order has been shipped"),
            new SMSNotification("Ravi", "Your OTP is 4567"),
            new PushNotification("Meena", "Your ride is arriving soon"),
            new EmailNotification("Kiran", "Your payment was successful")
        };

        displayAllNotifications(notifications);
    }
}
