import java.util.ArrayList;
import java.util.List;

class UniCourse {
    private String name;
    private Professor professor;
    private List<UniStudent> students;

    public UniCourse(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(UniStudent student) {
        students.add(student);
        student.addUniCourse(this);
    }

    public void listStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (UniStudent student : students) {
            System.out.println(" - " + student.getName());
        }
    }

    public void showProfessor() {
        if (professor != null) {
            System.out.println("Professor teaching " + name + ": " + professor.getName());
        } else {
            System.out.println("No professor assigned to " + name);
        }
    }
}

class UniStudent {
    private String name;
    private List<UniCourse> UniCourses;

    public UniStudent(String name) {
        this.name = name;
        this.UniCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addUniCourse(UniCourse UniCourse) {
        if (!UniCourses.contains(UniCourse)) {
            UniCourses.add(UniCourse);
        }
    }

    public void listUniCourses() {
        System.out.println(name + " is enrolled in:");
        for (UniCourse UniCourse : UniCourses) {
            System.out.println(" - " + UniCourse.getName());
        }
    }
}

class Professor {
    private String name;
    private List<UniCourse> UniCourses;

    public Professor(String name) {
        this.name = name;
        this.UniCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addUniCourse(UniCourse UniCourse) {
        UniCourses.add(UniCourse);
    }

    public void listUniCourses() {
        System.out.println("UniCourses taught by Professor " + name + ":");
        for (UniCourse UniCourse : UniCourses) {
            System.out.println(" - " + UniCourse.getName());
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create students and professors
        UniStudent manvi = new UniStudent("manvi");
        UniStudent mv = new UniStudent("MV");

        Professor manu = new Professor("Dr. manu");
        Professor MG = new Professor("mg");

        // Create UniCourses
        UniCourse math = new UniCourse("Mathematics");
        UniCourse cs = new UniCourse("Computer Science");

        // Assign professors to UniCourses
        math.assignProfessor(manu);
        cs.assignProfessor(MG);

        manu.addUniCourse(math);
        MG.addUniCourse(cs);

        // Enroll students in UniCourses
        math.enrollStudent(manvi);
        cs.enrollStudent(manvi);
        cs.enrollStudent(mv);

        // Show UniCourse details
        math.showProfessor();
        math.listStudents();

        cs.showProfessor();
        cs.listStudents();

        // Show student and professor UniCourse lists
        manvi.listUniCourses();
        mv.listUniCourses();
        manu.listUniCourses();
        MG.listUniCourses();
    }
}