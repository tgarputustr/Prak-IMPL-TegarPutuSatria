package OCP;

public class StandardCinemaOCP extends CinemaOCP {
    public StandardCinemaOCP(Double price) { 
        this.price = price; 
    }
    @Override 
    Double calculateAdminFee() { 
        return price * 10 / 100; 
    } 
}
