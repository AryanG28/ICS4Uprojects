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
public class StudentClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFirstName(" Fred ");
        student1.setLastName(" McGriff ");
        student1.setOEN(12343234);
      //  student1.setNetworkPassword (" wasd ");
        student1.toString();
        //String string1 = new String();
        //String string2 = new String();
        //String string3 = new String("Hello World");
        //Student student1 = new Student();
        //Student student2 = new Student("Dan");
        //Student student3 = new Student("Fred");

    }
}
