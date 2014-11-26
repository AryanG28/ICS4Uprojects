/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.studentstore;

import java.io.*;
import java.util.Scanner;

/**
 * Name: Aryan Ghahremanzadeh 
 * Date: November 25, 2014 Version: v0.1
 * Teacher:Mr.Muir 
 * Description: This asks a user for input and creates and adds
 * student records to a file. User is also able to update the file.
 */
public class StudentStoreIO {

    // class variables
    public static Scanner input = new Scanner(System.in);
    public static RandomAccessFile file;
    public static boolean closed;
    public static final int FILE_SIZE = 99;
    public static final int NAME_FIELD = 20;

    public static void main(String args[]) throws Exception {
        openStore();
        displayMenu();
    }

    public static void openStore() {
        try {
            if (file == null || closed == true) { //creates file when file is closed or null
                file = new RandomAccessFile("student_info.txt", "rw");
                System.out.println("File opened");
                closed = false;
            }
        } catch (FileNotFoundException ex) { //sends message to user if file not found
            System.out.println("File not found, store could not be opened");
        }
    }

    //this method closes the file
    public static void closeStore() {
        try {
            closed = true;
            file.close();
        } catch (IOException ex) { //sends error to user if problem closing the file
            System.out.println("Error closing file");
        } catch (NullPointerException ex) { //sends message to user if file not found and attempts to open store
            System.out.println("File not found, could not close file.");
        }
    }

    public static void displayMenu() {
        //var list
        boolean invalidChoice = false;
        boolean keepGoing = true;

        System.out.println("Welcome to Student Store");

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
                        do { //loops if invalid choice is entered
                            invalidChoice = false;
                            try {
                                System.out.println("Would you like to read one record or the entire file? (1 - one record, 2 - all records, 0 to quit) ");
                                int choice = Integer.parseInt(input.nextLine()); //gets user choice
                                switch (choice) {
                                    case 0: //if choice is 0 it does nothing
                                        break;
                                    case 1: //if choice is 1 it asks user for file number
                                        System.out.println("Enter the file ID you would like to see: (press 0 to go back to main menu)");
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

                        do { //loops if invalid choice is entered
                            invalidChoice = false;
                            System.out.println("Enter the file id you would like to edit or press 0 to return to main menu");
                            int recordId = Integer.parseInt(input.nextLine()); //file id user wants to edit
                            if (recordId > 0 && recordId <= (file.length() / FILE_SIZE)) { //checks if file id exists and if it does it calls update file
                                writeStudentRecord(updateStudent(recordId));
                            } else if (recordId == 0) { //if file id is 0, it does nothing and returns to main menu

                            } else { //if it doesnt exist it asks to try again
                                System.out.println("Invalid file ID, try again");
                                invalidChoice = true;
                            }
                        } while (invalidChoice);
                        break;
                    case 4: //exits program
                        keepGoing = false;

                        break;
                    default: //if its an invalid choice that is not in the right range of numbers
                        System.out.println("Invalid Choice, please select in the range of 1-4");
                        break;
                }
            } catch (NumberFormatException nfe) { //Catches exception if user inputs String instead of number
                System.out.println("Please input an integer ");
            } catch (FileNotFoundException fnf) { //if file is not found it calls openStore 
                System.out.println("File could not be found, try again");
                openStore();
            } catch (NullPointerException npe) { //if file is null it calls openStore 
                System.out.println("File could not be found, try again");
                openStore();
            } catch (IOException npe) { //if there is an error with the file
                System.out.println("A error has occurred with the file. Make sure the file is not full and it can be accessed");
            } catch (Exception e) { //any other unexpected error
                System.out.println("Error, please try again");
            }
        } while (keepGoing); //exits program when user chooses to
        //closes file when exits
        closeStore();
    }

    public static StudentRecord writeStudentRecord(StudentRecord record) {
        try {

            if (record.getFileRecordID() == -1) { //if file id is -1 it creates a file id at end of file
                file.seek(file.length());
                record.setFileRecordID((file.length() / FILE_SIZE) + 1);
            } else { // if file id is not -1 it writes over the existing file id
                file.seek((record.getFileRecordID() - 1) * FILE_SIZE);
            }

            file.writeChars(record.getFirstName()); //writes the firstname
            file.writeChars(record.getLastName()); //writes the lastname
            file.writeInt(record.getOEN()); //writes the oen
            file.writeInt(record.getHeight());//writes the height
            file.writeDouble(record.getAverage()); //writes the average
            file.writeBoolean(record.getIEP()); //writes the boolean
            file.writeChar(record.getLearningSkill()); //writes a char

        } catch (IOException ex) {
            System.out.println("Error writing file");
        } catch (NullPointerException ex) { //sends message to user if file not found and attempts to open store
            System.out.println("File not found, could not write to file");
            openStore();
        }
        return record;
    }

