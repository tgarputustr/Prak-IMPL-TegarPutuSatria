class ConsoleWindow extends Window {
    @Override
    void open() {
        System.out.println("Opening Console Window");
    }

    @Override
    void close() {
        System.out.println("Closing Console Window");
    }

    @Override
    void move() {
        System.out.println("Moving Console Window");
    }

    @Override
    void display() {
        System.out.println("Displaying Console Window");
    }

    @Override
    void handleEvent(Event event) {
        System.out.println("Handling Event in Console Window");
    }
}