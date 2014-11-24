/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.studentstore;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author 1GHAHREMANZA
 */
public class StudentStoreIO {

    static Scanner input = new Scanner(System.in);
    static RandomAccessFile file;
    static boolean closed;
    final static int FILE_SIZE = 93;

    public static void main(String args[]) throws Exception {

        openStore();

        System.out.println("Creating Class Records");
        StudentRecord aryan = new StudentRecord();

        aryan.setFirstName("Aryan");
        aryan.setLastName("Ghahremanzadeh");
        aryan.setOEN(289345768);
        aryan.setFileRecordID(0);
        aryan.setAverage(99);
        aryan.setIEP(true);
        aryan = writeStudentRecord(aryan);

        System.out.println("RECORD SIZE: " + file.length());

        StudentRecord farjaad = new StudentRecord();
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setOEN(289345768);
        farjaad.setFileRecordID(1);
        farjaad = writeStudentRecord(farjaad);
        farjaad.setAverage(53);
        farjaad.setIEP(false);
        System.out.println("RECORD SIZE: " + file.length());

        displayMenu();
        closeStore();
    }

    public static void openStore() throws Exception {
        if (file == null || closed == true) {
            file = new RandomAccessFile("student_info.txt", "rw");
        }
    }

    public static void closeStore() throws Exception {
        closed = true;
        file.close();
    }

    public static StudentRecord writeStudentRecord(StudentRecord record) throws Exception {

        if (record.getFileRecordID() == -1) {
            file.seek(file.length());
            record.setFileRecordID(file.length() / FILE_SIZE);
        } else {
            file.seek(record.getFileRecordID() * FILE_SIZE);
        }
        file.writeChars(record.getFirstName());
        file.writeChars(record.getLastName());
        file.writeInt(record.getOEN());
        file.writeDouble(record.getAverage());
        return record;
    }

    public static void displayMenu() throws Exception {
        System.out.println("Welcome to Student Store");
        boolean invalidChoice = false;
        boolean exitProgram = false;
        do {
            System.out.println("Menu: Press 1 to add to file, Press 2 to read the file, Press 3 to update a record, Press 4 to quit.");
            System.out.println("Enter your choice here: ");
            try {
                int userChoice = Integer.parseInt(input.nextLine());
                switch (userChoice) {
                    case 1:
                        writeStudentRecord(addStudent());
                        break;
                    case 2:

                        do {
                            invalidChoice = false;
                            try {
                                System.out.println("Would you like to read one record or the entire file? (1 - one record, 2 - all records)");
                                int choice = Integer.parseInt(input.nextLine());
                                switch (choice) {
                                    case 1:
                                        System.out.println("Enter the file ID you would like to see: ");
                                        int recordId = Integer.parseInt(input.nextLine());
                                        if (recordId > 0 && recordId <= (file.length() / FILE_SIZE)) {
                                            readRecord(recordId);
                                        } else {
                                            System.out.println("Invalid file ID, try again");
                                            invalidChoice = true;
                                        }
                                        break;
                                    case 2:
                                        displayAllRecord();
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                        invalidChoice = true;
                                }
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please input an integer");
                                invalidChoice = true;
                            }
                        } while (invalidChoice);
                        break;

                    case 3:
                        invalidChoice = false;
                        do {

                            System.out.println("Enter the file id you would like to edit");
                            int recordId = Integer.parseInt(input.nextLine());
                            if (recordId > 0 && recordId <= (file.length() / FILE_SIZE)) {
                                writeStudentRecord(updateStudent(recordId));
                            } else {
                                System.out.println("Invalid file ID, try again");
                                invalidChoice = true;
                            }
                            break;
                        } while (invalidChoice);
                    case 4:
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Invalid Choice, please select in the range of 1-4");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
            } catch (FileNotFoundException fnf) {
                System.out.println("File could not be found");
            } catch (Exception e) {
                System.out.println("Error, please try again");
            }
        } while (!exitProgram);
    }

    public static StudentRecord readRecord(int recordId) throws IOException {
        file.seek((recordId - 1) * FILE_SIZE);
        StudentRecord s = new StudentRecord();

        char firstName[] = new char[20];
        for (int i = 0; i < 20; i++) {
            firstName[i] = file.readChar();
        }

        s.setFirstName(new String(firstName));

        char lastName[] = new char[20];
        for (int i = 0; i < 20; i++) {
            lastName[i] = file.readChar();
        }

        s.setLastName(new String(lastName));
        s.setOEN(file.readInt());
        s.setAverage(file.readDouble());

        System.out.println(s.toString());
        return s;
    }

    public static void displayAllRecord() throws IOException {
        long numRecords = file.length() / FILE_SIZE;
        StudentRecord s;
        for (int i = 0; i < numRecords; i++) {
            s = readRecord(i + 1);
        }

    }

    public static StudentRecord updateStudent(int recordId) throws Exception {

        StudentRecord s = readRecord(recordId);
        boolean invalidChoice;
        do {
            invalidChoice = false;
            try {
                System.out.println("Enter new first name or [k]eep current first name: [" + s.getFirstName() + "]");
                String firstName = input.nextLine();
                if (!"k".equalsIgnoreCase(firstName)) {
                    s.setLastName(firstName);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter new last name or [k]eep current last name: [" + s.getLastName() + "]");
                String lastName = input.nextLine();
                if (!"k".equalsIgnoreCase(lastName)) {
                    s.setLastName(lastName);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter new OEN or [k]eep current OEN: [" + s.getOEN() + "] ");
                String OEN = input.nextLine();
                if (!"k".equalsIgnoreCase(OEN)) {
                    s.setOEN(Integer.parseInt(OEN));
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter new student average or [k]eep current average: [" + s.getAverage() + "]");
                String average = input.nextLine();
                if (!"k".equalsIgnoreCase(average)) {
                    s.setAverage(Double.parseDouble(average));
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter if student has IEP (true or false) or [k]eep current: [" + s.isIEP() + "]");
                String IEP = input.nextLine();
                if (!"k".equalsIgnoreCase(IEP)) {
                    if (IEP.equalsIgnoreCase("true")) {
                        s.setIEP(true);
                    } else if (IEP.equalsIgnoreCase("false")) {
                        s.setIEP(false);
                    } else {
                        System.out.println("Please enter true or false");
                        invalidChoice = true;
                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter true or false");
                invalidChoice = true;
            }

        } while (invalidChoice);

        return s;

    }

    public static StudentRecord addStudent() throws Exception {
        StudentRecord s = new StudentRecord();
        boolean invalidChoice;
        do {
            invalidChoice = false;
            try {
                System.out.println("Enter first name: ");
                s.setFirstName(input.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }

        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter last name: ");
                s.setLastName(input.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }

        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter OEN: ");
                s.setOEN(Integer.parseInt(input.nextLine()));
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }

        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter student average: ");
                s.setAverage(Double.parseDouble(input.nextLine()));
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do {
            invalidChoice = false;
            try {
                System.out.println("Enter if student has IEP (true or false): ");
                String IEP = input.nextLine();
                if (IEP.equalsIgnoreCase("true")) {
                    s.setIEP(true);
                } else if (IEP.equalsIgnoreCase("false")) {
                    s.setIEP(false);
                } else {
                    System.out.println("Please enter true or false");
                    invalidChoice = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter true or false");
                invalidChoice = true;
            }
        } while (invalidChoice);

        s.setFileRecordID(-1);
        return s;

    }

}
