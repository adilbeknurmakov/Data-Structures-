/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;

/**
 *
 * @author Адильбек
 */
public class LinkedListQueue<T> implements Queue<T> {

    private int size;
    private Node<T> front;
    private Node<T> back;

    public LinkedListQueue() {
        size = 0;
        front = null;
        back = null;

    }

    @Override
    public void enqueue(T value) {
        Node<T> tnt = new Node(value);
        if (size == 0) {
            tnt.setLink(back);
            front = tnt;
            back = tnt;
            size++;
        } else {
            back.setLink(tnt);
            back = tnt;

            size++;
        }
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("The llist is empty");
        } else if (size == 1) {
            T res = front.getValue();

            back = null;
            front = null;
            size--;
            return res;
        }
        T res = front.getValue();
        front = front.getLink();

        size--;
        return res;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        back = null;
        front = null;

    }

    public String toString() {
        String ans = "";
        Node<T> cur;
        cur = front;
        while (cur != null) {

            ans += cur.getValue() + " ";
            cur = cur.getLink();
        }
        return ans;
    }
}
