import java.util.*;

// Abstract course type class
abstract class CourseType {
    public abstract String getCourseType();
}

// Subclasses for specific course types
class ExamCourse extends CourseType {
    public String getCourseType() {
        return "Exam Based";
    }
}

class AssignmentCourse extends CourseType {
    public String getCourseType() {
        return "Assignment Based";
    }
}

class ResearchCourse extends CourseType {
    public String getCourseType() {
        return "Research Based";
    }
}

// Generic Course class with a type parameter extending CourseType
class Course<T extends CourseType> {
    String courseName;
    T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }
}

// main class
public class MultiLevelUniversityCourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> c1 = new Course<ExamCourse>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> c2 = new Course<AssignmentCourse>("English", new AssignmentCourse());
        Course<ResearchCourse> c3 = new Course<ResearchCourse>("Physics", new ResearchCourse());

        List<Course<? extends CourseType>> courses = new ArrayList<Course<? extends CourseType>>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        showCourses(courses);
    }

    public static void showCourses(List<Course<? extends CourseType>> courses) {
        System.out.println("Course types:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course.courseType.getCourseType());
        }
    }
}
