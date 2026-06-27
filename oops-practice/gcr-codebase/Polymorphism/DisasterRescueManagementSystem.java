// Superclass RescueTeam
abstract class RescueTeam {
    String teamId;
    String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public abstract String performDuty();
}

// Subclass MedicalTeam
class MedicalTeam extends RescueTeam {
    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    public String performDuty() {
        return "Provide medical care";
    }
}

// Subclass FireRescueTeam
class FireRescueTeam extends RescueTeam {
    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    public String performDuty() {
        return "Control fire and rescue people";
    }
}

// Subclass FoodSupplyTeam
class FoodSupplyTeam extends RescueTeam {
    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    public String performDuty() {
        return "Distribute food supplies";
    }
}

// Main class
public class DisasterRescueManagementSystem {
    public static RescueTeam findTeamByLocation(RescueTeam[] teams, String location) {
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].location.equalsIgnoreCase(location)) {
                return teams[i];
            }
        }
        return null;
    }

    public static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("Teams starting with prefix " + prefix + ":");
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].teamId.startsWith(prefix)) {
                System.out.println(teams[i].teamId + " - " + teams[i].location);
            }
        }
    }

    public static void countTeamsByCategory(RescueTeam[] teams) {
        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        for (int i = 0; i < teams.length; i++) {
            if (teams[i] instanceof MedicalTeam) {
                medicalCount++;
            } else if (teams[i] instanceof FireRescueTeam) {
                fireCount++;
            } else if (teams[i] instanceof FoodSupplyTeam) {
                foodCount++;
            }
        }

        System.out.println("Medical teams: " + medicalCount);
        System.out.println("Fire rescue teams: " + fireCount);
        System.out.println("Food supply teams: " + foodCount);
    }

    public static void displayMaximumDeploymentCategory(RescueTeam[] teams) {
        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        for (int i = 0; i < teams.length; i++) {
            if (teams[i] instanceof MedicalTeam) {
                medicalCount++;
            } else if (teams[i] instanceof FireRescueTeam) {
                fireCount++;
            } else if (teams[i] instanceof FoodSupplyTeam) {
                foodCount++;
            }
        }

        if (medicalCount >= fireCount && medicalCount >= foodCount) {
            System.out.println("Maximum deployments: MedicalTeam");
        } else if (fireCount >= medicalCount && fireCount >= foodCount) {
            System.out.println("Maximum deployments: FireRescueTeam");
        } else {
            System.out.println("Maximum deployments: FoodSupplyTeam");
        }
    }

    public static void main(String[] args) {
        RescueTeam[] teams = {
                new MedicalTeam("M101", "Zone A"),
                new FireRescueTeam("F201", "Zone B"),
                new FoodSupplyTeam("D301", "Zone C"),
                new MedicalTeam("M102", "Zone D"),
                new FireRescueTeam("F202", "Zone E")
        };

        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].teamId + " duty: " + teams[i].performDuty());
        }

        RescueTeam foundTeam = findTeamByLocation(teams, "Zone B");
        if (foundTeam != null) {
            System.out.println("\nTeam found at Zone B: " + foundTeam.teamId + "\n");
        } else {
            System.out.println("No team found at the given location\n");
        }

        displayTeamsByPrefix(teams, "M");
        System.out.println();
        countTeamsByCategory(teams);
        displayMaximumDeploymentCategory(teams);
    }
}