    public static StudentRecord readRecord(int recordId) {
        StudentRecord student = new StudentRecord();
        try {

            student.setFileRecordID(recordId);
            file.seek((recordId - 1) * FILE_SIZE);//goes to start of record at position given

            char firstName[] = new char[20]; // reads characters in firstname string
            for (int i = 0; i < NAME_FIELD; i++) {
                firstName[i] = file.readChar();
            }

            student.setFirstName(new String(firstName)); //sets the first name

            char lastName[] = new char[20]; //reads characters in last name string
            for (int i = 0; i < NAME_FIELD; i++) {
                lastName[i] = file.readChar();
            }

            student.setLastName(new String(lastName)); //sets the last name

            student.setOEN(file.readInt()); //sets the oen
            student.setHeight(file.readInt()); //sets the height
            student.setAverage(file.readDouble()); //sets the average
            student.setIEP(file.readBoolean()); //sets the iep
            student.setLearningSkill(file.readChar()); //

            System.out.println(student.toString()); //prints it out

        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
        return student;
    }

    public static void displayAllRecord() {
        try {
            //method that goes through every id and reads it
            long numRecords = file.length() / FILE_SIZE;
            for (int i = 0; i < numRecords; i++) { //iterates through and reads each record
                readRecord(i + 1);
            }
        } catch (IOException ex) {
            System.out.println("Error displaying all records");
        }
    }

    public static StudentRecord updateStudent(int recordId) {
        //var list
        StudentRecord student = readRecord(recordId);
        boolean invalidChoice;

        // 
        System.out.println("Enter new first name or [k]eep current first name: [" + student.getFirstName() + "]");
        String firstName = input.nextLine(); //gets user input

        if (!"k".equalsIgnoreCase(firstName)) { // sets first name if not k
            student.setFirstName(firstName);
        }

        System.out.println("Enter new last name or [k]eep current last name: [" + student.getLastName() + "]");
        String lastName = input.nextLine(); //gets user input
        if (!"k".equalsIgnoreCase(lastName)) { //sets last name if not k
            student.setLastName(lastName);
        }

        do { //loops until a valid choice is entered
            invalidChoice = false;
            try {
                System.out.println("Enter new OEN or [k]eep current OEN: [" + student.getOEN() + "] ");
                String OEN = input.nextLine(); //gets user input
                if (!"k".equalsIgnoreCase(OEN)) { //if value is k it does not set anything
                    if (Integer.parseInt(OEN) > 99999999 && Integer.parseInt(OEN) < 1000000000) { //if 9 digits long it sets
                        student.setOEN(Integer.parseInt(OEN));
                    } else { //if not 9 digits long it shows error message
                        System.out.println("Invalid OEN, make sure it is 9 digits long");
                        invalidChoice = true;
                    }
                }
            } catch (NumberFormatException nfe) { //if different data type is entered it asks for an integer
                System.out.println("Please input an integer thats 9 digits long");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do { //loops until a valid choice is entered
            invalidChoice = false;
            try {
                System.out.println("Enter new height or [k]eep current height: [" + student.getHeight() + "] ");
                String height = input.nextLine(); //gets user input
                if (!"k".equalsIgnoreCase(height)) { //if value is k it does not set anything
                    if (Integer.parseInt(height) > 30 && Integer.parseInt(height) < 300) { // sets OEN if valid
                        student.setHeight(Integer.parseInt(height));
                    } else { // if not a valid height it prints a error message and loops for height again
                        System.out.println("Invalid height, make sure it is over 40cm and less than 300cm");
                        invalidChoice = true;
                    }
                }
            } catch (NumberFormatException nfe) { //if different data type is entered it asks for an integer
                System.out.println("Please input an integer.");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do { //loops until a valid choice is entered
            invalidChoice = false;
            try {
                System.out.println("Enter new student average or [k]eep current average: [" + student.getAverage() + "]");
                String average = input.nextLine(); //gets user input
                if (!"k".equalsIgnoreCase(average)) { //if value is k it does not set anything
                    if (Double.parseDouble(average) >= 0 && Double.parseDouble(average) <= 100) { //sets only if average is valid
                        student.setAverage(Double.parseDouble(average));
                    } else {
                        System.out.println("Invalid Average, please input a number between 0-100");
                        invalidChoice = true;
                    }
                }
            } catch (NumberFormatException nfe) { //if different data type is entered it asks for a double
                System.out.println("Please input a number between 0-100");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do { //loops until a valid choice is entered
            invalidChoice = false;
            System.out.println("Enter if student has IEP (true or false) or [k]eep current: [" + student.getIEP() + "]");
            String IEP = input.nextLine();
            if (!"k".equalsIgnoreCase(IEP)) { //if value is k it does not set anything
                if (IEP.equalsIgnoreCase("true")) { // if the text says true it sets IEP to true
                    student.setIEP(true);
                } else if (IEP.equalsIgnoreCase("false")) { //if the text says false it sets IEP to false
                    student.setIEP(false);
                } else { // it asks user to enter true or false if text says anything else
                    System.out.println("Please enter true or false");
                    invalidChoice = true;
                }
            }
        } while (invalidChoice);

        do { //loops until a valid choice is entered
            invalidChoice = false;
            System.out.println("Enter student learning skill (E-excellent, G-good, B-bad) or [k]eep current: [" + student.getLearningSkill() + "]");
            String learningSkill = input.nextLine();
            if (!"k".equalsIgnoreCase(learningSkill)) { //if value is k it does not set anything
                if (learningSkill.equalsIgnoreCase("E")) { // if the text says E it sets learning skill to E
                    student.setLearningSkill('E');
                } else if (learningSkill.equalsIgnoreCase("G")) { //if the text says g it learning skill to g
                    student.setLearningSkill('G');
                } else if (learningSkill.equalsIgnoreCase("B")) { //if the text says b it learning skill to b
                    student.setLearningSkill('B');
                } else { // it asks user to enter true or false if text says anything else
                    System.out.println("Please enter E, G or B");
                    invalidChoice = true;
                }
            }
        } while (invalidChoice);

        return student; //returns the student

    }

    public static StudentRecord addStudent() {

        StudentRecord student = new StudentRecord();
        boolean invalidChoice;
        //sets first name to user input
        System.out.println("Enter first name: ");
        student.setFirstName(input.nextLine());
        //sets last name to user input
        System.out.println("Enter last name: ");
        student.setLastName(input.nextLine());

        do { //loops  if invalid choice is selected
            invalidChoice = false;
            try {
                System.out.println("Enter OEN: ");
                int OEN = Integer.parseInt(input.nextLine()); //gets oen from user
                if (OEN > 99999999 && OEN < 1000000000) { // sets OEN if 9 digits long
                    student.setOEN(OEN);
                } else { // if not 9 digits long it prints a error message and loops for OEN again
                    System.out.println("Invalid OEN, make sure it is 9 digits long");
                    invalidChoice = true;
                }
            } catch (NumberFormatException nfe) { //if string is entered it asks for an integer
                System.out.println("Invalid OEN, please input an integer that is 9 digits long");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do { //loops  if invalid choice is selected
            invalidChoice = false;
            try {
                System.out.println("Enter students height in cm: ");
                int height = Integer.parseInt(input.nextLine()); //gets oen from user
                if (height > 30 && height < 300) { // sets OEN if 9 digits long
                    student.setHeight(height);
                } else { // if not a valid height it prints a error message and loops for height again
                    System.out.println("Invalid height, make sure it is over 40cm and less than 300cm");
                    invalidChoice = true;
                }
            } catch (NumberFormatException nfe) { //if string is entered it asks for an integer
                System.out.println("Invalid height, please input an integer");
                invalidChoice = true;
            }

        } while (invalidChoice);

        do { //loops if invalid choice is selected
            invalidChoice = false;
            try {
                System.out.println("Enter student average: ");
                Double average = Double.parseDouble(input.nextLine()); //gets student average
                if (average >= 0 && average <= 100) { //only sets average if valid
                    student.setAverage(average);
                } else { //if not valid, displays message
                    System.out.println("Invalid Average, please input a number between 0-100");
                    invalidChoice = true;
                }
            } catch (NumberFormatException nfe) { //if number is not entered it displays message
                System.out.println("Please input a number between 0-100");
                invalidChoice = true;
            }
        } while (invalidChoice);

        do { //loops if invalid choice is selected
            invalidChoice = false;
            System.out.println("Enter if student has IEP (true or false): ");
            String IEP = input.nextLine(); //gets student average
            if (IEP.equalsIgnoreCase("true")) { //if string is true it sets iep to true
                student.setIEP(true);
            } else if (IEP.equalsIgnoreCase("false")) { //if string is false it sets iep to false
                student.setIEP(false);
            } else { //it displays an error message if not true or false
                System.out.println("Please enter true or false");
                invalidChoice = true;
            }

        } while (invalidChoice);

        do { //loops until a valid choice is entered
            invalidChoice = false;
            System.out.println("Enter student learning skill (E-excellent, G-good, B-bad)");
            String learningSkill = input.nextLine();
            if (learningSkill.equalsIgnoreCase("E")) { // if the text says E it sets learning skill to E
                student.setLearningSkill('E');
            } else if (learningSkill.equalsIgnoreCase("G")) { //if the text says g it learning skill to g
                student.setLearningSkill('G');
            } else if (learningSkill.equalsIgnoreCase("B")) { //if the text says b it learning skill to b
                student.setLearningSkill('B');
            } else { // it asks user to enter true or false if text says anything else
                System.out.println("Please enter E, G or B");
                invalidChoice = true;
            }
        } while (invalidChoice);

        student.setFileRecordID(-1); //sets fileID to -1 so when writefile gets called it will add to end of file
        return student;

    }

}
