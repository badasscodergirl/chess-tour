package chess_tour.pieces;

public class Movement {

    private String name;
    private int rows;
    private int cols;

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public String name() {
        return name;
    }

    public Movement(String name, int rows, int cols) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
    }

}
