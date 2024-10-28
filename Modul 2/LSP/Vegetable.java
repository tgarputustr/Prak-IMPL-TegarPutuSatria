package LSP;

import java.util.Date;

class Vegetable extends Product { 
  
    @Override 
    String getName() { 
        return "Broccoli"; 
    } 
  
    @Override 
    Date getExpiredDate() { 
        return new Date(); 
    } 
}
