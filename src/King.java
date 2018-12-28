import java.util.LinkedList;

public class King implements Piece {
    Board board;
    Tile tile;
    int colour;
    String name;

    public King(int colour, Board board){
        this.colour = colour;
        name = "k"+colour;
        this.board = board;
    }

    public LinkedList<Tile> getMoves(){
        LinkedList<Tile> result = new LinkedList<Tile>();

        for(int i = -1;i<2;i++){
            for(int j = -1;j<2;j++){
                if ((tile.row + i) < 8 && (tile.row + i) >= 0 && (tile.col + j) < 8 && (tile.col + j) >= 0) {
                    if(board.board[tile.row+i][tile.col+j].current==null){
                        result.add(board.board[tile.row+i][tile.col+j]);
                    } else if(board.board[tile.row+i][tile.col+j].current.getColour()!=colour){
                        result.add(board.board[tile.row+i][tile.col+j]);
                    }
                }
            }
        }

        return result;
    }

    public void setTile(Tile newTile){
        this.tile = newTile;
    }

    //Gives all the possible moves for the piece
    public Tile move(Move newTile){
        return null;
    } //Moves the piece to the new position
    public boolean causesCheck(){
        boolean result = false;
        for (Tile t: getMoves()
        ) {
            if(t.current!=null){
                if(t.current.getClass()==King.class){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }   //checks to see if the piece causes check

    public String getName(){
        return name;
    }

    public int getColour(){
        return colour;
    }
}
