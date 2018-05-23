/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;

/**
 *
 * @author Adilbek Nurmakov
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T>{

    T a[];
    int front,back;
    int size;
    int n;
    
    private int inc(int i){
        i = (i + 1) % size;
        return i;
    }
    private int dec( int i){
        i = (i - 1 + size) % size;
        return i;
    }
    
    public ArrayQueue(){
        front = 0;
        back = 0;
        a = (T[])new Object[10];
        size = 10;
        n = 0;
    }
    
    @Override
    public void enqueue(T value) {
        n++;
        int nfront = inc(front);
        if(n < size){
            a[front] = value;
            front = nfront;
        }
        else{
            T b[] = (T[])new Object[size * 2];
            int nback = 0;
            nfront = 0;
            do{
                b[nfront++] = a[back];
                back = inc(back);                                
            }while(back != front);
            b[nfront++] = value;
            System.out.println(value);
            System.out.println(b[nfront - 1]);
            front = nfront;
            back = nback;
            a = b;
            size *= 2;
        }
    }

    @Override
    public T dequeue() throws Exception{
        if(n == 0){
            throw new Exception("No elements in hell!");
        }
        n--;
        T ret = a[back];
        back = inc(back);  
        return ret;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public void clear() {
        front = back = 0;
        n = 0;
    }   
    
    @Override
    public String toString(){
        
        String res = "Stack: [";
        if (n == 0) {
            System.out.println(res + "]");
        }
        String ans = "";
        for(int i = back; i != front; i = inc(i)){
            ans += "" + a[i] + " ";
        }
        return ans;
    }

}