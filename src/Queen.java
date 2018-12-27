import java.util.LinkedList;

public class Queen implements Piece {
    Board board;
    Tile tile;
    int colour;
    String name;

    public Queen(int colour){
        this.colour = colour;
        name = "q"+colour;
    }

    public LinkedList<Tile> getMoves(){
        LinkedList<Tile> result = new LinkedList<Tile>();
        //check each position horizontal, stopping once you've hit a piece or an edge


        //check each position diagonal, stopping once you've hit a piece or an edge

        return result;
    }

    //Gives all the possible moves for the piece
    public Tile move(Move newTile){
        return null;
    } //Moves the piece to the new position
    public boolean causesCheck(){
        return false;
    }   //checks to see if the piece causes check

    public String getName(){
        return name;
    }
}
