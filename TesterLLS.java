/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Set;
import csci152.adt.Stack;

/**
 *
 * @author Адильбек
 */
public class TesterLLS {

    public static void main(String[] args) throws Exception {
        Set<Integer> lo = new LLQueueSet();
        Set<Student> st = new LLQueueSet();
        Student s1 = new Student(1,2,"azamat");
        Student s2 = new Student(1,2,"bauka");
        Student s3 = new Student(1,2,"bro");
        st.add(s1);
        st.add(s2);
        st.add(s3);
        st.add(s3);
        st.clear();
        //Queue<Integer> lo = new LinkedListQueue();
       // Stack<Integer> li1=new LinkedListStack();
        lo.add(1);
        lo.add(2);
        lo.add(3);
        lo.add(4);
        lo.add(5);
       // lo.remove(5);
        //lo.removeAny();
       // lo.clear();
        lo.removeAny();
        
        System.out.println(lo.getSize());
     //   lo.removeAny();
       // lo.removeAny();
      

        System.out.println("The set contains " + lo);
        System.out.println("The set contains " + st);
        
        }
        
       
     

    
       

    }


