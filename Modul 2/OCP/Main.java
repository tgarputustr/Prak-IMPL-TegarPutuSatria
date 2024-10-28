package OCP;

public class Main {
    public static void main(String[] args) { 
        StandardCinemaOCP standardCinema = new StandardCinemaOCP(100.0); 
        Double adminFee = standardCinema.calculateAdminFee(); 
        System.out.println(adminFee); 
    }
}
