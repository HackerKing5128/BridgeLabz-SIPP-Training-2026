import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {
    private LinkedList<String> recentlyPlayed;

    public MusicPlaylistRecommendationEngine() {
        recentlyPlayed = new LinkedList<String>();
    }

    public void playSong(String songName) {
        recentlyPlayed.addFirst(songName);
        if (recentlyPlayed.size() > 10) {
            recentlyPlayed.removeLast();
        }
    }

    public boolean searchSong(String songName) {
        return recentlyPlayed.contains(songName);
    }

    public void displayHistory() {
        System.out.println("Recently Played Songs:");
        for (String song : recentlyPlayed) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine playlist = new MusicPlaylistRecommendationEngine();

        playlist.playSong("Tum Hi Ho");
        playlist.playSong("Galliyan");
        playlist.playSong("Badtameez Dil");
        playlist.playSong("Shape of You");
        playlist.playSong("Sooraj Dooba Hain");
        playlist.playSong("Lungi Dance");
        playlist.playSong("Perfect");
        playlist.playSong("One Dance");
        playlist.playSong("Abhi Toh Party Shuru Hui Hai");
        playlist.playSong("Samjhawan");
        playlist.playSong("Nights Changes");

        playlist.displayHistory();
        System.out.println();
        System.out.println("Song found: " + playlist.searchSong("Perfect"));
        System.out.println("Song found: " + playlist.searchSong("Faded"));
    }
}
