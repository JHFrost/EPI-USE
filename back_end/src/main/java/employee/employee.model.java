import java.io.*;

public class Employee extends Staff{

    Employee(String name, String surname, Date birthDate, int employeeNumber, float salary, Employee senior){
        super(name, surname, birthDate, employeeNumber, salary, "Employee", senior);
    }

    public void printDetails(){
        String employeeDetails =    "name: "+getName()+"\n"+
                                    "surname: "+getSurname()+"\n"+
                                    "birth date: "+getBirthDate()+"\n"+
                                    "employee number: "+getEmployeeNumber()+"\n"+
                                    "salary: "+getSalary()+"\n"+
                                    "role designation: Employee \n"+
                                    "reports to: "+getSenior().getName()+"\n";

        System.out.println(employeeDetails);
    }
}