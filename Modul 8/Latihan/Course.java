import java.util.Enumeration;
import java.util.Vector;

public class Course {
    private String title;
    private Vector courseRecords;
    Course() {
        courseRecords=new Vector();
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String t) {
        title = t;
    }
    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }
    public Enumeration getCourseRecord() {
        return courseRecords.elements();
    }
    public void printCourseStudents(){
        
    }
    public void printBestStudent() {

    }
    public void printFinalExamStudents() {
        
    }
}
