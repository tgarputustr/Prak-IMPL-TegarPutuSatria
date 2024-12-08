package LatihanDefensiveProgramming;

import java.io.*;
import java.util.Vector;

public class ListOfNumbers2 {
    private Vector<Integer> victor;
    private static final int size = 10;

    public ListOfNumbers2() {
        victor = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            victor.addElement(i);
        }
        try {
            this.readList("infile.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException while reading file: " + e.getMessage());
        }

        try {
            this.writeList();
        } catch (IOException e) {
            System.err.println("IOException while writing to file: " + e.getMessage());
        }
    }

    public void readList(String fileName) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        String line;
        while ((line = raf.readLine()) != null) {
            try {
                Integer i = Integer.parseInt(line);
                System.out.println(i);
                victor.addElement(i);
            } catch (NumberFormatException e) {
                System.err.println("Number format exception for line: " + line);
            }
        }
        raf.close();
    }

    public void writeList() throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("outfile.txt"));
            for (int i = 0; i < victor.size(); i++) {
                out.println("Value at: " + i + " = " + victor.elementAt(i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index out of bounds: " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
                System.out.println("PrintWriter closed successfully.");
            } else {
                System.err.println("PrintWriter not open.");
            }
        }
    }

    public static void main(String[] args) {
        new ListOfNumbers2();
    }
}

