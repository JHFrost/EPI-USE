package main.java.employee;

import java.util.Date;
import java.lang.Comparable;

abstract public class Staff implements Comparable<Staff>{
    private String name;
    private String surname;
    private Date birthDate;
    private int employeeNumber;
    private float salary;
    private String roleDesignation;
    private Staff senior;

    abstract public void printDetails();

    public Staff(String name, String surname, Date birthDate, int employeeNumber, float salary, String roleDesignation, Staff senior){
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

    public String getRoleDesignation() {
        return roleDesignation;
    }

    public Staff getSenior() {
        return senior;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setSenior(Staff senior) {
        this.senior = senior;
    }

    public void setRoleDesignation(String roleDesignation) {
        this.roleDesignation = roleDesignation;
    }

    public int compareTo(Staff o) {
        if (this.salary < o.salary)
            return 1;
        else if (this.salary > o.salary)
            return -1;
        else
            return 0;
    }
}