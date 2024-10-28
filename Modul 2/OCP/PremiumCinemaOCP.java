package OCP;

public class PremiumCinemaOCP extends CinemaOCP {
    public PremiumCinemaOCP(Double price) { 
        this.price = price; 
    } 
  
    @Override 
    Double calculateAdminFee() { 
        return price * 20 / 100; 
    } 
}
