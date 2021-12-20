package main.java;

import main.java.data_structure.*;
import main.java.employee.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


public class main {
    public static void main(String[] args){
        boolean first = false;
        Tree newTree = null;
        String name = "", surname = "", role = "";
        Date birthDate = null;
        int employeeNumber = -1, reportsTo = -1;
        float salary = -1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try{
            File employeeData = new File("back_end/employeeRecords.txt");
            Scanner dataReader = new Scanner(employeeData);
            int posComma;
            while (dataReader.hasNextLine()){
                try {
                    String data = dataReader.nextLine();
                    posComma = data.indexOf(',');
                    name = data.substring(0,posComma);
                    data = data.substring(posComma+1,data.length());

                    posComma = data.indexOf(',');
                    surname = data.substring(0,posComma);
                    data = data.substring(posComma+1,data.length());

                    posComma = data.indexOf(',');
                    birthDate = dateFormat.parse(data.substring(0,posComma));
                    data = data.substring(posComma+1,data.length());

                    posComma = data.indexOf(',');
                    employeeNumber = Integer.parseInt(data.substring(0,posComma));
                    data = data.substring(posComma+1,data.length());

                    posComma = data.indexOf(',');
                    salary = Float.parseFloat(data.substring(0,posComma));
                    data = data.substring(posComma+1,data.length());

                    posComma = data.indexOf(',');
                    role = data.substring(0,posComma);
                    data = data.substring(posComma+1,data.length());

                    reportsTo = Integer.parseInt(data);
                } catch (ParseException e) {
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
                if (!first){
                    Staff newManagement = new Manager(name, surname, birthDate, employeeNumber, salary, null);
                    first = true;
                    newTree = new Tree(newManagement);
                }else{
                    Node tempNode = newTree.findEmployee(newTree.root, reportsTo);
                    Staff newStaff = null;
                    List<Node> emptyList = new ArrayList<Node>();
                    switch(role){
                        case "Manager":
                            newStaff = new Manager(name, surname, birthDate, employeeNumber, salary, tempNode.data);
                            break;
                        case "Employee":
                            newStaff = new Employee(name, surname, birthDate, employeeNumber, salary, tempNode.data);
                            break;
                        case "Trainee":
                            newStaff = new Trainee(name, surname, birthDate, employeeNumber, salary, tempNode.data);
                            break;
                    }
                    newTree.addNode(newStaff, tempNode, emptyList);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("An error occurred while attempting to fetch the data from the file!");
            e.printStackTrace();
        }

        boolean quit = false;
        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";
        String searchInput = "";
        while(!quit){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("----------------------------------Welcome to EPI-USE----------------------------------");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Enter a number corresponding to the option that you wish to go with then press enter.");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("1) Search for employee by name and print their details.");
            System.out.println("2) Enter a date and list all employees older than the specified date.");
            System.out.println("3) Print the full organizational structure of employees based on reporting relationship.");
            System.out.println("4) Find highest earning member of each tier.");
            System.out.println("5) Exit.");
            userInput = inputScanner.nextLine();
            switch(userInput){
                case "1":
                    System.out.println("Enter the name of the employee that you wish to search for.");
                    searchInput = inputScanner.nextLine();
                    newTree.printEmployeeDetailsByName(newTree.root, searchInput);
                    break;
                case "2":
                    System.out.println("Enter the date that you wish to filter the employees by.");
                    searchInput = inputScanner.nextLine();
                    try{
                        newTree.printEmployeeDetailsByDate(newTree.root, dateFormat.parse(searchInput));
                    }
                    catch(ParseException ex){
                        System.out.println("There was an error with this option. Please contact the devs for assistance.");
                        ex.printStackTrace();
                    }
                    break;
                case "3":
                    newTree.printStructure(newTree.root, 0);
                    break;
                case "4":
                    newTree.sortByPayAsc();
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    System.out.println("You did not enter a valid number.");
                    break;
            }
        }
    }
}