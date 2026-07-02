import java.util.*;

// job role superclass
abstract class JobRole {
    String candidateName;
    int yearsOfExperience;

    public JobRole(String candidateName, int yearsOfExperience) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
    }

    public abstract String getRoleName();
}

// subclasses for specific job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int yearsOfExperience) {
        super(candidateName, yearsOfExperience);
    }

    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int yearsOfExperience) {
        super(candidateName, yearsOfExperience);
    }

    public String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int yearsOfExperience) {
        super(candidateName, yearsOfExperience);
    }

    public String getRoleName() {
        return "Product Manager";
    }
}

// Generic class to represent a resume with a specific job role
class Resume<T extends JobRole> {
    T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }
}


// main class
public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<SoftwareEngineer>(new SoftwareEngineer("Ravi", 5));
        Resume<DataScientist> resume2 = new Resume<DataScientist>(new DataScientist("Neha", 4));
        Resume<ProductManager> resume3 = new Resume<ProductManager>(new ProductManager("Amit", 6));

        List<Resume<? extends JobRole>> resumes = new ArrayList<Resume<? extends JobRole>>();
        resumes.add(resume1);
        resumes.add(resume2);
        resumes.add(resume3);

        screenResumes(resumes);
    }

    public static void screenResumes(List<Resume<? extends JobRole>> resumes) {
        System.out.println("Screening job roles:");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(resume.jobRole.getRoleName() + " - experience: " + resume.jobRole.yearsOfExperience + " years");
        }
    }
}

