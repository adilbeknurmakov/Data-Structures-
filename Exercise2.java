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
public class Exercise2 {

    public static Student find(Queue<Student> recs, int id) throws Exception {
        Student st = null;
        Student temp=null;
        int res = recs.getSize();
        boolean found = false;
        for (int i = 0; i < res; i++) {

            st = recs.dequeue();
            if (id == st.getID()) {
                found = true;
                temp=st;
            }else{
                recs.enqueue(st);
            }

        }
        return temp;
    }

    public static void main(String[] args) throws Exception {

        Queue<Student> stq = new LinkedListQueue();
        Student s1 = new Student(12, 4,"sdsdf");
        Student s2 = new Student(14, 56,"sdfsdf");
        Student s3 = new Student(15, 1,"asdasd");
       // Student s4 = new Student("Stas", 45);
        //Student s5 = new Student("Nikita", 89);
        stq.enqueue(s1);
        stq.enqueue(s2);
        stq.enqueue(s3);
      //  stq.enqueue(s4);
        //stq.enqueue(s5);
        find(stq, 1245);
        System.out.println(stq);
    }

}
