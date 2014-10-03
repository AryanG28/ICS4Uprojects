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
        kael.setAverage(4);
        kael.setOEN(1694357);
        kael.setFirstName("Kael");
        kael.setLastName("Bosland");
        kael.setStudentId(124);
        kael.setSchool(garthWebb);
        kael.toString();
        
        Student farjaad = new Student();

        farjaad.setAverage(94);
        farjaad.setOEN(169435667);
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setStudentId(123);
        farjaad.setSchool(garthWebb);
        farjaad.toString();

        Student ryan = new Student();

        ryan.setAverage(94);
        ryan.setOEN(169455667);
        ryan.setFirstName("Ryan");
        ryan.setLastName("Mcdonald");
        ryan.setStudentId(125);
        ryan.setSchool(garthWebb);
        ryan.toString();

        
        Student farzan = null;
        
        System.out.println("---------------------------");
        
        //adds object to the list
        System.out.println("Test Case #1: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.addStudent(farjaad);
        garthWebb.addStudent(ryan);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        //adding duplicate object to list
        System.out.println("Test Case #2: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.addStudent(farjaad);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        //adding invalid student to list
        System.out.println("Test Case #3: ");
        garthWebb.addStudent(kael);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        //adding null object to list**********
        System.out.println("Test Case #4: ");
        garthWebb.addStudent(farzan);
        
        //removing object from the list
        System.out.println("Test Case #5: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.removeStudent(farjaad);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        //removing object that does not exist in list
        System.out.println("Test Case #6: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.removeStudent(farjaad); // need message
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        //removing null object
        System.out.println("Test Case #7: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.removeStudent(farzan); // need message
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        //gets object from the list
        System.out.println("Test Case #8: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.getStudent(ryan);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        
        //gets object that does not exist in list
        System.out.println("Test Case #9: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.getStudent(farjaad); // need message
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
        //gets object that does not exist in list
        System.out.println("Test Case #10: ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.getStudent(farzan); // need message
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        
    }

}
