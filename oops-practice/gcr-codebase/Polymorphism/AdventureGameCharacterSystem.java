// polymorphism in a simple adventure game character system.

// Superclass GameCharacter
abstract class GameCharacter {
    String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public abstract String performAttack();
}

// Subclass Warrior
class Warrior extends GameCharacter {
    public Warrior(String characterName) {
        super(characterName);
    }

    public String performAttack() {
        return "uses sword strike";
    }
}

// Subclass Mage
class Mage extends GameCharacter {
    public Mage(String characterName) {
        super(characterName);
    }

    public String performAttack() {
        return "casts fire spell";
    }
}

// Subclass Archer
class Archer extends GameCharacter {
    public Archer(String characterName) {
        super(characterName);
    }

    public String performAttack() {
        return "shoots arrow";
    }
}

// Main class   
public class AdventureGameCharacterSystem {
    public static void startBattle(GameCharacter[] characters) {
        for (int i = 0; i < characters.length; i++) {
            System.out.println(characters[i].characterName + " attacks: " + characters[i].performAttack());
        }
    }

    public static void countCharacters(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] instanceof Warrior) {
                warriorCount++;
            } else if (characters[i] instanceof Mage) {
                mageCount++;
            } else if (characters[i] instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }

    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Arjun"),
            new Mage("Mira"),
            new Archer("Rohit"),
            new Warrior("Dev"),
            new Archer("Kira")
        };

        startBattle(characters);
        countCharacters(characters);
    }
}

