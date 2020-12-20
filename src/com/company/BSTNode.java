package com.company;

public class BSTNode {
    public BSTNode left;
    public BSTNode right;
    public BSTNode parent;
    public Integer key;

    public BSTNode(Integer key){
        left = null;
        right = null;
        parent = null;
        this.key = key;
    }
}
