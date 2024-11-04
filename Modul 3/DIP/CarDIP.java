public class CarDIP {
    private EngineInterface engine;

    public CarDIP(EngineInterface engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }
}
