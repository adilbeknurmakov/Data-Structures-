/*
 * made by Adilbek Nurmakov and Akhan Janabekov
 *
 *
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Set;

/**
 *
 * @author Adilbek Nurmakov and Akhan Janabekov
 */
public class LLQueueSet<T> implements Set<T> {

    Queue<T> queue = new LinkedListQueue();

    @Override
    public void add(T value) {
        if (!contains(value)) {
            queue.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        int res = queue.getSize();
        try {
            for (int i = 0; i < res; i++) {
                T temp = queue.dequeue();
                queue.enqueue(temp);
                if (temp.equals(value)) {
                    return true;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(T value) {

        try {
            for (int i = 0; i < queue.getSize(); i++) {
                T res = queue.dequeue();

                if (res.equals(value)) {

                    return true;
                }
                queue.enqueue(res);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {

        if (queue.getSize() == 0) {
            throw new Exception("Nothing there");
        }
        T res = queue.dequeue();

        return res;
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue = new LinkedListQueue();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
