package chess_tour.pieces;

import java.util.HashSet;
import java.util.Set;

public class Knight extends ChessPiece {

    private static final String name = PieceNames.KNIGHT.name();

    private static Knight instance;

    @Override
    public String getName() {
        return name;
    }

    public static Knight getPiece() {
        if(instance == null) {
            instance = new Knight();
            if(!ChessPieceMoves.pieceMovements.containsKey(name)) {
                initMovements();
            }
        }
        return instance;
    }

    private Knight() {}

    @Override
    public Set<Movement> getPossibleMoves() {
        return ChessPieceMoves.pieceMovements.get(getName());
    }

    public static void initMovements() {
        Set<Movement> possibleMoves = new HashSet<>();
        ChessPiece.addMovement(possibleMoves,"N", -3, 0);
        ChessPiece.addMovement(possibleMoves,"S", 3, 0);
        ChessPiece.addMovement(possibleMoves,"E", 0, 3);
        ChessPiece.addMovement(possibleMoves,"W", 0, -3);

        ChessPiece.addMovement(possibleMoves,"NE", -2, -2);
        ChessPiece.addMovement(possibleMoves,"SW", 2, -2);
        ChessPiece.addMovement(possibleMoves,"SE", 2, 2);
        ChessPiece.addMovement(possibleMoves,"NE", -2, 2);

        ChessPieceMoves.pieceMovements.put(name, possibleMoves);
    }

}
