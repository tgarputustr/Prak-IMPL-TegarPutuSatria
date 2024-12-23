class DialogBox extends Window {
    @Override
    void open() {
        System.out.println("Opening Dialog Box");
    }

    @Override
    void close() {
        System.out.println("Closing Dialog Box");
    }

    @Override
    void move() {
        System.out.println("Moving Dialog Box");
    }

    @Override
    void display() {
        System.out.println("Displaying Dialog Box");
    }

    @Override
    void handleEvent(Event event) {
        System.out.println("Handling Event in Dialog Box");
    }
}