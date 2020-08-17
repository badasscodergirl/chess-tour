package chess_tour;

public class Location {
    private String moveName;
    private int row;
    private int col;

    public Location(String moveName, int row, int col) {
        this.moveName = moveName;
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String getMoveName() {
        return moveName;
    }

    @Override
    public String toString() {
        return " {move taken->"+moveName+" to reach row:"+row+", col:"+col+"} ";
    }
}
