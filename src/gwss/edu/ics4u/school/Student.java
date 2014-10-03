
package gwss.edu.ics4u.school;

/**
 *
 *
 * Name: Aryan Ghahremanzadeh 
 * Date: October 2, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This creates the student object and its properties.  
 */
public class Student {
    
    public static final int GENDER_TYPE_UNKNOWN= 0;
    public static final int GENDER_TYPE_MALE = 1;
    public static final int GENDER_TYPE_FEMALE = 2;
    
    
    private int OEN;
    private String firstName;
    private String lastName;
    private School School;
    private String secretComment;
    private int height; //in cm
    private int gender;
    private boolean IEP;
    private double average;
    
    
    
    public Student() {
        this.IEP = false;
        System.out.println(" Student Created");
    }
    
    public Student(int OEN, String firstName, String lastName, School School, int studentId, int height, int gender, boolean IEP, double average, String secretComment) {
        this( OEN,  firstName,  lastName,  School);
        this.height = height;
        this.gender = gender;
        this.IEP = IEP;
        this.average = average;
        this.secretComment = secretComment;
        
    }

    public Student(int OEN, String firstName, String lastName, School School) {
        this();
        this.OEN = OEN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.School = School;
    }

    public int getOEN() {
        return OEN;
    }

    public void setOEN(int OEN) {
        if (OEN > 99999999 && OEN < 1000000000) {
            this.OEN = OEN;
        } else {
            System.out.println("Invalid OEN");
        }
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName!= null && firstName.length() > 1)
            this.firstName = firstName;
        else
            System.out.println("Invalid first name. "); 
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName!= null && lastName.length() > 1)
            this.lastName = lastName;
        else
            System.out.println("Invalid last name. "); 
    }

    public School getSchool() {
        return School;
    }

    public void setSchool(School School) {
        if (School != null) {
            this.School = School;
        } else {
            System.out.println("Invalid School. ");
        }
    }

    private String getSecretComment() {
        return secretComment;
    }

    public void setSecretComment(String secretComment) {
            this.secretComment = secretComment;

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 40 || height == 40 ) {
            this.height = height;
        }
        else
            System.out.println("Invalid Height. ");
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        if (gender >= 0 && gender <= 2)
            this.gender = gender;
        else 
            System.out.println("Invalid Gender");
    }

    public boolean isIEP() {
        return IEP;
    }

    public void setIEP(boolean IEP) {
        this.IEP = IEP;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        if (average >= 0 && average <= 100 )
            this.average = average;
        else 
            System.out.println("Invalid Average");
    }

    public boolean isValid() {
        if (OEN < 99999999 || OEN > 1000000000 || firstName == null || firstName.length() < 2 || lastName == null || lastName.length() < 2 ||  School == null) {
            return false;
        }
        return true;
    }
    
    
    public boolean verifyOEN (int OEN) {
        if (Integer.toString(OEN).matches(Integer.toString(this.OEN))) {
            return true;
        } else 
            return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public String getGenderName() {
        switch (this.gender) {
            case GENDER_TYPE_UNKNOWN:
                return "Unknown";
            case GENDER_TYPE_MALE:
                return "Male";
            case GENDER_TYPE_FEMALE:
                return "Female";
            default:
                return "Invalid";
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.OEN != other.OEN) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "---------------------------------" + 
                "\n\t OEN= " + OEN + 
                "\n\t First Name= " + firstName + 
                "\n\t Last Name= " + lastName +                 
                "\n\t External comments= " + secretComment + 
                "\n\t Height= " + height + 
                "\n\t Gender= "  + getGenderName() + 
                "\n\t IEP= " + IEP + 
                "\n\t Average= " + average +
                "\n\t School= " + School  ;
    }
    

    
    
}
