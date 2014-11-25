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

    // class variables
    public static Scanner input = new Scanner(System.in);
    public static RandomAccessFile file;
    public static boolean closed;
    public final static int FILE_SIZE = 93;

    public static void main(String args[]) throws Exception {
        //opens store
        openStore();
        //Creates student records
        System.out.println("Creating Student Records");
        StudentRecord aryan = new StudentRecord();
        //Creates and writes a default student recrod to the file
        aryan.setFirstName("Aryan");
        aryan.setLastName("Ghahremanzadeh");
        aryan.setOEN(289345768);
        aryan.setFileRecordID(0);
        aryan.setAverage(99);
        aryan.setIEP(true);
        aryan = writeStudentRecord(aryan);

        System.out.println("RECORD SIZE: " + file.length());
        // Creates and writes another default student record to the file
        StudentRecord farjaad = new StudentRecord();
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setOEN(289345768);
        farjaad.setFileRecordID(1);
        farjaad = writeStudentRecord(farjaad);
        farjaad.setAverage(53);
        farjaad.setIEP(false);
        System.out.println("RECORD SIZE: " + file.length());
        //Calls display menu where choices are displayed
        displayMenu();
        //Closes file
        closeStore();
    }

    public static void openStore() throws Exception {
        if (file == null || closed == true) { //creates file when file is closed or null
            file = new RandomAccessFile("student_info.txt", "rw");
        }
    }

    //this method closes the file
    public static void closeStore() throws Exception {
        closed = true; 
        file.close();
    }

    public static StudentRecord writeStudentRecord(StudentRecord record) throws Exception {

        if (record.getFileRecordID() == -1) { //if file id is -1 it creates a file id at end of file
            file.seek(file.length());
            record.setFileRecordID(file.length() / FILE_SIZE);
        } else { // if file id is not -1 it writes over the existing file id
            file.seek(record.getFileRecordID() * FILE_SIZE);
        }
        
        file.writeChars(record.getFirstName()); //writes the firstname
        file.writeChars(record.getLastName()); //writes the lastname
        file.writeInt(record.getOEN()); //writes the oen
        file.writeDouble(record.getAverage()); //writes the average
        file.writeBoolean(record.getIEP()); //writes the boolean
        
        return record; //returns the record it writes
    }

    public static void displayMenu() throws Exception {
        System.out.println("Welcome to Student Store");
        boolean invalidChoice = false;
        boolean exitProgram = false;
        
        do { // displays the menu once and keeps displaying until user wants to exit. 
            System.out.println("Menu: Press 1 to add to file, Press 2 to read the file, Press 3 to update a record, Press 4 to quit.");
            System.out.println("Enter your choice here: ");
            try { 
                int userChoice = Integer.parseInt(input.nextLine()); //gets user Choice
                
                switch (userChoice) { //goes to different sections of program dependent on user choice
                    case 1: //to add student
                        writeStudentRecord(addStudent());
                        break;
                    case 2: //to read the file
                        do {
                            invalidChoice = false;
                            try {
                                System.out.println("Would you like to read one record or the entire file? (1 - one record, 2 - all records, 0 to quit) ");
                                int choice = Integer.parseInt(input.nextLine()); //gets user choice
                                switch (choice) {
                                    case 0: //if choice is 0 it does nothing
                                        break;
                                    case 1: //if choice is 1 it asks user for file number
                                        System.out.println("Enter the file ID you would like to see: ");
                                        int recordId = Integer.parseInt(input.nextLine());
                                        if (recordId > 0 && recordId <= (file.length() / FILE_SIZE)) { //if file id is valid it reads the record
                                            readRecord(recordId);
                                        } else { //if file id is not valid, invalidChoice becomes true and it will loop again 
                                            System.out.println("Invalid file ID, try again");
                                            invalidChoice = true;
                                        }
                                        break;
                                    case 2: // if choice is 2 it will dipslay all records
                                        displayAllRecord();
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                        invalidChoice = true;
                                }
                            } catch (NumberFormatException nfe) { //if an integer is not inputted at any point it will catch the error and loop
                                System.out.println("Please input an integer");
                                invalidChoice = true;
                            }
                        } while (invalidChoice);
                        break;

                    case 3: //updates record
                        invalidChoice = false;
                        do {

                            System.out.println("Enter the file id you would like to edit");
                            int recordId = Integer.parseInt(input.nextLine()); //file id user wants to edit
                            if (recordId > 0 && recordId <= (file.length() / FILE_SIZE)) { //checks if file id exists and if it does it calls update file
                                writeStudentRecord(updateStudent(recordId));
                            } else { //if it doesnt exist it asks to try again
                                System.out.println("Invalid file ID, try again");
                                invalidChoice = true;
                            }
                            break;
                        } while (invalidChoice);
                    case 4: //exits program
                        exitProgram = true;
                        break;
                    default: //if its an invalid choice that is not in the right range of numbers
                        System.out.println("Invalid Choice, please select in the range of 1-4");
                        break;
                }
            } catch (NumberFormatException nfe) { //Catches exception if user inputs String instead of number
                System.out.println("Please input an integer");
            } catch (FileNotFoundException fnf) { //if file is not found
                System.out.println("File could not be found");
            } catch (Exception e) { //any other unexpected error
                System.out.println("Error, please try again");
            }
        } while (!exitProgram); //exits program when user chooses to
    }

    public static StudentRecord readRecord(int recordId) throws IOException {
        file.seek((recordId - 1) * FILE_SIZE);//goes to start of record at position given
        StudentRecord s = new StudentRecord();

        char firstName[] = new char[20]; // reads characters in firstname string
        for (int i = 0; i < 20; i++) {
            firstName[i] = file.readChar();
        }

        s.setFirstName(new String(firstName)); //sets the first name

        char lastName[] = new char[20]; //reads characters in last name string
        for (int i = 0; i < 20; i++) {
            lastName[i] = file.readChar();
        }

        s.setLastName(new String(lastName)); //sets the last name 
        s.setOEN(file.readInt()); //sets the oen
        s.setAverage(file.readDouble()); //sets the average
        s.setIEP(file.readBoolean()); //sets the iep

        System.out.println(s.toString()); //prints it out
        return s;
    }

    public static void displayAllRecord() throws IOException { //method that goes through every id and reads it
        long numRecords = file.length() / FILE_SIZE;
        for (int i = 0; i < numRecords; i++) { //iterates through and prints each record
            readRecord(i + 1);
        }

    }

    public static StudentRecord updateStudent(int recordId) throws Exception {

        StudentRecord s = readRecord(recordId);
        boolean invalidChoice;

                System.out.println("Enter new first name or [k]eep current first name: [" + s.getFirstName() + "]");
                String firstName = input.nextLine();
                if (!"k".equalsIgnoreCase(firstName)) {
                    s.setLastName(firstName);
                }

                System.out.println("Enter new last name or [k]eep current last name: [" + s.getLastName() + "]");
                String lastName = input.nextLine();
                if (!"k".equalsIgnoreCase(lastName)) {
                    s.setLastName(lastName);
                }

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
                System.out.println("Enter if student has IEP (true or false) or [k]eep current: [" + s.getIEP() + "]");
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

                System.out.println("Enter first name: ");
                s.setFirstName(input.nextLine());

                System.out.println("Enter last name: ");
                s.setLastName(input.nextLine());


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
