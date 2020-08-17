package chess_tour;

import java.util.Arrays;

public class ChessBoard {

    int[][] board;

    private int rowSize = 10;
    private int colSize = 10;

    public int getRowSize() {
        return this.rowSize;
    }

    public int getColSize() {
        return this.colSize;
    }

    public ChessBoard() {
        this.board = new int[rowSize][colSize];
    }

    boolean isValidLocation(int row, int col) {
        return  row >= 0 && row < rowSize && col >= 0 && col < colSize;
    }

    boolean isVisited(int row, int col) throws Exception {
        checkValid(row, col);
        return board[row][col] != 0;
    }

    void markVisited(int row, int col) throws Exception {
        checkValid(row, col);
        board[row][col] = 1;
    }

    /**
     * Start location is marked differently
     * this is just to differentiate the starting location (mostly for debugging purpose)
     */
    void markStartLocation(int row, int col) throws Exception {
        checkValid(row, col);
        board[row][col] = 2;
    }

    void unMarkVisited(int row, int col) throws Exception {
        checkValid(row, col);
        board[row][col] = 0;
    }

    void print() {
        for(int[] row: this.board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    void empty() {
        for(int[] row: board) {
            Arrays.fill(row, 0);
        }
    }

    public void checkValid(int row, int col) throws Exception {
        if(!isValidLocation(row, col))
            throw new Exception("Row "+row+" and column "+col+ " is not a valid square." +
                    " Please enter values in the this range. Rows = 0 to "+rowSize+", Columns = 0 to "+colSize);
    }
}
