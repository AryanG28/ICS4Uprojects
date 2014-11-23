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
    final static int FILE_SIZE = 92;

    public static void main(String args[]) throws Exception {

        openStore();

        System.out.println("Creating Class Records");
        StudentRecord aryan = new StudentRecord();

        aryan.setFirstName("Aryan");
        aryan.setLastName("Ghahremanzadeh");
        aryan.setOEN(289345768);
        aryan.setFileRecordID(0);
        aryan.setAverage(99);
        aryan = writeStudentRecord(aryan);

        System.out.println("RECORD SIZE: " + file.length());

        StudentRecord farjaad = new StudentRecord();
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setOEN(289345768);
        farjaad.setFileRecordID(1);
        farjaad = writeStudentRecord(farjaad);
        farjaad.setAverage(53);
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
                                        displayRecord();
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

    public static void displayRecord() throws IOException {
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
                System.out.println("Enter OEN: ");
                s.setOEN(Integer.parseInt(input.nextLine()));
                System.out.println("Enter new first name: [" + s.getFirstName() + "]");
                s.setFirstName(input.nextLine());
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
                System.out.println("Enter new last name: [" + s.getLastName() + "]");
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
                System.out.println("Enter new first name: [" + s.getOEN() + "]");
                s.setOEN(Integer.parseInt(input.nextLine()));
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
                System.out.println("Enter new student average: " + s.getAverage() + "]");
                s.setAverage(Double.parseDouble(input.nextLine()));
            } catch (NumberFormatException nfe) {
                System.out.println("Please input an integer");
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

        s.setFileRecordID(-1);
        return s;

    }

}
