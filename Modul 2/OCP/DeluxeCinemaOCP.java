package OCP;

class DeluxeCinemaOCP extends CinemaOCP { 
    public DeluxeCinemaOCP(Double price) { 
        this.price = price; 
    } 
  
  
    @Override 
    Double calculateAdminFee() { 
        return price * 12 / 100; 
    } 
}