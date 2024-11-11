public class CourseController {
    private Course Model;
    private CourseView View;
    public CourseController(Course Model, CourseView View) {
        this.Model = Model;
        this.View = View;
    }
    public void setCourseName(String name){
        Model.setCourseName(name);
    }
    public String getCourseName() {
        return Model.getCourseName();
    }
    public void setCourseId(String id) {
        Model.setCourseId(id);
    }
    public String getCourseId() {
        return Model.getCourseId();
    }
    public void setCourseCategory(String cat){
        Model.setCourseCategory(cat);
    }
    public String getCourseCategory() {
        return Model.getCourseCategory();
    }
    public void updateView() {
        View.printCourseDetails(getCourseName(), getCourseId(), getCourseCategory());
    }
}
