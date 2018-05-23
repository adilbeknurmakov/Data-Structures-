/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntStack;

/**
 *
 * @author Адильбек
 */
public class Task2 {

    public static IntStack duplicates(IntStack vals, IntStack counts) throws Exception {

        int res1, res2;
        int vsize = vals.getSize();
        int csize = counts.getSize();

        IntStack st = new ArrayIntStack();
        IntStack nst = new ArrayIntStack();
        IntStack dupvals = new ArrayIntStack();
        IntStack dupcounts = new ArrayIntStack();

        for (int i = 0, j = 0; i < vsize && j < csize; i++, j++) {

            res1 = vals.pop();//15
            dupvals.push(res1);//preservation

            res2 = counts.pop();//3
            dupcounts.push(res2);//preservation

            for (int k = 0; k < res2; k++) {
                st.push(res1);
            }
          

        }
        System.out.println("st"+st);
        int valssize = dupvals.getSize();
      
        int countsize = dupcounts.getSize();
        for (int i = 0, j = 0; i < valssize && j < countsize; i++, j++) {
            vals.push(dupvals.pop());
            counts.push(dupcounts.pop());
        }

        int size = st.getSize();
        int q;
        for (int m = 0; m < size; m++) {
            q = st.pop();
            nst.push(q);
        }
       

        return nst;

    }

    public static void main(String[] args) {
        try {
            IntStack vals = new ArrayIntStack();

            vals.push(22);
            vals.push(-22);
            vals.push(4);
            vals.push(15);

            IntStack counts = new ArrayIntStack();
            counts.push(1);
            counts.push(4);
            counts.push(0);
            counts.push(3);

            System.out.println("Stack of vals:" + vals);
            System.out.println("Stack counts:" + counts);

            System.out.println("Duplicated stack:" + duplicates(vals, counts));

            System.out.println("Satck of vals:" + vals);
            System.out.println("Stack of counts:" + counts);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
