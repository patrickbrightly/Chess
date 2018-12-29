/**
 * This class encapsulates the moves made by any piece.
 * This will be used to keep track of the moves as they take place
 */
public class Move {
    Piece piece;    //the piece which was moved
    Tile from;      //the tile it moved from
    Tile to;        //the tile it moved to

    public Move(Piece piece, Tile moveTo){
        this.piece = piece;
        this.from = piece.getTile();
        this.to = moveTo;
        if(piece.getMoves().contains(moveTo)){ //check the move is legal
            if(!moveTo.isEmpty()){ //remove the captured piece if the square is occupied
                piece.capture(moveTo);
            }
            from.current = null;    //empty the move from
            to.current = piece;     //put the piece in the tile
            piece.setTile(moveTo);  //tell the piece which tile it's on
        }
    }

    /**
     * This method returns the string representation of the move
     * @return String representation of the move
     */
    @Override
    public String toString() {
        return (from.name + to.name);
    }
}
