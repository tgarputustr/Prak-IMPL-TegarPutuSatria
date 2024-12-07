import java.util.ArrayList;
import java.util.List;

public class Flagged {
    public final static int STATUS_VALUE = 0;
    public final static int FLAGGED = 4;
    private int[][] gameBoard = {
        {0, 1, 2},
        {4, 5, 6},
        {8, 2, 3},
        {4, 2, 0}
    };

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<int[]>();
        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }  
        }
        return flaggedCells;
    }
    public static void main(String[] args) {
        Flagged flagged = new Flagged();
        List<int[]> flaggedCells = flagged.getFlaggedCells();

        System.out.println("Flagged Cells: ");
        for (int[] cell : flaggedCells) {
            System.out.print("[ ");
            for (int value : cell) {
                System.out.print(value + " ");
            }
            System.out.println("]");
        }
    }
}
