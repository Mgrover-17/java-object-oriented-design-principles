import java.util.ArrayList;

// Employee Class (Inner Class inside Department)
class Employee {
    private String name;
    private String position;

    // Constructor
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Method to display Employee details
    public void displayEmployee() {
        System.out.println("   - " + name + " (" + position + ")");
    }
}

// Department Class (Composition: Exists only within a Company)
class Department {
    private String departmentName;
    private ArrayList<Employee> employees;  // Employees belong to this department

    // Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();  // Initialize empty employee list
    }

    // Method to add an employee to the department
    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    // Method to display department and employees
    public void displayDepartment() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

// Company Class (Composition: Owns Departments and Employees)
class Company {
    private String companyName;
    private ArrayList<Department> departments;  // A company has multiple departments

    // Constructor
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();  // Initialize empty department list
    }

    // Method to add a department to the company
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Method to get a department by index
    public Department getDepartment(int index) {
        if (index >= 0 && index < departments.size()) {
            return departments.get(index);
        }
        return null;
    }

    // Method to display company structure
    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    // Destructor-like method to simulate company deletion
    public void closeCompany() {
        System.out.println("\nClosing Company: " + companyName);
        departments.clear();  // Remove all departments (also removes employees)
        System.out.println("All departments and employees have been deleted.");
    }
}

// Main Class
public class CompanyAndDepartments {
    public static void main(String[] args) {
        // Creating a Company
        Company myCompany = new Company("Tech Innovators");

        // Adding Departments
        myCompany.addDepartment("Software Development");
        myCompany.addDepartment("Human Resources");

        // Adding Employees to Departments
        myCompany.getDepartment(0).addEmployee("Alice", "Software Engineer");
        myCompany.getDepartment(0).addEmployee("Bob", "Tech Lead");
        myCompany.getDepartment(1).addEmployee("Charlie", "HR Manager");

        // Display Company Structure
        myCompany.displayCompany();

        // Deleting Company (Composition: Deletes all departments & employees)
        myCompany.closeCompany();
    }
}
