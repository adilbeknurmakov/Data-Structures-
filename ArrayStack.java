/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;


import csci152.adt.Stack;

/**
 *
 * @author Adilbek Nurmakov and Akhan Janabekov
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {

    private int size = 0;
    private int maxSize = 10;
    T[] arr = (T[])new Object[maxSize];

    @Override
    public void push(T value) {

        if (size == arr.length) {

            T[] buf = (T[])new Object[arr.length * 2];
            for (int i = 0; i < size; i++) {
                buf[i] = arr[i];
            }
            arr = buf;
            arr[size]=value;
            size++;
        
        } else {
            arr[size] = value;

            size++;
        }
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Stack is already empty");
        } else {
            T last = arr[size-1];
            size--;
            return last;
            
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    public String toString() {

        String res = "Stack: [";
        if (size == 0) {
            System.out.println(res + "]");
        }
        for (int i = 0; i < size; ++i) {
            res += arr[i];
            if (i == size - 1) {
                res += "]";
            } else {
                res += ", ";
            }
        }

        return res;
    }
}
