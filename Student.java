/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 *
 * @author Adilbek Nurmakov
 */
public class Student implements Comparable<Student> {

    private int dorm;
    private int id;
    private String name;
    private String school;

    public Student() {
        dorm = 0;
        id = 0;
        name = null;
    }

    public Student(int dr, int id, String name) {
        this.dorm = dr;
        this.name = name;
        this.id = id;
    }

    /**
     * method for getting the name of student
     *
     * @return the student name
     */
    public int getDorm() {
        return dorm;
    }

    /**
     * method for getting the ID of student
     *
     * @return the student ID
     */
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public void setDorm(int dorm) {
        this.dorm = dorm;
    }

    /**
     * method for setting the ID of student
     *
     * @param id represents the ID of student in list sets the student name to
     * variable id
     */
    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return " Student's ID:" + id + " dormitory block " + dorm + " school " + name;
    }

    public boolean Equals(Object obj) {
        if (obj instanceof Student) {
            Student sobj = (Student) obj;
            return id == sobj.id && name.equals(sobj.name);
        }
        return false;
    }

    @Override
    public int compareTo(Student o) {

        if (this.getID() > o.getID()) {
            return 1;
        } else if (this.getID() < o.getID()) {
            return -1;
        } else {
            return 0;
        }
    }

}
