public class MVCCourse {
    public static void main(String[] args) {
        Course Model = retriveCourseFromDatabase();
        CourseView view = new CourseView();
        CourseController controller = new CourseController(Model, view);
        controller.updateView();
        controller.setCourseName("Python");
        System.out.println("\nAfter updating, Course Details are as follows");
        controller.updateView();
    }
    private static Course retriveCourseFromDatabase() {
        Course course = new Course();
        course.setCourseName("Java");
        course.setCourseId("01");
        course.setCourseCategory("Programming");
        return course;
    }
}

