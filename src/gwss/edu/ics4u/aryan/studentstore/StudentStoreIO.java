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
    final static int FILE_SIZE = 84;

    public static void main(String args[]) throws Exception {

        openStore();

        System.out.println("Creating Class Records");
        StudentRecord aryan = new StudentRecord();

        aryan.setFirstName("Aryan");
        aryan.setLastName("Ghahremanzadeh");
        aryan.setOEN(289345768);
        aryan.setFileRecordID(0);
        aryan = writeStudentRecord(aryan);

        System.out.println("RECORD SIZE: " + file.length());

        StudentRecord farjaad = new StudentRecord();
        farjaad.setFirstName("Farjaad");
        farjaad.setLastName("Rawasia");
        farjaad.setOEN(289345768);
        farjaad.setFileRecordID(1);
        farjaad = writeStudentRecord(farjaad);
        System.out.println("RECORD SIZE: " + file.length());
        

        System.out.println("Enter record you want to read: ");
      //  int recordNumber = input.nextInt();
        writeStudentRecord(updateStudent(2));
        
        displayRecord();
        closeStore();
    }

    public static void openStore() throws Exception {
        if (file == null || closed == false) {
            file = new RandomAccessFile("student_info.txt", "rw");
        }
    }

    public static void closeStore() throws Exception {
        closed = false;
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

    public static void displayMenu() {
        System.out.println("Welcome to student Store");
        System.out.println("Menu: Press 1 to add to file, Press 2 to read the file, Press 3 to quit  ");
        System.out.println();
        int userChoice = input.nextInt();
        switch (userChoice) {
            case 1:   
        }
        
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
        long numRecords = file.length() /FILE_SIZE;
        StudentRecord s;
        for (int i = 0; i< numRecords; i++) {
            s = readRecord(i+1);          
        }
        
    }
    
    public static StudentRecord updateStudent( int recordId ) throws Exception {
        StudentRecord s = readRecord(recordId);
        System.out.println("Enter new first name: [" + s.getFirstName() + "]" );
        String firstName = input.nextLine();
        s.setFirstName(firstName);
        
        System.out.println("Enter new last name: [" + s.getLastName() + "]" );
        String lastName = input.nextLine();
        s.setLastName(lastName);
        
        System.out.println("Enter new first name: [" + s.getOEN() + "]" );
        int OEN = Integer.parseInt(input.nextLine());
        s.setOEN(OEN);
        
        return s;

    }
    
    public static StudentRecord addStudent() throws Exception {
        StudentRecord s = new StudentRecord();
        System.out.println("Enter first name: ");
        s.setFirstName(input.nextLine());
        
        System.out.println("Enter last name: ");
        s.setLastName(input.nextLine());
        
        System.out.println("Enter OEN: ");
        s.setOEN(input.nextInt());
        
        System.out.println("Enter student average: ");
        s.setAverage(input.nextDouble());
        
        s.setFileRecordID(-1);
        return s;

    }

}
