package chess_tour;

import chess_tour.pieces.ChessPiece;
import chess_tour.pieces.Knight;
import chess_tour.pieces.PieceNames;

public class PieceCreator {

    public static ChessPiece getPiece(String name) {
        ChessPiece piece = null;
        switch (PieceNames.valueOf(name)) {
            case KNIGHT:
                piece = Knight.getPiece();
                break;
        }
        return piece;
    }
}
