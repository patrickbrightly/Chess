/**
 * These are the spaces on the board.
 */
public class Tile {
    int col; //the x Coordinate of the piece
    int row; //the y Coordinate of the piece
    String name; //the name of the position
    Piece current;

    public Tile(int x, int y){
        col = y;
        row = x;
        current = null;
        name = (row+1)+""+(char)(col+65);
    }

    public Boolean isEmpty(){
        Boolean result = false;
        if(current==null){
            result = true;
        }
        return result;
    }

    public void addPiece(Piece piece){
        if(current == null){
            current = piece;
            piece.setTile(this);
        } else{
            System.err.println("Space already occupied");
        }
    }

    public String getPiece(){
        if(current==null){
            return "--";
        } else {
            return current.getName();
        }
    }
}
