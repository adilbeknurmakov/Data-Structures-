/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;
import csci152.adt.IntQueue;

/**
 *
 * @author Adilbek Nurmakov
 */
public class ArrayIntQueue implements IntQueue{

    int a[];
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
    
    public ArrayIntQueue(){
        front = 0;
        back = 0;
        a = new int[10];
        size = 10;
        n = 0;
    }
    
    @Override
    public void enqueue(int value) {
        n++;
        int nfront = inc(front);
        if(n < size){
            a[front] = value;
            front = nfront;
        }
        else{
            int b[] = new int[size * 2];
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
    public int dequeue() throws Exception{
        if(n == 0){
            throw new Exception("No elements in hell!");
        }
        n--;
        int ret = a[back];
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
  