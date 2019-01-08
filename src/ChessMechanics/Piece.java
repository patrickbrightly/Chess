package ChessMechanics;

import java.util.LinkedList;

/**
 * These are the the pieces on the board
 * Each piece will implement this interface.
 * */
public interface Piece {
    public LinkedList<Tile> getMoves(); //Gives all the possible moves for the piece
    public boolean causesCheck();       //checks to see if the piece causes check
    public String getName();            //gets the name of the piece
    public void setTile(Tile newTile);  //sets the tile of the piece
    public int getColour();             //gets the colour of the piece
    public Tile getTile();              //gets the tile the piece is on
    public void capture(Tile moveTo);  //returns a captured piece
    public int getHValue();             //Returns the heuristic value for that piece
    public void setMoved();              //sets the piece to moved
 }
