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
        Student kael = new Student();
        School garthWebb = new School();
        kael.setAverage(94);
        kael.setOEN(169435457);
        kael.setFirstName("Farjaad");
        kael.setLastName("Rawasia");
        kael.setStudentId(124);
        kael.setSchool(garthWebb);
        kael.toString();
        
        Student farjaad = new Student();

        farjaad.setAverage(94);
        farjaad.setOEN(1694354567);
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setStudentId(123);
        farjaad.setSchool(garthWebb);
        farjaad.toString();

        System.out.println("---------------------------");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.addStudent(farjaad);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        garthWebb.addStudent(kael);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
       // garthWebb.removeStudent(farjaad);
        //garthWebb.removeStudent(16832567);
       // System.out.println("# Students After: " + garthWebb.numberOfStudents());
         garthWebb.getStudent(kael);
    }

}
