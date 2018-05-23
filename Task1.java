/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntQueue;
import csci152.adt.IntStack;

/**
 *
 * @author Adilbek Nurmakov
 */
public class Task1 {

    public static void main(String[] args) {
        try {
            IntQueue q = new ArrayIntQueue();
            q.enqueue(1);
            q.enqueue(2);
            q.enqueue(3);
            q.enqueue(4);
            q.enqueue(5);
            q.enqueue(6);
            System.out.println("Initial queue was" + q);
            System.out.println(reversedQueue(q));

            IntStack sta = new ArrayIntStack();
            sta.push(1);
            sta.push(2);
            sta.push(3);
            sta.push(4);
            System.out.println(sta);
            System.out.println(reverseStack(sta));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static IntQueue reversedQueue(IntQueue q) throws Exception {
        IntQueue newq = new ArrayIntQueue();
        IntStack st = new ArrayIntStack();
        for (int i = 0; i < q.getSize(); i++) {
            int res = q.dequeue();
            q.enqueue(res);
            st.push(res);
        }
        // System.out.println(st);
        //System.out.println(st.getSize());
        for (int i = 0; i < q.getSize(); i++) {

            newq.enqueue(st.pop());
        }
        System.out.println("The reversed queue is" + newq);
        return q;
    }

    public static IntStack reverseStack(IntStack sta) throws Exception {
        IntStack sta1 = new ArrayIntStack();

        int size = sta.getSize();
        for (int i = 0; i < size; i++) {
            int res = sta.pop();
            sta1.push(res);

        }
        System.out.println("The reversed stack is" + sta1);

        return sta;
    }

}
