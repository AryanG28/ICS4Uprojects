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
public class School {
    
    public static final int SCHOOL_TYPE_PRIVATE = 1;
    public static final int SCHOOL_TYPE_ELEMENTARY = 2;
    public static final int SCHOOL_TYPE_SECONDARY = 3;
    
    
    private int schoolId;
    private String schoolName;
    private String address;
    private boolean hasSummerSchool;
    private int yearOpened;
    private int schoolType;
    private int numberOfStudents;
    private double budgetBalance;

    public School(int schoolId, String schoolName, String address, boolean hasSummerSchool, int dateOpened, int schoolType, int numberOfStudents, double budgetBalance) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.address = address;
        this.hasSummerSchool = hasSummerSchool;
        this.yearOpened = dateOpened;
        this.schoolType = schoolType;
        this.numberOfStudents = numberOfStudents;
        this.budgetBalance = budgetBalance;
    }

    public School() {
    }

    public School(int schoolId) {
        this.schoolId = schoolId;
    }

    public School(int schoolId, String schoolName, int schoolType) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolType = schoolType;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        if (schoolId > 0)
            this.schoolId = schoolId;
        
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        if (schoolName != null)
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isHasSummerSchool() {
        return hasSummerSchool;
    }

    public void setHasSummerSchool(boolean hasSummerSchool) {
        this.hasSummerSchool = hasSummerSchool;
    }

    public int getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(int yearOpened) {
        this.yearOpened = yearOpened;
    }

    public int getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(int schoolType) {
        if (schoolId > 0)
            this.schoolType = schoolType;
    }
    
    public String getSchoolTypeName() {
        switch (this.schoolType) {
            case SCHOOL_TYPE_PRIVATE: 
                return "Private";
            case SCHOOL_TYPE_ELEMENTARY:
                return "Elementary";
            case SCHOOL_TYPE_SECONDARY:
                return "Secondary";
            default: 
                return "Invalid";                
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        if (numberOfStudents >= 0)
            this.numberOfStudents = numberOfStudents;
    }

    public double getBudgetBalance() {
        return budgetBalance;
    }

    public void setBudgetBalance(double budgetBalance) {
        if (budgetBalance >= 0)
            this.budgetBalance = budgetBalance;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final School other = (School) obj;
        if (this.schoolId != other.schoolId) {
            return false;
        }
        return true;
    }

    public boolean isValid() {
        if (schoolId == 0 || schoolName== null || schoolType ==  0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "School{" + "schoolId=" + schoolId + ", schoolName=" + schoolName + ", address=" + address + ", hasSummerSchool=" + hasSummerSchool + ", yearOpened=" + yearOpened + ", schoolType=" + schoolType + ", numberOfStudents=" + numberOfStudents + ", budgetBalance=" + budgetBalance + '}';
    }
    
}
