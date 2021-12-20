package main.java.employee;

import java.util.Date;

public class Manager extends Staff{

    public Manager(String name, String surname, Date birthDate, int employeeNumber, float salary, Staff senior){
        super(name, surname, birthDate, employeeNumber, salary, "Manager", senior);
    }

    public void printDetails(){
        String managerDetails = "name: "+getName()+"\n"+
            "surname: "+getSurname()+"\n"+
            "birth date: "+getBirthDate()+"\n"+
            "employee number: "+getEmployeeNumber()+"\n"+
            "salary: "+getSalary()+"\n"+
            "role designation: Manager \n";
        if (this.getSenior()==null)
            managerDetails += "reports to: nobody\n";
        else
            managerDetails += "reports to: "+getSenior().getName()+"\n";

        System.out.println(managerDetails);
    }
    
    public void callMeeting(){
        System.out.println("Manager: "+getName()+" is calling a meeting.");
    }
}