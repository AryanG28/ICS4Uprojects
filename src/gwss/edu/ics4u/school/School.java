/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.school;

import gwss.edu.ics4u.account.Account;
import java.util.ArrayList;

/**
 *
 * @author 1GHAHREMANZA
 */
public class School {

    public static final int SCHOOL_TYPE_UNKNOWN = -1;
    public static final int SCHOOL_TYPE_PRIVATE = 1;
    public static final int SCHOOL_TYPE_ELEMENTARY = 2;
    public static final int SCHOOL_TYPE_SECONDARY = 3;

    private int schoolId;
    private String schoolName;
    private String address;
    private boolean hasSummerSchool;
    private int yearOpened;
    private int schoolType;
    private double budgetBalance;
    private ArrayList<Student> students;

    public School() {
        this.schoolType = SCHOOL_TYPE_UNKNOWN;
        this.hasSummerSchool = false;
        this.students = new ArrayList<>();
        System.out.println(" Object Created.");
    }

    public School(int schoolId, String schoolName, String address, boolean hasSummerSchool, int dateOpened, int schoolType, double budgetBalance) {
        this();
        this.address = address;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolType = schoolType;
        this.hasSummerSchool = hasSummerSchool;
        this.yearOpened = dateOpened;
        this.budgetBalance = budgetBalance;

    }

    public School(int schoolId) {
        this();
        this.schoolId = schoolId;
    }

    public School(int schoolId, String schoolName, int schoolType) {
        this();
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolType = schoolType;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        if (schoolId > 0) {
            this.schoolId = schoolId;
        } else {
            System.out.println("Invalid School ID");
        }

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        if (schoolName != null && schoolName.length() > 2) {
            this.schoolName = schoolName;
        } else {
            System.out.println("Cannot set school Name");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && address.length() > 5) {
            this.address = address;
        } else {
            System.out.println("Invalid Address");
        }
    }

    public boolean getHasSummerSchool() {
        return hasSummerSchool;
    }

    public void setHasSummerSchool(boolean hasSummerSchool) {
        this.hasSummerSchool = hasSummerSchool;
    }

    public int getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(int yearOpened) {
        if (yearOpened > 1800 || yearOpened == 0) {
            this.yearOpened = yearOpened;
        } else {
            System.out.println("Invalid year opened");
        }
    }

    public int getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(int schoolType) {
        if (schoolType >= 0 && schoolType < 4) {
            this.schoolType = schoolType;
        } else {
            System.out.println("Invalid school type");
        }

    }

    public String getSchoolTypeName() {
        switch (this.schoolType) {
            case SCHOOL_TYPE_UNKNOWN:
                return "Unknown";
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

    public int numberOfStudents() {
        return this.students.size();
    }

    private double getBudgetBalance() {
        return budgetBalance;
    }

    public void setBudgetBalance(double budgetBalance) {
        if (budgetBalance >= 0) {
            this.budgetBalance = budgetBalance;
        } else {
            System.out.println("Invalid Budget Balance");
        }
    }

//    public Student getStudent(int OEN) {
//        Student student = null;
//        if (this.students.size() > 0) {
//            for (Student s : this.students) {
//                if (OEN == s.getOEN()) {
//                    student = s;
//                }
//            }
//        }
//        return student;
//    }
    public void addStudent(Student student) {
        boolean addstudent = true;
        if (student == null) {
            System.out.println("Can't add a NULL student to a school.");
            addstudent = false;
        } else if (student.isValid() == false) {
            System.out.println("Student is not valid.");
            addstudent = false;
        } else if (students.size() > 0) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).equals(student)) {
                    System.out.println("Addition failed. Student already exists.");
                    addstudent = false;
                    break;
                }
            }
        }
        if (addstudent == true) {
            this.students.add(student);
            System.out.println("Student added");
        }

    }

    public void removeStudent(int OEN) {
        if (this.students.size() > 0) {
            for (Student student : this.students) {
                int s = student.getOEN();
                if (OEN == s) {
                    System.out.println("Student removed");
                    students.remove(student);
                    return;
                }

            }
            System.out.println("Student cannot be found");
        } else {
            System.out.println("Student does not exist, cannot be removed.");
        }
    }

    public void removeStudent(Student student) {
        if (student == null) {
            System.out.println("Student is null, cannot be removed.");
        } else if (this.students.size() > 0) {
            if (students.contains(student)) {
                students.remove(student);
                System.out.println("Student removed");

            } else {
                System.out.println("Student does not exist, cannot be removed.");
            }
        } else {
            System.out.println("Student does not exist, cannot be removed.");
        }

    }

    public void getStudent(int OEN) {
        if (this.students.size() > 0) {
            for (Student student : this.students) {
                int s = student.getOEN();
                if (OEN == s) {
                    System.out.println("Student found");
                    System.out.println(student.toString());
                    return;
                }
            }
            System.out.println("Student cannot be found.");
        } else {
            System.out.println("Student cannot be found");
        }
    }

    public void getStudent(Student student) {
        if (student == null) {
            System.out.println("Student is null, cannot be found");
        } else if (this.students.size() > 0) {
            if (students.contains(student)) {
                System.out.println("Student found.");
                System.out.println(student.toString());
            }
            System.out.println("Student cannot be found.");
        } else {
            System.out.println("Student cannot be found.");
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj
    ) {
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
        if (schoolId <= 0 || schoolName == null || schoolName.length() < 3) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""
                + "\n\t School Id= " + schoolId
                + "\n\t School Name= " + schoolName
                + "\n\t Address= " + address
                + "\n\t Summer School= " + hasSummerSchool
                + "\n\t Year Opened= " + yearOpened
                + "\n\t School Type= " + getSchoolTypeName()
                + "\n\t Budget Balance= " + budgetBalance;
    }

}
