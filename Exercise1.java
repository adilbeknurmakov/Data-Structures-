/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import java.util.Random;

/**
 *
 * @author Адильбек
 */
public class Exercise1 {
    
 public static void randomWalk() {
    int location = 0;
    int endWalk = 10;
    int[] arr = new int[10];
    
    Queue<String> q = new ArrayQueue();
    String pos = null;
    String pos1;

    while(location<endWalk){
    Random r = new Random();
        int value = r.nextInt(10);
        if (value % 2 == 0) {
            location++;
            pos = "forward";

        } else if (value % 2 != 0 ) {
            location--;
            pos = "backward";

        }
        arr[location]++;

        q.enqueue(pos);
        //q.enqueue(pos1);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[location];
        }
        System.out.println(q);
        System.out.println("THe sum" + result + "The size of queue "+ q.getSize());
       
    }
}
 public static void main(String[] args) throws Exception {
        randomWalk();
    }
}
