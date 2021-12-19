import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree<Staff>{
    private Node<Staff> root;

    Tree(Staff rootData) {
        root = new Node<Staff>();
        root.data = rootData;
        root.children = new ArrayList<Node<Staff>>();
    }

    //-----------------Adding new nodes----------------------
    public Node<Staff> addNode(Staff data, Node<Staff> parent, List<Node<Staff>>children){
        Node<Staff> newNode = new Node<Staff>();
        newNode.data = data;
        newNode.parent = parent;
        if (children.size() > 0 && children != null)
            newNode.children = children;
        else
            newNode.children = new ArrayList<Node<Staff>>();

        if (parent == null){
            return newNode;
        }else{
            Node<Staff> tempNode = root;
            tempNode = findNode(parent);
            if (tempNode == null) {
                System.out.println("Apologies, we were unable to add the node as the supervisor had not been added yet, please add the supervisor first.");
                return null;
            }
            tempNode.add(newNode);
            System.out.println("New node added successfully.");
            return newNode;
        }
    }

    //Helper function to find a specific node
    public static Node<Staff> findNode(Node<Staff> node){
        Stack<Node<Staff>> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()){
            Node<Staff> tempNode = nodes.pop();
            if (tempNode == node)
                return tempNode;
        }
        return null;
    }

    //-----------------Printing employee(s) details based on a name passed in----------------------------------
    public void printEmployeeDetailsByName(String name){
        if (!root.data.getName().equals(name)) {
            Boolean isFound = false;
            Stack<Node<Staff>> nodes = new Stack<>();
            nodes.push(root);
            while (!nodes.isEmpty()){
                Node<Staff> tempNode = nodes.pop();
                if (tempNode.data.getName().equals(name)) {
                    tempNode.data.printDetails();
                    isFound = true;
                }
            }
            if (!isFound)
                System.out.println("Sorry, we were unable to find an employee with the given name.")
        }
        else
            root.data.printDetails();
    }

    //--------------Printing employee(s) details older than passed in date--------------------
    public void printEmployeeDetailsByDate(Date date){
            Boolean isFound = false;
            Stack<Node<Staff>> nodes = new Stack<>();
            nodes.push(root);
            while (!nodes.isEmpty()){
                Node<Staff> tempNode = nodes.pop();
                if (tempNode.data.getBirthDate()<=date) {
                    tempNode.data.printDetails();
                    isFound = true;
                }
            }
            if (!isFound)
                System.out.println("Sorry, we were unable to find any employee that has a birth date that is older than the given date.")
    }

    //------------------Sorting the tree by pay in ascending order------------------
    public void sortByPayAsc(){
        Stack<Node<Staff>> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            int pos;
            Node<Staff> tempNode = nodes.pop();
            Node<Staff> currNode;
            for (int i = 0; i < tempNode.children().size(); i++){
                currNode = tempNode.children[i];
                pos = -1
                for (int p = (i+1); p < tempNode.children().size(); p++){
                    if (currNode.data.getSalary() > tempNode.children[p]) {
                        currNode = tempNode.children[p];
                        pos = p;
                    }
                }
                if (currNode != tempNode.children[i] && pos != -1) {
                    tempNode.children[pos] = tempNode.children[i];
                    tempNode.children[i] = currNode;
                }
            }
        }
    }

}

public static class Node<Staff>{
    private Staff data;
    private Node<Staff> parent;
    private List<Node<Staff>> children;
}