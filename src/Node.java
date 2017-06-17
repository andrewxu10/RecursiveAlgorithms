import java.awt.List;
import java.util.ArrayList;

//import java.util.ArrayList;
//
//public class Node<T> {
//    private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
//    private Node<T> parent = null;
//    private T data = null;
//
//    public Node(T data) {
//        this.data = data;
//    }
//
//    public Node(T data, Node<T> parent) {
//        this.data = data;
//        this.parent = parent;
//    }
//
//    public ArrayList<Node<T>> getChildren() {
//        return children;
//    }
//
//    public void setParent(Node<T> parent) {
//        parent.addChild(this);
//        this.parent = parent;
//    }
//
//    public void addChild(T data) {
//        Node<T> child = new Node<T>(data);
//        child.setParent(this);
//        this.children.add(child);
//    }
//
//    public void addChild(Node<T> child) {
//        child.setParent(this);
//        this.children.add(child);
//    }
//
//    public T getData() {
//        return this.data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public boolean isRoot() {
//        return (this.parent == null);
//    }
//
//    public boolean isLeaf() {
//        if(this.children.size() == 0) 
//            return true;
//        else 
//            return false;
//    }
//
//    public void removeParent() {
//        this.parent = null;
//    }
//}

public class Node<T>{
    private T data = null;
    private ArrayList<Node> children = new ArrayList<>();
    private Node parent = null;

    public Node(T data) {
        this.data = data;
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        Node<T> newChild = new Node<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(ArrayList<Node> children) {
        for(Node t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }
    
    public boolean isLeaf() {
      if(this.children.size() == 0) 
          return true;
      else 
          return false;
    }
}