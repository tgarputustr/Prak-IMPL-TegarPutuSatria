class Circle extends Shape {
    private float radius;
    private Point center;

    public Circle(float radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    public float getCircumference() {
        return (float) (2 * Math.PI * radius);
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    void move() {
        System.out.println("Moving Circle");
    }

    @Override
    void resize() {
        System.out.println("Resizing Circle");
    }
}