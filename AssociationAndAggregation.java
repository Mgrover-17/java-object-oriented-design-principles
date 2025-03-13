import java.util.ArrayList;

// Course Class (Association: Many-to-Many with Student)
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;  // Students enrolled in this course

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Get course name
    public String getCourseName() {
        return courseName;
    }

    // Add a student to the course
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Display students enrolled in the course
    public void displayStudents() {
        System.out.println("Course: " + courseName + " - Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.getName());
        }
    }
}

// Student Class (Aggregation: Exists Independently, Associated with Courses)
class Student {
    private String name;
    private ArrayList<Course> enrolledCourses;  // Courses the student is enrolled in

    // Constructor
    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    // Get student name
    public String getName() {
        return name;
    }

    // Enroll in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);  // Association: Add student to course as well
    }

    // Display student's enrolled courses
    public void displayCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}

// School Class (Aggregation: Contains Students, but Students Exist Independently)
class School {
    private String schoolName;
    private ArrayList<Student> students;  // Students belong to this school

    // Constructor
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Get school name
    public String getSchoolName() {
        return schoolName;
    }

    // Add a student to the school
    public void addStudent(Student student) {
        students.add(student);
    }

    // Display students in the school
    public void displayStudents() {
        System.out.println("School: " + schoolName + " - Students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}

// Main Class
    public class AssociationAndAggregation {
    public static void main(String[] args) {
        // Creating a school
        School mySchool = new School("Holy Angels");

        // Creating students
        Student Riya = new Student("Riya");
        Student Piya = new Student("Piya");

        // Adding students to the school (Aggregation)
        mySchool.addStudent(Riya);
        mySchool.addStudent(Piya);

        // Creating courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses (Association)
        Riya.enrollInCourse(math);
        Riya.enrollInCourse(science);
        Piya.enrollInCourse(math);

        // Display School's students
        mySchool.displayStudents();

        // Display each student's courses
        Riya.displayCourses();
        Piya.displayCourses();

        // Display each course's enrolled students
        math.displayStudents();
        science.displayStudents();
    }
}
