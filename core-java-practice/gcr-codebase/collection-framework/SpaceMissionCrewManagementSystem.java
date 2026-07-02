import java.util.*;

// Astronaut class to represent an astronaut
class Astronaut {
    String astronautId;
    String name;
    String specialization;

    public Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }
}

// Main class
public class SpaceMissionCrewManagementSystem {
    private HashMap<String, List<Astronaut>> missionCrew;
    private HashMap<String, HashSet<String>> missionAstronautIds;

    public SpaceMissionCrewManagementSystem() {
        missionCrew = new HashMap<String, List<Astronaut>>();
        missionAstronautIds = new HashMap<String, HashSet<String>>();
    }

    public void addMission(String missionName) {
        if (!missionCrew.containsKey(missionName)) {
            missionCrew.put(missionName, new ArrayList<Astronaut>());
            missionAstronautIds.put(missionName, new HashSet<String>());
        }
    }

    public void assignAstronaut(String missionName, Astronaut astronaut) {
        if (!missionCrew.containsKey(missionName)) {
            addMission(missionName);
        }

        HashSet<String> assignedIds = missionAstronautIds.get(missionName);
        if (assignedIds.add(astronaut.astronautId)) {
            missionCrew.get(missionName).add(astronaut);
        } else {
            System.out.println("Duplicate astronaut ignored for mission " + missionName + ": " + astronaut.name);
        }
    }

    public void displayMissions() {
        for (String missionName : missionCrew.keySet()) {
            List<Astronaut> crew = missionCrew.get(missionName);
            System.out.println("Mission: " + missionName);
            for (Astronaut astronaut : crew) {
                System.out.println(astronaut.astronautId + " - " + astronaut.name + " - " + astronaut.specialization);
            }
            System.out.println("Total astronauts: " + crew.size());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system = new SpaceMissionCrewManagementSystem();

        system.addMission("Apollo");
        system.addMission("Orion");

        system.assignAstronaut("Apollo", new Astronaut("A101", "Ravi", "Pilot"));
        system.assignAstronaut("Apollo", new Astronaut("A102", "Neha", "Engineer"));
        system.assignAstronaut("Apollo", new Astronaut("A101", "Ravi", "Pilot"));
        system.assignAstronaut("Orion", new Astronaut("A103", "Amit", "Scientist"));
        system.assignAstronaut("Orion", new Astronaut("A104", "Pooja", "Medic"));
        
        System.out.println();
        system.displayMissions();
    }
}

