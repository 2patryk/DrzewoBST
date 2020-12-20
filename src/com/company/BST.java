package com.company;

public class BST {
    public BSTNode root;

    BST() {
        root = null;
    }

    // Based on http://www.algorytm.org/klasyczne/drzewa-poszukiwan-binarnych-bst/bst-j.html
    // check if root node has left or right children (depending key)
    // if child is null, algorithm add new node on left or right side (depending key)
    public void insert(int key) {
        if (root == null)
            root = new BSTNode(key);
        else {
            BSTNode actual = root;
            BSTNode parent = null;
            while (actual != null) {
                parent = actual;
                actual = (actual.key > key) ? actual.left : actual.right;
            }
            if (parent.key > key) {
                parent.left = new BSTNode(key);
                parent.left.parent = parent;
            } else {
                parent.right = new BSTNode(key);
                parent.right.parent = parent;
            }
        }
    }

    // print functions aggregation
    // recursive going to next vertices in each function
    public void printByOrder(BSTOrder order) {
        BSTNode actual = root;

        switch (order) {
            case PRE -> printPreOrder(actual);
            case IN -> printInOrder(actual);
            case POST -> printPostOrder(actual);
        }
    }

    private void printInOrder(BSTNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.key);
            printInOrder(node.right);
        }
    }

    private void printPreOrder(BSTNode node) {
        if (node != null) {
            System.out.println(node.key);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(BSTNode node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(node.key);
        }
    }

    public BSTNode maxNode() {
        BSTNode actual = root;

        while (actual.right != null)
            actual = actual.right;
        return actual;
    }

    public BSTNode minNode() {
        BSTNode actual = root;

        while (actual.left != null)
            actual = actual.left;
        return actual;
    }

    // return true if element with key exist
    // return false if not
    public boolean findKey(int key) {
        BSTNode actual = root;

        if (actual == null)
            return false;
        else {
            while (actual != null && key != actual.key) {
                System.out.println(actual.key);
                if (key < actual.key) {
                    System.out.println("<- Left");
                    actual = actual.left;
                } else {
                    System.out.println("-> Right");
                    actual = actual.right;
                }
            }
            return (actual != null);
        }
    }
}
