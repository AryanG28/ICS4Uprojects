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

        closeStore();
    }

    public static void openStore() throws Exception {
        if (file == null) {
            file = new RandomAccessFile("student_info.txt", "rw");
        }
    }

    public static void closeStore() throws Exception {
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
        return record;
    }

    public static void displayMenu() {
        System.out.println("Welcom to student Store");
        System.out.println("Menu: Press 1 to write to file, Press 2 to read the file, Press 3 to quit  ");
        System.out.println();
    }

    public static StudentStore readRecord(int recordId) throws IOException {
        long recordNumber = input.nextLong();
        long numRecords = file.length() / FILE_SIZE;
        if (recordNumber > 0 && recordNumber <= numRecords) {
            long position = FILE_SIZE * (recordNumber - 1);
            file.seek(position);

        }
        char firstName[] = new char[20];
        for (int i = 0; i < 20; i++) {
            firstName[i] = file.readChar();
        }

        char lastName[] = new char[20];
        for (int i = 0; i < 20; i++) {
            lastName[i] = file.readChar();
        }

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("OEN: " + file.readInt());
        return null;
    }
    
    public static void displayRecord() throws IOException {
        long numRecords = file.length() /FILE_SIZE;
        StudentStore s;
        for (int i = 0; i< numRecords; i++) {
           // s = readRecord(i+1);
           // System.out.println(s.toString());
        }
        
    }

}
