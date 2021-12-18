import java.util.Date;
import java.lang.Comparable;

abstract class Staff implements Comparable<Staff>{
    private String name;
    private String surname;
    private Date birthDate;
    private int employeeNumber;
    private float salary;
    private string roleDesignation;
    private Employee senior;

    public abstract void printDetails();

    Staff(String name, String surname, Date birthDate, int employeeNumber, float salary, String roleDesignation, Employee senior){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.employeeNumber = employeeNumber;
        this.salary = salary;
        this.roleDesignation = roleDesignation;
        this.senior = senior;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public float getSalary() {
        return salary;
    }

    public string getRoleDesignation() {
        return roleDesignation;
    }

    public Employee getSenior() {
        return senior;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setSenior(Employee senior) {
        this.senior = senior;
    }

    public void setRoleDesignation(string roleDesignation) {
        this.roleDesignation = roleDesignation;
    }
}