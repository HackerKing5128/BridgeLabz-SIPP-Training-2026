import java.util.Scanner;

public class MovieSeatReservation {
    private int[] seats = {101, 102, 103, 104, 105};

    public int getSeat(int index) {
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Seat position " + index + " is invalid");
            return -1;
        }
    }

    public void displayAllSeats() {
        System.out.println("Available seats:");
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Position " + i + ": Seat " + seats[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieSeatReservation reservation = new MovieSeatReservation();

        reservation.displayAllSeats();

        System.out.print("Enter seat position: ");
        int position = sc.nextInt();

        int seatNumber = reservation.getSeat(position);

        if (seatNumber != -1) {
            System.out.println("Reserved seat: " + seatNumber);
        }

        sc.close();
    }
}
