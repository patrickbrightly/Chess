/**
 * These are the spaces on the board.
 */
public class Tile {
    int col; //the column of the piece
    int row; //the row of the piece
    String name; //the name of the position (row# + column letter)
    Piece current;  //the current piece on this tile

    /**
     * This constructor creates a tile with a known position on the board
     * @param col column of the tile
     * @param row row of the tile
     */
    public Tile(int row, int col){
        this.col = col;
        this.row = row;
        current = null;
        name = (this.row+1)+""+(char)(this.col+65); //column letters A-H
    }

    /**
     * This methods checks if there is a piece on this square
     * @return true if there isn't a piece on this tile
     */
    public Boolean isEmpty(){
        Boolean result = false;
        if(current==null){
            result = true;
        }
        return result;
    }

    /**
     * This method adds a piece to this tile
     * @param piece the piece to be added to the tile
     */
    public void addPiece(Piece piece){
        if(current == null){
            current = piece;
            piece.setTile(this);
        } else{
            System.err.println("Space already occupied");
        }
    }

    /**
     * This method gets the name of the piece on this tile
     * @return the string name of the piece on the tile
     */
    public String getPiece(){
        if(current==null){
            return "--";
        } else {
            return current.getName();
        }
    }
}
