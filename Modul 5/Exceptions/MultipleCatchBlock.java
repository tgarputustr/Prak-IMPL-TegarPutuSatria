package Exceptions;
public class MultipleCatchBlock {
    public static void main(String[] args) {
        try {
            //protected code
        } catch (ArithmeticException e) {
            //catch block
        } catch (ArrayIndexOutOfBoundsException e) {
            //catch block
        } catch (Exception e){
            //catch block
        }
    }
}
