import java.io.*;

public class Manager extends Staff{

    Manager(String name, String surname, Date birthDate, int employeeNumber, float salary, Employee senior){
        super(name, surname, birthDate, employeeNumber, salary, "Manager", senior);
    }

    public void printDetails(){
        String managerDetails =    "name: "+getName()+"\n"+
                "surname: "+getSurname()+"\n"+
                "birth date: "+getBirthDate()+"\n"+
                "employee number: "+getEmployeeNumber()+"\n"+
                "salary: "+getSalary()+"\n"+
                "role designation: Manager \n"+
                "reports to: "+getSenior().getName()+"\n";

        System.out.println(managerDetails);
    }
}