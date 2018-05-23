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
public class Task3 {
    
    public static void main(String[] args) throws Exception {
       
        try{String sen = "((23 + 45)*3) + (3+4*(5-7))";
        System.out.println(isBalanced(sen));}
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static boolean isBalanced(String s) throws Exception {

        boolean balanced = true;

        IntStack st = new ArrayIntStack();
        IntStack nst = new ArrayIntStack();

        char[] chr = s.toCharArray();
      //System.out.println(chr);

        for (int i = 0; i < chr.length; i++) {

            if (chr[i] == ')' || chr[i] == '(') {
                st.push(chr[i]);
            }
        }
        
        System.out.println("The stack contains such ASCII values as" + st);
        int res = st.getSize();

        if (st.getSize() % 2 != 0) {
            return balanced = false;
        }

        for (int i = 0; i < res; i++) {

            int chr1 = st.pop();
          

            if (chr1 == ')') {
                nst.push(chr1);
              if (st.getSize() == 0) {
                     
                     
                 balanced = false;}
              
            
            } else if (chr1 == '(') {
                {
                    if (nst.getSize() == 0) {
                         balanced = false;
                        throw new Exception("The string is not balanced");
                         
                    }

                nst.pop();
                
                }
            }
        }
        if (nst.getSize() != 0) {
             balanced = false;
        }
        return balanced;
    }

}
