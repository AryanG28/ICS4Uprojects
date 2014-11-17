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

    public static void main(String args[]) throws Exception {

        openStore();

        System.out.println("Creating Class Records");
        StudentRecord aryan = new StudentRecord();

        aryan.setFirstName("Aryan");
        aryan.setLastName("Ghahremanzadeh");
        aryan.setFileRecordID(0);
        aryan = witeStudentRecord(aryan);
        
        System.out.println("RECORD SIZE: " + file.length());

//        StudentRecord farjaad = new StudentRecord();
//        farjaad.setFirstName("Fajaad");
//        farjaad.setLastName("Rawasia");
//        farjaad = witeStudentRecord(aryan);
//        System.out.println("RECORD SIZE: " + file.length());
        
        
        //closeStore();

    }

    public static void openStore() throws Exception {
        if (file == null) {
            file = new RandomAccessFile("student_info.txt", "rw");
        }
    }

    public static StudentRecord witeStudentRecord(StudentRecord record) throws Exception {
        
        if( record.getFileRecordID() == -1 ) {
            file.seek( file.length() );
            record.setFileRecordID( file.length() / 80 );
        }
        else {
            file.seek( record.getFileRecordID() * 80 );
        }
                
        file.writeChars(record.getFirstName());
        file.writeChars(record.getLastName());

        return record;
    }

    public static void displayMenu() {
        System.out.println("Welcom to student Store");
        System.out.println("Menu: 1- Write to File, 2- ");
        System.out.println();
    }
}
