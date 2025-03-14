import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class UniDepartment {
    private String name;
    private List<Faculty> facultyMembers;

    public UniDepartment(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void listFaculty() {
        System.out.println("Faculty in the " + name + " UniDepartment:");
        for (Faculty faculty : facultyMembers) {
            System.out.println(" - " + faculty.getName());
        }
    }

    public void clearFaculty() {
        facultyMembers.clear();
    }
}

class University {
    private String name;
    private List<UniDepartment> UniDepartments;

    public University(String name) {
        this.name = name;
        this.UniDepartments = new ArrayList<>();
    }

    public void addUniDepartment(String UniDepartmentName) {
        UniDepartment UniDepartment = new UniDepartment(UniDepartmentName);
        UniDepartments.add(UniDepartment);
    }

    public UniDepartment getUniDepartment(String UniDepartmentName) {
        for (UniDepartment dept : UniDepartments) {
            if (dept.getName().equals(UniDepartmentName)) {
                return dept;
            }
        }
        return null;
    }

    public void listUniDepartments() {
        System.out.println("UniDepartments in " + name + ":");
        for (UniDepartment dept : UniDepartments) {
            System.out.println(" - " + dept.getName());
        }
    }

    public void deleteUniversity() {
        System.out.println("Deleting university '" + name + "' and all its UniDepartments...");
        for (UniDepartment dept : UniDepartments) {
            dept.clearFaculty();
        }
        UniDepartments.clear();
    }
}
public class CompositionAndAggregation {

    public static void main(String[] args) {
        University university = new University("Tech University");

        university.addUniDepartment("Computer Science");
        university.addUniDepartment("Mathematics");

        UniDepartment csDept = university.getUniDepartment("Computer Science");
        UniDepartment mathDept = university.getUniDepartment("Mathematics");

        Faculty profAlice = new Faculty("Professor Alice");
        Faculty profBob = new Faculty("Professor Bob");
        Faculty profCharlie = new Faculty("Professor Charlie");

        // Adding faculty to UniDepartments
        if (csDept != null) {
            csDept.addFaculty(profAlice);
            csDept.addFaculty(profBob);
        }

        if (mathDept != null) {
            mathDept.addFaculty(profCharlie);
        }

        // Listing UniDepartments and faculty
        university.listUniDepartments();
        if (csDept != null) csDept.listFaculty();
        if (mathDept != null) mathDept.listFaculty();

        // Faculty existing independently
        System.out.println(profAlice.getName() + " can exist independently of any UniDepartment.");

        // Deleting the university
        university.deleteUniversity();
    }
}