public class Tree<Employee>{
    private Node<Employee> root;

    public Tree(Employee rootData) {
        root = new node<Employee>();
        root.data = rootData;
        root.children = new ArrayList<Node<Employee>>();
    }
}

public static class Node<Employee>{
    private Employee data;
    private node<Employee> parent;
    private List<Node<Employee>> children;
}