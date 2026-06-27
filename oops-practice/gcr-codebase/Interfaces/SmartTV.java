// StreamingService interface
interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription: Movies available");
    }
}

// GamingService interface
interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription: Games available");
    }
}

// SmartTV class implementing both StreamingService and GamingService interfaces
public class SmartTV implements StreamingService, GamingService {
    private String[] movieNames;
    private String[] gameNames;

    public SmartTV() {
        movieNames = new String[] {"Inception", "Avatar", "Interstellar"};
        gameNames = new String[] {"Forza Horizon 6", "Chess", "Car Race"};
    }

    public void streamMovie(String movieName) {
        System.out.println("Streaming movie: " + movieName);
    }

    public void playGame(String gameName) {
        System.out.println("Playing game: " + gameName);
    }

    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
        System.out.println("Smart TV subscription: Movies and games are active");
    }

    public void displayContent() {
        System.out.println("Available Movies:");
        for (int i = 0; i < movieNames.length; i++) {
            System.out.println(movieNames[i]);
        }

        System.out.println("Available Games:");
        for (int i = 0; i < gameNames.length; i++) {
            System.out.println(gameNames[i]);
        }
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();
        tv.showSubscriptionDetails();
        tv.displayContent();
        tv.streamMovie(tv.movieNames[0]);
        tv.playGame(tv.gameNames[0]);
    }
}
