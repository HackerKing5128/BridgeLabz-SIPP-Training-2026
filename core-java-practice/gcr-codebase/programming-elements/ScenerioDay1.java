// Ravi just joined a coding guild. Store his name, age, rank, salary, and
// membership fee (float) using correct data types. Compute his
// annual bonus (12% of salary), cast it to int, and print a formatted
// welcome card.

class ScenerioDay1 {
	public static void main(String[] args) {
		String name = "Ravi";
		int age = 28;
		String rank = "Novice";
		double salary = 45000.50; // annual salary
		float membershipFee = 199.99f;

		// compute annual bonus (12% of salary) and cast to int
		double bonusDouble = salary * 0.12;
		int bonus = (int) bonusDouble;

		// formatted welcome card
		System.out.println("+----------------------------------+");
		System.out.printf("| %-33s|%n", "Welcome to the Coding Guild");
		System.out.println("+----------------------------------+");
		System.out.printf("| Name: %-27s|%n", name);
		System.out.printf("| Age: %-28d|%n", age);
		System.out.printf("| Rank: %-27s|%n", rank);
		System.out.printf("| Salary: $%-24.2f|%n", salary);
		System.out.printf("| Membership Fee: $%-16.2f|%n", membershipFee);
		System.out.printf("| Annual Bonus (12%%): $%-12d|%n", bonus);
		System.out.println("+----------------------------------+");
	}
}