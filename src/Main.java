import chess_tour.PieceCreator;
import chess_tour.TourMaker;
import chess_tour.pieces.ChessPiece;
import chess_tour.pieces.PieceNames;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Chess Piece Tour of chess board 10x10 !");

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter start row in range (0, 9):");
            int startRow = scanner.nextInt();

            System.out.println("Enter start column in range (0, 9):");
            int startCol = scanner.nextInt();

            ChessPiece myChessPiece = PieceCreator.getPiece(PieceNames.KNIGHT.name());
            System.out.println("Piece Name = "+ myChessPiece.getName());
            TourMaker tourMaker = new TourMaker(myChessPiece, startRow, startCol);
            tourMaker.makeTours();
            tourMaker.printTour();

            //tourMaker.printTourPaths();

        } catch (Exception ex) {
            System.out.println("Chess tour failed with exception "+ex.getMessage());
            ex.printStackTrace();
        }

    }
}
