public class StudentController {
    private Student Model;
    private StudentView View;
    public StudentController(Student Model, StudentView View) {
        this.Model = Model;
        this.View = View;
    }
    public void setStudentName(String name) {
        Model.setName(name);
    }
    public String getStudentName() {
        return Model.getName();
    }
    public void setStudentRollNo(String rollNo) {
        Model.setRollNo(rollNo);
    }
    public String getStudentRollNo() {
        return Model.getRollNo();
    }
    public void updateView() {
        View.printStudentDetails(getStudentName(), getStudentRollNo());
    }
}
