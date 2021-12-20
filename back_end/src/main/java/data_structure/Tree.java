package main.java.data_structure;

import main.java.employee.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Date;

public class Tree{
    public Node root;

    public Tree(Staff rootData) {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<Node>();
    }

    //-----------------Adding new nodes----------------------
    public Node addNode(Staff data, Node parent, List<Node>children){
        Node newNode = new Node();
        newNode.data = data;
        newNode.parent = parent;
        if (children.size() > 0 && children != null)
            newNode.children = children;
        else
            newNode.children = new ArrayList<Node>();

        if (parent == null){
            return newNode;
        }else{
            Node tempNode = findNode(root, parent);
            if (tempNode == null) {
                System.out.println("Apologies, we were unable to add the node as the supervisor had not been added yet, please add the supervisor first.");
                return null;
            }
            tempNode.children.add(newNode);
            System.out.println("New node added successfully.");
            return newNode;
        }
    }

    //Helper functions to find a specific node
    public Node findNode(Node node, Node searchedNode){
        if (node == searchedNode)
            return node;
        if (node == null)
            return null;

        int totalChildren = node.children.size();
        for (int i = 0 ; i < totalChildren-1;i++)
            findNode(node.children.get(i), searchedNode);
        return findNode(node.children.get(totalChildren-1), searchedNode);
    }

    public Node findEmployee(Node node, int employeeID){
        if (node.data.getEmployeeNumber() == employeeID)
            return node;
        if (node == null)
            return null;

        int totalChildren = node.children.size();
        for (int i = 0 ; i < totalChildren-1;i++)
            findEmployee(node.children.get(i), employeeID);
        return findEmployee(node.children.get(totalChildren-1), employeeID);
    }

    //-----------------Printing employee(s) details based on a name passed in----------------------------------
    public void printEmployeeDetailsByName(Node curr, String name){
        if (curr == null)
            return;

        if (curr.data.getName().equalsIgnoreCase(name)){
            curr.data.printDetails();
        }

        int totalChildren = curr.children.size();
        for (int i = 0; i < totalChildren; i++)
            printEmployeeDetailsByName(curr.children.get(i), name);

    }

    //--------------Printing employee(s) details older than passed in date--------------------
    public void printEmployeeDetailsByDate(Node curr, Date date){
        if (curr == null)
            return;

        if (curr.data.getBirthDate().compareTo(date)<=0){
            curr.data.printDetails();
        }
        int totalChildren = curr.children.size();
        for (int i = 0; i < totalChildren; i++)
            printEmployeeDetailsByDate(curr.children.get(i), date);

    }

    //------------------Sorting the tree by pay in ascending order------------------
    public void sortByPayAsc(){
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            int pos;
            Node tempNode = nodes.pop();
            Node currNode;
            for (int i = 0; i < tempNode.children.size(); i++){
                currNode = tempNode.children.get(i);
                pos = -1;
                for (int p = (i+1); p < tempNode.children.size(); p++){
                    if (currNode.data.compareTo(tempNode.children.get(p).data)==-1) {
                        currNode = tempNode.children.get(p);
                        pos = p;
                    }
                }
                if (currNode != tempNode.children.get(i) && pos != -1) {
                    tempNode.children.set(pos, tempNode.children.get(i));
                    tempNode.children.set(i, currNode);
                }
            }
        }
    }

    public void printStructure(Node curr, int tabs){
        if (curr == null)
            return;
        
        
        if (curr.data.getSenior()!=null)
            System.out.print("--> ");
        
        System.out.println(curr.data.getName()+" "+curr.data.getSurname()+" ("+curr.data.getRoleDesignation()+")");
        for (int i= 0; i < 2; i++){
            for (int z=0; z<tabs ;z++){
                System.out.print("\t");
            }
            System.out.println("|");
        }
        int test = tabs +1;
        
        int totalChildren = curr.children.size();
        for (int i = 0; i < totalChildren; i++)
            printStructure(curr.children.get(i), test);
            
    }

    public void printHighestEarners(){
        sortByPayAsc();
        Node tempNode = root;
        System.out.println("Managers: "+tempNode.data.getName()+" "+tempNode.data.getSurname()+" - R "+tempNode.data.getSalary());
        while(tempNode != null){
        }
    }

}