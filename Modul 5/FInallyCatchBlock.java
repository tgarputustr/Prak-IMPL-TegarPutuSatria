public class FInallyCatchBlock {
    public static void main(String[] args) {
        try {
            //protected code
        } catch (ArithmeticException e) {
            //catch block
        } catch (ArrayIndexOutOfBoundsException e) {
            //catch block
        } catch (Exception e){
            //catch block
        } finally {
            //the finally block always execute
        }
    }
}
