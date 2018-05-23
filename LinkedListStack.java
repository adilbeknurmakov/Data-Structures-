/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 *
 * @author Адильбек
 */
public class LinkedListStack<T> implements Stack<T> {

    int size;
    Node<T> top;

    LinkedListStack() {
        size = 0;
        top = null;
    }

    @Override
    public void push(T value) {
        Node<T> tnt = new Node(value);
       
        tnt.setLink(top);
        top = tnt;
        size++;

    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Link list is empty");
        }
        
        T res = top.getValue();
        top = top.getLink();
        size--;
        return res;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    public String toString() {
       
         String ans = " ";
        Node<T> cur;
        cur = top;
        while (cur != null) {
            
            ans = ans+cur.getValue() + " ";
            cur = cur.getLink();
        }
        return ans;
    }
}
