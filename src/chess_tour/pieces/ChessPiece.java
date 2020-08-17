package chess_tour.pieces;

import java.util.Set;

public abstract class ChessPiece {

    public abstract String getName();

    public abstract Set<Movement> getPossibleMoves();

    protected static void addMovement(Set<Movement> movements, String name, int rows, int cols) {
        movements.add(new Movement(name, rows, cols));
    }

}
