/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * /**
 *
 * @author Adilbek Nurmakov
 */
public class Arrival {

    private static int num = 500;//NUMBER OS STUDENTS TO BE ENROLLED

    static Set<Student> seng = new BSTSet();
    static Set<Student> sst = new BSTSet();
    static Set<Student> shss = new BSTSet();
    static Set<Student> med = new BSTSet();
    static Set<Student> edu = new BSTSet();
    static Set<Student> pol = new BSTSet();
    static Set<Student> bis = new BSTSet();
    static LLQHashTableSet<Integer> tape = new LLQHashTableSet(100000);

    public static void enrollStudent() {
        
       
        for (int i = 1; i < num; i++) {
        Student stu = new Student();
        int x = (int )(Math.random() * 99999 + 10000);
        stu.setID(x);
                if (tape.contains(x)) {
                    continue;
                } else {
                    

                    stu.setID(x);
                    tape.add(x);
                }
            
//SELECTING THE DORM
            Random z = new Random();
            int val = z.nextInt(3);

            if (val == 0) {
                stu.setDorm(22);

            }
            if (val == 1) {
                stu.setDorm(23);

            }
            if (val == 2) {

                stu.setDorm(24);

            }
//SELECTING SCHOOL AND ADDING
            Random r = new Random();

            int res = r.nextInt(100);
            if (res >= 0 && res < 20) {
                stu.setSchool("seng");
                seng.add(stu);
            } else if (res >= 20 && res < 50) {
                stu.setSchool("sst");
                sst.add(stu);
            } else if (res >= 50 && res < 75) {
                stu.setSchool("shss");
                shss.add(stu);
            } else if (res >= 75 && res < 80) {
                stu.setSchool("SOM");
                med.add(stu);
            } else if (res >= 80 && res < 90) {
                stu.setSchool("Education school");
                edu.add(stu);
            } else if (res >= 90 && res < 95) {
                stu.setSchool("Policy school");
                edu.add(stu);
            } else if (res >= 95 && res < 100) {
                stu.setSchool("Business school");
                edu.add(stu);
            }

        }
    }

    

    public static void main(String[] args) throws IOException {
        enrollStudent();

        File file = new File("SEng.txt");
        file.createNewFile();

        File file1 = new File("SST.txt");
        file1.createNewFile();

        File file2 = new File("SHSS.txt");
        file2.createNewFile();

        File file3 = new File("SoM.txt");
        file3.createNewFile();

        File file4 = new File("SoE.txt");
        file4.createNewFile();

        File file5 = new File("SoPP.txt");
        file5.createNewFile();

        File file6 = new File("SoB.txt");
        file6.createNewFile();

        File file7 = new File("IDs.txt");
        file7.createNewFile();

        PrintWriter p = new PrintWriter(new FileOutputStream(file));
       
        PrintWriter p1 = new PrintWriter(new FileOutputStream(file1));
       
        PrintWriter p2 = new PrintWriter(new FileOutputStream(file2));
    
        PrintWriter p3 = new PrintWriter(new FileOutputStream(file3));

        PrintWriter p4 = new PrintWriter(new FileOutputStream(file4));

        PrintWriter p5 = new PrintWriter(new FileOutputStream(file5));
   
        PrintWriter p6 = new PrintWriter(new FileOutputStream(file6));

        PrintWriter p7 = new PrintWriter(new FileOutputStream(file7));


        

        int input = 0;
        while (input != 8) {
            System.out.println("1. View all SENg students");
            System.out.println("2. View all SST students");
            System.out.println("3. View all SHSS students");
            System.out.println("4. View all SoM students");
            System.out.println("5. View all SoE students");
            System.out.println("6. View all SoPP students");
            System.out.println("7. View all SoB students");
            System.out.println("8. Quit");

            Scanner in = new Scanner(System.in);
            input = in.nextInt();

            if (input == 1) {
                System.out.println(" The list of SENG students:");
                System.out.println(seng);
            } else if (input == 2) {
                System.out.println(" The list of STT students:");
                System.out.println(sst);
            } else if (input == 3) {
                System.out.println(" The list of SHSS students:");
                System.out.println(shss);
            } else if (input == 4) {
                System.out.println(" The list of SoM students:");
                System.out.println(med);
            } else if (input == 5) {
                System.out.println(" The list of SoE students:");
                System.out.println(edu);

            } else if (input == 6) {
                System.out.println(" The list of SoPP students:");
                System.out.println(pol);

            } else if (input == 7) {
                System.out.println(" The list of SoB students:");
                System.out.println(bis);

            } else {
                p.println(seng);
                p.close();

                p1.println(sst);
                p1.close();

                p2.println(shss);
                p2.close();

                p3.println(med);
                p3.close();

                p4.println(edu);
                p4.close();

                p5.println(pol);
                p5.close();

                p6.println(bis);
                p6.close();

                p7.println(tape);
                p7.close();

                break;
            }

        }
    }

}
