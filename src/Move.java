/**
 * This class encapsulates the moves made by any piece.
 * This will be used to keep track of the moves as they take place
 */
public class Move {
    Piece piece;
    Tile from;
    Tile to;

    public Move(Piece piece, Tile moveFrom, Tile moveTo){
        this.piece = piece;
        this.from = moveFrom;
        this.to = moveTo;
        //Do the work of moving the piece legally.
    }

    @Override
    public String toString() {
        return (from.name + to.name);
    }
}
