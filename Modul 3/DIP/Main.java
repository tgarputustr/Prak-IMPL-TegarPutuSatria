public class Main {
    public static void main(String[] args) {
        CarDIP fuelCarDIP = new CarDIP(new PetrolEngine());
        CarDIP dieCarDIP = new CarDIP(new DieselEngineDIP());
        CarDIP hybridCarDIP = new CarDIP(new HybridEngine());

        fuelCarDIP.start();
        dieCarDIP.start();
        hybridCarDIP.start();
    }
}
