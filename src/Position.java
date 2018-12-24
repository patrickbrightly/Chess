import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * These are the spaces on the board.
 */
public class Position {
    int xPos; //the x Coordinate of the piece
    int yPos; //the y Coordinate of the piece
    String name; //the name of the position
    Piece current;

    public Position(int x, int y){
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
}
