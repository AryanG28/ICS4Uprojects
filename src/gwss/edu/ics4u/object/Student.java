/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.object;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Student {

    
    //Object Variables
    private String firstName;
    private String lastName;
    private String networkPassword;
    private int age;
    private int OEN;
    private double average;
    private double height;
    
    public Student() {
        this("Unknown");
        System.out.println("Student Object Created");
        
    }
    
    public Student(String name) {
       System.out.println("Student Object Created " + name );
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNetworkPassword() {
        return networkPassword;
    }

    private void setNetworkPassword(String networkPassword) {
        this.networkPassword = networkPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOEN() {
        return OEN;
    }

    public void setOEN(int OEN) {
        this.OEN = OEN;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", OEN=" + OEN + '}';
    }
    
    
}
