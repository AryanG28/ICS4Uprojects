/*
 */
package gwss.edu.ics4u.aryan.u5;

import gwss.edu.ics4u.aryan.u5.ClassRecord;
import java.io.RandomAccessFile;

/**
 */
public class ClassStore {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) throws Exception {

        System.out.println( "Creating 4 Class Records" );

        // CHEMISTRY
        ClassRecord c1 = new ClassRecord( "Mr. Sanderson", "ICS4U1-01", 31 );
        System.out.println( "Created Class: " + c1.toString() );

        // BIOLOGY
        ClassRecord c2 = new ClassRecord( "Ms. Smallbone", "SBI4U1-01", 32 );
        System.out.println( "Created Class: " + c2.toString() );

        // PHYSICS
        ClassRecord c3 = new ClassRecord( "Mr. Tennant", "SPH4U1-02", 34 );
        System.out.println( "Created Class: " + c3.toString() );

        // COMPUTER SCIENCE
        ClassRecord c4 = new ClassRecord( "Mr. Muir", "ICS4U-01", 20 );
        System.out.println( "Created Class: " + c4.toString() );

        System.out.println( "*********************" );

        
        // WRITE FIRST RECORD
        RandomAccessFile recordFile = new RandomAccessFile( "classes.txt", "rw" );
        
        // RECORD #1 (start of file)
        recordFile.seek( 0 );
        recordFile.writeChars( c1.getTeacherName() ); 
        recordFile.writeChars( c1.getSubjectName() ); 
        recordFile.writeInt( c1.getClassSize() );
        System.out.println( "RECORD SIZE: " + recordFile.length() );
        
        // RECORD #2
        recordFile.writeChars( c2.getTeacherName() ); 
        recordFile.writeChars( c2.getSubjectName() ); 
        recordFile.writeInt( c2.getClassSize() );
        System.out.println( "RECORD SIZE: " + recordFile.length() );
        
        // RECORD #3
        recordFile.writeChars( c3.getTeacherName() ); 
        recordFile.writeChars( c3.getSubjectName() ); 
        recordFile.writeInt( c3.getClassSize() );
        System.out.println( "RECORD SIZE: " + recordFile.length() );
        
        // RECORD #4
        recordFile.writeChars( c3.getTeacherName() ); 
        recordFile.writeChars( c3.getSubjectName() ); 
        recordFile.writeInt( c3.getClassSize() );
        System.out.println( "RECORD SIZE: " + recordFile.length() );

    }

}
