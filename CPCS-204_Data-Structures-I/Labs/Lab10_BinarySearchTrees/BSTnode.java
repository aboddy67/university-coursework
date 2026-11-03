package Lab10_BinarySearchTrees;// BSTnode.java
// Author: 
// Class from which we can create BST node objects

public class BSTnode {
    private int data;//Value of node
    private BSTnode left;//Reference variable for left child or subtree
    private BSTnode right;//Reference variable for right child or subtree

    // CONSTRUCTORS
    public BSTnode() {
        data = 0;
        left = right = null;
    }

    public BSTnode(int data) {
        this.data = data;
        left = right = null;
    }

    public BSTnode(int data, BSTnode left, BSTnode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // ACCESSORS
    public int getData() {
        return data;
    }

    public BSTnode getLeft() {
        return left;
    }

    public BSTnode getRight() {
        return right;
    }

    // MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BSTnode left) {
        this.left = left;
    }

    public void setRight(BSTnode right) {
        this.right = right;
    }
}
