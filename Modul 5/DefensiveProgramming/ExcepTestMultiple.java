package DefensiveProgramming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcepTestMultiple {
    public static void main(String[] args) {
        try {
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown :" + e);
        }
        System.out.println("Out of the block");

        FileInputStream file = null;
        String fileName = "example.txt";
        
        @SuppressWarnings("unused")
        byte x;

        try {
            file = new FileInputStream(fileName);
            x = (byte) file.read();
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
