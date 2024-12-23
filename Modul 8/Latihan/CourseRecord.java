import java.util.Enumeration;
import java.util.Vector;

public class CourseRecord {
    private Student student;
    private Vector assignments;
    CourseRecord() {
        assignments = new Vector();
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student s) {
        student = s;
    }
    public void addAssignment(Assignment a) {
        assignments.addElement(a);
    }
    public Enumeration getAssignment() {
        return assignments.elements();
    }
}
