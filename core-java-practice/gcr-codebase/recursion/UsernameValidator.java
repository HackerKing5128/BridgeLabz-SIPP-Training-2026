// Username Validator using recursion

class UsernameValidator {
    public static void main(String[] args) {
        String username1 = "abcdxyz";
        String username2 = "abcD123";

        System.out.println("Username: " + username1);
        System.out.println("Is valid: " + isValidUsername(username1));

        System.out.println("Username: " + username2);
        System.out.println("Is valid: " + isValidUsername(username2));
    }

    public static boolean isValidUsername(String username) {
        // call recursive helper function
        return solve(username, 0);
    }

    private static boolean solve(String username, int index) {
        if (index == username.length()) {
            return true;
        }
        char currentChar = username.charAt(index);
        if (currentChar < 'a' || currentChar > 'z') {
            return false;
        }
        return solve(username, index + 1);
    }
}