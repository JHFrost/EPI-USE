package main.java.employee;

import java.util.Date;

public class Employee extends Staff{

    public Employee(String name, String surname, Date birthDate, int employeeNumber, float salary, Staff senior){
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

    public void train(){
        System.out.println("Employee: "+getName()+" is teaching.");
    }
}