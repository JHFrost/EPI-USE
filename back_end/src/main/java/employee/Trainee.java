package main.java.employee;

import java.util.Date;

public class Trainee extends Staff{

    public Trainee(String name, String surname, Date birthDate, int employeeNumber, float salary, Staff senior){
        super(name, surname, birthDate, employeeNumber, salary, "Trainee", senior);
    }

    public void printDetails(){
        String traineeDetails =    "name: "+getName()+"\n"+
                "surname: "+getSurname()+"\n"+
                "birth date: "+getBirthDate()+"\n"+
                "employee number: "+getEmployeeNumber()+"\n"+
                "salary: "+getSalary()+"\n"+
                "role designation: Trainee \n"+
                "reports to: "+getSenior().getName()+"\n";

        System.out.println(traineeDetails);
    }

    public void learn(){
        System.out.println("Trainee: "+getName()+" is learning.");
    }
}