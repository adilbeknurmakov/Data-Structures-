/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Адильбек
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;
    
    BSTSet(){
        root =null;
        size = 0;
    }
    

    
    @Override
    public void add(T value) {
        TreeNode<T> newNode = new TreeNode(value);
        TreeNode<T> prev = null;
        
        if(size == 0) {
            root = newNode;
        } else {
            TreeNode<T> temp= root;
            if(!contains(value)){
                while(temp != null) {
                    int comp = value.compareTo(temp.getValue());
                    prev = temp;
                    if(comp > 0){
                        temp = temp.getRight();
                    } else if(comp < 0) {
                        temp = temp.getLeft();
                    }
                }
                
                if((value.compareTo(prev.getValue())) > 0){
                    prev.setRight(newNode);
                } else if((value.compareTo(prev.getValue())) < 0){
                    prev.setLeft(newNode);
                }
            }
        }
        size++;
    }

    @Override
    public boolean contains(T value) {
        if(size == 0) {
            return false;
        } else{
            TreeNode<T> temp = null;
            while(temp != null) {
                int comp = value.compareTo(temp.getValue());
                if(comp > 0){
                    temp = temp.getRight();
                } else if(comp < 0) {
                    temp = temp.getLeft();
                } else return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeAny() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String toString() {
        return toStringHelper(root);
    }

    public String toStringHelper(TreeNode<T> node) {
        if (root == null) {
            return " ";
        }
        return toStringHelper(node.getLeft())
                + node.getValue()
                + toStringHelper(node.getRight());
    }

}
