/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntQueue;

/**
 *
 * @author Адильбек
 */
public class Tester {
  /**  public static void reverseQueue ()throws Exception {
      ArrayIntQueue q=new ArrayIntQueue();
        ArrayIntQueue nq=new ArrayIntQueue();
        ArrayIntStack stc=new ArrayIntStack();
       
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
      //  for(int i=0;i<q.size;i++){
       //     stc.push(q.dequeue());
        }
      //  for (int i=0;i<stc.getSize();i++ ){
       //     nq.enqueue(stc.pop());
        }
     //   System.out.println(nq);
  //  }**/
    public static void main(String[] args) throws Exception {
       ArrayIntQueue q=new ArrayIntQueue();
    
       ArrayIntQueue nq=new ArrayIntQueue();
        ArrayIntStack stc=new ArrayIntStack();
       q.enqueue(1);
       q.enqueue(2);
       q.enqueue(3);
       q.enqueue(4);

System.out.println(q);
System.out.println(q.getSize());
   



 for(int i=0;i<=(q.getSize()+1);i++){
      int res=q.dequeue(); 
         stc.push(res);
           
        }
 System.out.println(stc);
           
      for (int i=0;i<=(stc.getSize()+1);i++ ){
          int rem=stc.pop();
           nq.enqueue(rem);
        }
       System.out.println(nq);
       
       for(int i=0;i<=(nq.getSize()+1);i++){
           int rem=nq.dequeue();
           stc.push(rem);
       }
       System.out.println(stc);
      
       for(int i=0;i<=(stc.getSize()+1);i++){
           int rem=stc.pop();
           q.enqueue(rem);
       }
       System.out.println(q);
       System.out.println(q.getSize());
       
  }
  

    }
    
        
        
        
    


