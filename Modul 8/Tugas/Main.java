public class Main {
    public static void main(String[] args) {

        Point center = new Point(0, 0);
        Circle circle = new Circle(5.0f, center);
        circle.draw();
        circle.move();
        circle.resize();
        System.out.println("Area: " + circle.getArea());
        System.out.println("Circumference: " + circle.getCircumference());

        Rectangle rectangle = new Rectangle();
        rectangle.draw();
        rectangle.move();
        rectangle.resize();

        Polygon polygon = new Polygon();
        polygon.draw();
        polygon.move();
        polygon.resize();

        DrawingContext context = new DrawingContext();
        context.setPoint();
        context.clearScreen();
        context.getVerticalSize();
        context.getHorizontalSize();

        ConsoleWindow consoleWindow = new ConsoleWindow();
        consoleWindow.display();

        DialogBox dialogBox = new DialogBox();
        dialogBox.display();

        DataController dataController = new DataController();
        dataController.control();

        Event event = new Event();
        event.trigger();
    }
}