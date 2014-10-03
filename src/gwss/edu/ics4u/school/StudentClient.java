
package gwss.edu.ics4u.school;

/**
 **
 * Name: Aryan Ghahremanzadeh 
 * Date: October 2, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This client allows you to set and add students to the student list
 * and create and set different properties for each. 
 */
public class StudentClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Student kael = new Student(); // creates student kael
        School garthWebb = new School(); //creates School
        
        // Creates student with invalid OEN and height
        kael.setAverage(4);
        kael.setOEN(1694357);
        kael.setFirstName("Kael");
        kael.setLastName("Bosland");
        kael.setSchool(garthWebb);
        kael.toString();
        kael.setHeight(-4);
        
        //Creates valid student
        Student farjaad = new Student();
        
        farjaad.setAverage(94);
        farjaad.setOEN(169435667);
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setSchool(garthWebb);
        farjaad.toString();

        //Creates valid student
        Student ryan = new Student();

        ryan.setAverage(94);
        ryan.setOEN(163455667);
        ryan.setFirstName("Ryan");
        ryan.setLastName("Mcdonald");
        ryan.setSchool(garthWebb);
        ryan.toString();
        
        //Creates valid student
        Student scott = new Student();

        scott.setAverage(64);
        scott.setOEN(139455467);
        scott.setFirstName("Scott");
        scott.setLastName("Sandre");
        scott.setSchool(garthWebb);
        scott.toString();
        
        // Creates valid student with same OEN as Scott
        Student josh = new Student();

        josh.setAverage(54);
        josh.setOEN(139455467);
        josh.setFirstName("Josh");
        josh.setLastName("Fitz");
        josh.setSchool(garthWebb);
        josh.toString();

        // Creates null student 
        Student farzan = null;
        
        
        System.out.println("---------------------------");
        
        //Tests to see if objects can get added successfully to list
        System.out.println("Test Case #1: ");
        System.out.println("Tests to see if objects can get added successfully to list");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents()); 
        garthWebb.addStudent(farjaad);
        garthWebb.addStudent(ryan);
        garthWebb.addStudent(scott);
        System.out.println("# Students After: " + garthWebb.numberOfStudents()); 
        System.out.println("");
        
        //adding duplicate object to list
        System.out.println("Test Case #2: ");
        System.out.println("Tests to see if student thats added can be added again. ");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents()); 
        garthWebb.addStudent(farjaad);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        System.out.println("");
        
        //adding invalid object to list
        System.out.println("Test Case #3: ");
        System.out.println("Tests to see if possible to add invalid student.");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents()); 
        garthWebb.addStudent(kael);
        System.out.println("# Students After: " + garthWebb.numberOfStudents()); 
        System.out.println("");
        
        //adding null object to list
        System.out.println("Test Case #4: ");
        System.out.println("Tests to see if possible to add NULL students.");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents()); 
        garthWebb.addStudent(farzan);
        System.out.println("# Students After: " + garthWebb.numberOfStudents()); 
        System.out.println("");
        
        //removing object from the list
        System.out.println("Test Case #5: ");
        System.out.println("Tests to remove students from list.");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.removeStudent(farjaad);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        System.out.println("");
        
        //removing object that does not exist in list
        System.out.println("Test Case #6: ");
        System.out.println("Tests to remove students from list that do not exist.");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.removeStudent(farjaad); // need message
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        System.out.println("");
        
        //removing null object
        System.out.println("Test Case #7: ");
        System.out.println("Tests to remove students from list that are null.");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.removeStudent(farzan); // need message
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        System.out.println("");
        
        //removing object using primary key(OEN)
        System.out.println("Test Case #8: ");
        System.out.println("Tests to remove students from list using OEN.");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.removeStudent(139455467);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        System.out.println("");
        
        //gets object from the list
        System.out.println("Test Case #9: ");
        System.out.println("Tests to get students from list.");
        garthWebb.getStudent(ryan);
        System.out.println("");
        
        //gets object that does not exist in list
        System.out.println("Test Case #10: ");
        System.out.println("Tests to get students from list that do not exist.");
        garthWebb.getStudent(farjaad); 
        System.out.println("");
        
        //gets object that is null
        System.out.println("Test Case #11: ");
        System.out.println("Tests to get students from list that is null.");
        garthWebb.getStudent(farzan); 
        System.out.println("");
        
        //gets object from the list using OEN
        garthWebb.addStudent(scott);
        System.out.println("Test Case #12: ");
        System.out.println("Tests to get students from list using OEN.");
        garthWebb.getStudent(139455467);
        System.out.println("");
        
        //Adding students with the same OEN
        System.out.println("Test Case #13: ");
        System.out.println("Tests to add students to the list with the same OEN.");
        System.out.println("# Students Before: " + garthWebb.numberOfStudents());
        garthWebb.addStudent(josh);
        System.out.println("# Students After: " + garthWebb.numberOfStudents());
        System.out.println("");
        
    }

}
