/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.HashTableStats;
import csci152.adt.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Адильбек
 * @param <T>
 */
public class LLQHashTableSet<T> implements HashTableStats, Set<T>{
    
    private LinkedListQueue<T>[] buckets;
    
    public LLQHashTableSet(int numBuckets){
        buckets = new LinkedListQueue[numBuckets];
        for(int i = 0; i < numBuckets; ++i){
            buckets[i] = new LinkedListQueue();
        }
    }
    
    public void add(T value){
        int dest = Math.abs(value.hashCode()) % buckets.length;
        LinkedListQueue<T> buf = new LinkedListQueue();
        
        boolean was = false;
        //System.out.println(dest);
        while(buckets[dest].getSize() > 0){
            try {
                T x = buckets[dest].dequeue();
                if(x.equals(value))was = true;
                buf.enqueue(x);
            } catch (Exception ex) {
                Logger.getLogger(LLQHashTableSet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(!was)buf.enqueue(value);
        buckets[dest] = buf;
    }
    
    public boolean contains(T value){
        int dest = Math.abs(value.hashCode()) % buckets.length;
        LinkedListQueue<T> buf = new LinkedListQueue();
        
        boolean was = false;
        
        while(buckets[dest].getSize() > 0){
            try {
                T x = buckets[dest].dequeue();
                if(x.equals(value))was = true;
                buf.enqueue(x);
            } catch (Exception ex) {
                Logger.getLogger(LLQHashTableSet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        buckets[dest] = buf;
        return was;
    }
    
    public boolean remove(T value){
        int dest = Math.abs(value.hashCode()) % buckets.length;
        LinkedListQueue<T> buf = new LinkedListQueue();
        
        boolean was = false;
        
        while(buckets[dest].getSize() > 0){
            try {
                T x = buckets[dest].dequeue();
                if(x.equals(value))was = true;
                else buf.enqueue(x);
            } catch (Exception ex) {
                Logger.getLogger(LLQHashTableSet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        buckets[dest] = buf;
        return was;
    }
    
    public T removeAny() throws Exception{
        if(getSize() == 0)throw new Exception("Foxtrot Unicorn Charlie Kilo!");
        T toRet = null;
        for(int i = 0; i < buckets.length; ++i){
            if(buckets[i].getSize() > 0){
                toRet = buckets[i].dequeue();
                break;
            }
        }
        return toRet;
    }
    
    public int getSize(){
        int num = 0;
        for(int i = 0; i < getNumberOfBuckets(); ++i){
            num += buckets[i].getSize();
        }
        return num;
    }
    public void clear(){
        buckets = new LinkedListQueue[buckets.length];
        for(int i = 0; i < buckets.length; ++i){
            buckets[i] = new LinkedListQueue();
        }
    }
    
    @Override
    public String toString(){
        String ans = "";
        for(int i = 0; i < buckets.length;++i){
            if(buckets[i].getSize() > 0){
                ans = ans + buckets[i] + " + ";
            }
        }
        return ans;
    }    

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index < 0 || index >= getNumberOfBuckets()) throw new Exception("ololo");
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return 1.0 * getSize() / getNumberOfBuckets();
    }

    @Override
    public double getBucketSizeStandardDev() {
        double avg = getLoadFactor();
        double std = 0;
        for(int i = 0; i < getNumberOfBuckets(); ++i){
            std = std + (1.0 * buckets[i].getSize() - avg) * (1.0 * buckets[i].getSize() - avg);
            //System.out.println(std);
        }
        std /= getNumberOfBuckets() - 1;
        std = Math.sqrt(std);
        
        return std;
    }

    @Override
    public String bucketsToString() {
        String ans = "";
        for(int i = 0; i < getNumberOfBuckets(); ++i){
            ans = ans + buckets[i] + "; ";
        }
        return ans;
    }
}
