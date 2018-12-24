/**
 * These are the the pieces on the board
 * Each piece will implement this interface.
 * */
public interface Piece {
    public Position getMoves(); //Gives all the possible moves for the piece
}
