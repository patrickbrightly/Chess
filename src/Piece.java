import java.util.LinkedList;

/**
 * These are the the pieces on the board
 * Each piece will implement this interface.
 * */
public interface Piece {
    public LinkedList<Tile> getMoves(); //Gives all the possible moves for the piece
    public Tile move(Move newTile); //Moves the piece to the new position
    public boolean causesCheck();   //checks to see if the piece causes check
    public String getName();
    public void setTile(Tile newTile);
    public int getColour();
}
