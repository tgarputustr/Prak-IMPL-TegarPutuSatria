package LSP;

import java.util.Date;

public class VegetableLSP extends FoodProduct{
    @Override 
    String getName() { 
         return "Broccoli"; 
    } 
    @Override 
    Date getExpiredDate() { 
        return new Date(); 
    } 
}
