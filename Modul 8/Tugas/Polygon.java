class Polygon extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Polygon");
    }

    @Override
    void move() {
        System.out.println("Moving Polygon");
    }

    @Override
    void resize() {
        System.out.println("Resizing Polygon");
    }
}