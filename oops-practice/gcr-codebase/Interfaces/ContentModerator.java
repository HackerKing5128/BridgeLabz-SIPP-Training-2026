// TextModeration interface
interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Text moderation policy: offensive words are not allowed");
    }

    static boolean containsRestrictedWords(String post) {
        if (post == null) {
            return false;
        }

        String text = post.toLowerCase();
        String[] words = {"badword", "hate", "abuse", "offensive"};

        for (int i = 0; i < words.length; i++) {
            if (text.contains(words[i])) {
                return true;
            }
        }
        return false;
    }
}

// SpamDetection interface
interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam detection policy: repeated promotions are not allowed");
    }
}

// ContentModerator class implementing TextModeration and SpamDetection interfaces
public class ContentModerator implements TextModeration, SpamDetection {
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    public boolean isSpam(String post) {
        if (post == null) {
            return false;
        }

        String text = post.toLowerCase();
        return text.contains("buy now") || text.contains("free") || text.contains("winner") || text.contains("click");
    }

    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public static void main(String[] args) {
        ContentModerator moderator = new ContentModerator();
        String[] posts = {
            "Buy now and get free gifts",
            "This is a normal post",
            "I hate this product",
            "Click here to win free coupons",
            "Good morning everyone"
        };

        moderator.displayModerationPolicy();
        System.out.println();

        for (int i = 0; i < posts.length; i++) {
            String post = posts[i];
            System.out.println("Post: " + post);

            if (moderator.isOffensive(post)) {
                System.out.println("Status: Offensive post");
            } else if (moderator.isSpam(post)) {
                System.out.println("Status: Spam post");
            } else {
                System.out.println("Status: Valid post");
            }
            System.out.println();
        }
    }
}
