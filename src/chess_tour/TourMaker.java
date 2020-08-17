package chess_tour;

import chess_tour.pieces.ChessPiece;
import chess_tour.pieces.Movement;

import java.util.*;

public class TourMaker {

    private ChessBoard board;
    private ChessPiece piece;
    private int startRow;
    private int startCol;
    private Set<List<Location>> allPaths;
    private String[][] tourResult;

    public TourMaker(ChessPiece piece, int sRow, int sCol) {
        this.board = new ChessBoard();
        this.allPaths = new HashSet<>();
        this.piece = piece;
        this.startRow = sRow;
        this.startCol = sCol;
        this.tourResult = new String[this.board.getRowSize()][this.board.getColSize()];
        for(String[] row: tourResult) {
            Arrays.fill(row, "----");
        }
    }


    /**
     * Makes all possible tours
     * All the tours are stored in the paths list
     * @throws Exception
     */
    public void makeTours() throws Exception {
        this.board.checkValid(startRow, startCol);

        for(Movement move: piece.getPossibleMoves()) {
            int newRow = startRow + move.rows();
            int newColumn = startCol + move.cols();

            /* Mark that the start location is already visited. And visit all possible paths in the loop below. */
            board.markStartLocation(startRow, startCol);

            if(board.isValidLocation(newRow, newColumn)) {
                ArrayList<Location> path = new ArrayList<Location>() {{add(new Location("Start", startRow, startCol));}};
                this.tour(newRow, newColumn, path, move.name());
                board.empty();
            }
        }
    }

    /**
     *
     * @param row row of location about to visit
     * @param col column of location about to visit
     * @param path List maintaining the current path
     * @param goingTo The move executed to get to this location
     * @throws Exception
     *
     * Recursively traverses all possible paths
     */
    private void tour(int row, int col, List<Location> path, String goingTo) throws Exception {
        if(!board.isValidLocation(row, col)) {
            allPaths.add(new ArrayList<>(path));
            return;
        }

        if(board.isVisited(row, col)) return;

        board.markVisited(row, col);
        path.add(new Location(goingTo, row, col));

        for(Movement move: piece.getPossibleMoves()) {
            tour(row + move.rows(), col + move.cols(), path, move.name());
        }
        path.remove(path.size()-1);
    }

    /**
     * Prints a 2D matrix of locations visited, also has the order in which they are visited.
     * Differentiates the origin and end point by marking them 'Start' and 'End'
     * Other visited locations are marked as 'NE(3)' or 'S(14)'
     * The letters indicate the move done and the number is the count of step.
     */
    public void printTour() {
        for(List<Location> locations: allPaths) {
            System.out.println("Printing a tour ===> ");
            tourResult[locations.get(0).getRow()][locations.get(0).getCol()] = "Start";
            int size = locations.size();
            for(int i = 1; i < size-1; i++) {
                tourResult[locations.get(i).getRow()][locations.get(i).getCol()] =  locations.get(i).getMoveName()+"("+i+")";
            }
            //tourResult[locations.get(size-1).getRow()][locations.get(size-1).getCol()] = locations.get(size-1).getMoveName()+" End ";
            tourResult[locations.get(size-1).getRow()][locations.get(size-1).getCol()] = "End";

            for(String[] row: tourResult) {
                for(String loc: row) {
                    System.out.print(loc+"    ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public void printTourPaths() {
        for(List<Location> list: allPaths){
            System.out.println("Path started from: "+ list.get(0));
            System.out.println("After that it covered the following points sequentially.");
            for(int i = 1;i<list.size()-1;i++){
                System.out.println(list.get(i));
            }
            System.out.println("\nFinally it terminated at: "+list.get(list.size()-1)+"\n");
        }
    }


}
