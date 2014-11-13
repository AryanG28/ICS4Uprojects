/*
 */
package gwss.edu.ics4u.aryan.u5;

/**
 */
public class ClassRecord {

    // CLASS CONSTANTS
    public static final int RECORD_SIZE = 30;
    public static final int LENGTH_TEACHER_NAME = 15;
    public static final int LENGTH_SUBJECT = 12;

    // CLASS VARIABLES
    public static int lastID = 0;

    // OBJECT VARIABLES
    private String teacherName;
    private String subjectName;
    private int classSize;
    private int id;

    public ClassRecord() {
        this( "TBD", "TBD", 0 );
    }

    public ClassRecord( String teacherName, String subjectName, int classSize ) {
        this.setTeacherName( teacherName );
        this.setSubjectName( subjectName );
        this.classSize = classSize;
        this.id = -1;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName( String teacherName ) {
        if ( teacherName != null ) {
            StringBuilder temp = new StringBuilder( teacherName.trim() );
            temp.setLength( LENGTH_TEACHER_NAME );

            // trucates or pads the string
            this.teacherName = temp.toString();
        } else {
            // TODO
            this.teacherName = "TBD";
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName( String subjectName ) {
        if ( subjectName != null ) {
            StringBuilder temp = new StringBuilder( subjectName.trim() );
            temp.setLength( LENGTH_SUBJECT );

            // trucates or pads the string
            this.subjectName = temp.toString();
        } else {
            // TODO
            this.subjectName = "TBD";
        }
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize( int classSize ) {
        this.classSize = classSize;
    }

    @Override
    public String toString() {
        return "ClassRecord{" + "teacherName=" + teacherName + ", subjectName=" + subjectName + ", classSize=" + classSize + ", id=" + id + '}';
    }    
    
    

}
