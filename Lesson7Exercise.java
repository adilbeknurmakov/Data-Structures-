/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;


import csci152.adt.IntQueue;
import csci152.adt.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
  * @author Adilbek Nurmakov  and Akhan Janabekov
 */
public class Lesson7Exercise {

    public static Queue copy(Queue orig) {
        
        Queue<Integer> myQ = new ArrayQueue();
        
        int n = orig.getSize();
       int[] a = new int[n];
        for(int i = 0; i < n; ++i){
            try {
               a[i] = (int)orig.dequeue();
            } catch (Exception ex) {
                Logger.getLogger(Lesson7Exercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for(int i = 0; i < n; ++i){
            myQ.enqueue(a[i]);
            orig.enqueue(a[i]);
        }
        return myQ;  
    }

    public static boolean isPalindrome(IntQueue a) {
        int n = a.getSize();
        int[] b = new int[n];
        for(int i = 0; i < n; ++i){
            try {
                b[i] = a.dequeue();
            } catch (Exception ex) {
                Logger.getLogger(Lesson7Exercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for(int i = 0; i < n; ++i){
            a.enqueue(b[i]);
        }
        for(int i = 0; i < n/2; ++i){
            if(b[i] != b[n - i - 1])return false;
        }
        return true;
    }
     public static void main(String[] args) {
        
        copyTest();
        palindromeTest();
    }
   
    public static void copyTest() {
            
        System.out.println("=== Copy Test ===");

        Queue<Integer> q1 = new ArrayQueue();
        Queue<Integer> q2 = copy(q1);

        if (q1.getSize() != 0 || q2.getSize() != 0) {
            System.out.println("Test 1 failed.");
        }

        for (int i = 55; i < 100; i = i + 11) {
            q1.enqueue(i);
        }
        q2 = copy(q1);

        if (q1.getSize() != 5 || q2.getSize() != 5
                || !q1.toString().equals(q2.toString())) {
            System.out.println("Test 2 failed.");
        }

        q1.clear();
        for (int i = 1000; i > 0; i = i - 3) {
            q1.enqueue(i);
        }
        q2 = copy(q1);

        if (q1.getSize() != 334 || q2.getSize() != 334
                || !q1.toString().equals(q2.toString())) {
            System.out.println("Test 3 failed.");
        }

        // Add any other tests you think are needed
        
        System.out.println("Finished.");
        
    }
    
    public static void palindromeTest() {
                
        System.out.println("=== Palindrome Test ===");

        if (!isPalindrome(createQueue())) {
            System.out.println("Test 1 failed.");
        }
           
        if (!isPalindrome(createQueue('a'))) {
            System.out.println("Test 2 failed.");
        }
              
        if (!isPalindrome(createQueue('a', 'a'))) {
            System.out.println("Test 3 failed.");
        }
                      
        if (!isPalindrome(createQueue('a','z', 'a', 'a'))) {
            System.out.println("Test 4 failed.");
        }
      
        if (!isPalindrome(createQueue('a','d', 'b', 'a'))) {
            System.out.println("Test 5 failed.");
        }
     
        if (!isPalindrome(createQueue('a', 'b', 'b', 'a'))) {
            System.out.println("Test 6 failed.");
        }
                
        if (!isPalindrome(createQueue('a', 'b', 'z', 'b', 'a'))) {
            System.out.println("Test 6 failed.");
        }
                
        if (isPalindrome(createQueue('a', 'b', 'z', 'b'))) {
            System.out.println("Test 7 failed.");
        }
         
        if (isPalindrome(createQueue('b', 'z', 'b', 'a'))) {
            System.out.println("Test 8 failed.");
        }
                
        if (isPalindrome(createQueue('a', 'b', 'z', 'y', 'b', 'a'))) {
            System.out.println("Test 9 failed.");
        }
 
        if (isPalindrome(createQueue('a', 'b', 'z', 'c', 'y', 'b', 'a'))) {
            System.out.println("Test 10 failed.");
        }
         
        if (isPalindrome(createQueue('a', 'b', 'z','f', 'z', 'y', 'b', 'a'))) {
            System.out.println("Test 11 failed.");
        }
         
        if (!isPalindrome(createQueue('a', 'b', 'c', 'b', 'b', 'c', 'b', 'a'))) {
            System.out.println("Test 12 failed.");
        }
        
        IntQueue q = new ArrayIntQueue();
        
        for(int i = 1; i < 100; i = i + 3) {
            q.enqueue(i);
        }        
        for(int i = 97; i > 0; i = i - 3) {
            q.enqueue(i);
        }
                
        if (!isPalindrome(q)) {
            System.out.println("Test 13 failed.");
        }
        
        q.enqueue(1);        
        if (isPalindrome(q)) {
            System.out.println("Test 14 failed.");
        }
        
        q.clear();        
        for(int i = 1; i < 100; i = i + 3) {
            q.enqueue(i);
        }        
        q.enqueue(999);
        q.enqueue(998);
        for(int i = 97; i > 0; i = i - 3) {
            q.enqueue(i);
        }
         
        q.enqueue(15);        
        if (isPalindrome(q)) {
            System.out.println("Test 14 failed.");
        }
        // Add any other tests you think are needed
        
        System.out.println("Finished.");
    }
    
   
    public static IntQueue createQueue(char... chars) {
        IntQueue result = new ArrayIntQueue();
        
        for (char ch : chars) {
            result.enqueue(ch);
        }
        
        return result;
    }
}