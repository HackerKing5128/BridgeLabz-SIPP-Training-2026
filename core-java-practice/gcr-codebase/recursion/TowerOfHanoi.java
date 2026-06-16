// tower of hanoi problem : all steps required to move N disks from Source to Destination

class TowerOfHanoi {
    public static void main(String[] args) {
        int N = 3;
        System.out.println("Number of disks: " + N);
        solve(N, 'A', 'C', 'B');

        int M = 5;
        System.out.println("\nNumber of disks: " + M);
        solve(M, 'A', 'C', 'B');
    }

    public static void solve(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        // Move top n-1 disks from source to auxiliary
        solve(n - 1, source, auxiliary, destination);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move the n-1 disks from auxiliary to destination
        solve(n - 1, auxiliary, destination, source);
    }
}
