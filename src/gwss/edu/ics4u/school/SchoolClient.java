/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.school;

/**
 *
 * @author 1GHAHREMANZA
 */
public class SchoolClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student farjaad = new Student();
        farjaad.setAverage(94);
        farjaad.setOEN(169432567);
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setStudentId(123);
        farjaad.toString();
        School garthWebb = new School();
        System.out.println("---------------------------");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.addStudent(farjaad);
        garthWebb.addStudent(farjaad);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
    }

}
