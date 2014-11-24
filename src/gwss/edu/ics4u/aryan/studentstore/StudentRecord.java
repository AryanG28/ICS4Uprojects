package gwss.edu.ics4u.aryan.studentstore;

import gwss.edu.ics4u.school.*;

/**
 *
 *
 * Name: Aryan Ghahremanzadeh Date: October 2, 2014 Version: v0.1 Teacher:
 * Mr.Muir Description: This creates the student object and its properties.
 */
public class StudentRecord {

    public static final int GENDER_TYPE_UNKNOWN = 0;
    public static final int GENDER_TYPE_MALE = 1;
    public static final int GENDER_TYPE_FEMALE = 2;

    private long fileRecordID = -1;
    private int OEN;
    private String firstName;
    private String lastName;
    private School School;
    private String secretComment;
    private int height; //in cm
    private int gender;
    private boolean IEP;
    private double average;

    public StudentRecord() {

    }

    public long getFileRecordID() {
        return fileRecordID;
    }

    public void setFileRecordID(long fileRecordID) {
        this.fileRecordID = fileRecordID;
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
        StringBuilder temp = new StringBuilder();

        if (firstName != null) {
            temp.append(firstName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(20);
        this.firstName = temp.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        StringBuilder temp = new StringBuilder();

        if (lastName != null) {
            temp.append(lastName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(20);
        this.lastName = temp.toString();
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 40 || height == 40) {
            this.height = height;
        } else {
            System.out.println("Invalid Height. ");
        }
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        if (gender >= 0 && gender <= 2) {
            this.gender = gender;
        } else {
            System.out.println("Invalid Gender");
        }
    }

    public boolean getIEP() {
        return IEP;
    }

    public void setIEP(boolean IEP) {
        this.IEP = IEP;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        if (average >= 0 && average <= 100) {
            this.average = average;
        } else {
            System.out.println("Invalid Average");
        }
    }

    public boolean isValid() {
        if (OEN < 99999999 || OEN > 1000000000 || firstName == null || firstName.length() < 2 || lastName == null || lastName.length() < 2 || School == null) {
            return false;
        }
        return true;
    }

    public boolean verifyOEN(int OEN) {
        if (Integer.toString(OEN).matches(Integer.toString(this.OEN))) {
            return true;
        } else {
            return false;
        }
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
        final StudentRecord other = (StudentRecord) obj;
        if (this.OEN != other.OEN) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "---------------------------------"
                + "\n\t OEN= " + OEN
                + "\n\t First Name= " + firstName
                + "\n\t Last Name= " + lastName
                + "\n\t Average= " + average
             //   + "\n\t External comments= " + secretComment
             //   + "\n\t Height= " + height
              //  + "\n\t Gender= " + getGenderName()
                + "\n\t IEP= " + IEP;
              //  + "\n\t School= " + School;
    }

}
