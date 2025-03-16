import java.util.ArrayList;
import java.util.List;

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }

    // Abstract method for salary calculation
    public abstract double calculateSalary();


    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

// Interface for Department
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// FullTimeEmployee subclass
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void assignDepartment(String dept) {

        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {

        return "Full-Time Employee in " + department + " Department";
    }
}

// PartTimeEmployee subclass
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
        super(employeeId, name, 0); // Base salary is not used for part-time employees
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {

        return hoursWorked * hourlyRate;
    }

    @Override
    public void assignDepartment(String dept) {

        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {

        return "Part-Time Employee in " + department + " Department";
    }
}

// Main class to demonstrate polymorphism
public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000, 5000);
        emp1.assignDepartment("IT");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 20, 500);
        emp2.assignDepartment("Support");

        employees.add(emp1);
        employees.add(emp2);


        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            emp.displayDetails();
            System.out.println();
        }
    }
}
