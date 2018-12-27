import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * These are the spaces on the board.
 */
public class Tile {
    int xPos; //the x Coordinate of the piece
    int yPos; //the y Coordinate of the piece
    String name; //the name of the position
    Piece current;

    public Tile(int x, int y){
        current = null;
        name = (x+1)+""+(char)(y+65);
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
