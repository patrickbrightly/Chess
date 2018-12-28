import java.util.LinkedList;

public class Rook implements Piece {
    Board board;
    Tile tile;
    int colour;
    String name;

    public Rook(int colour, Board board){
        this.colour = colour;
        name = "r"+colour;
        this.board = board;
    }

    public LinkedList<Tile> getMoves(){
        LinkedList<Tile> result = new LinkedList<Tile>();
        //check all positions to the left
        for(int i = tile.col-1; i>=0;i--){
            if(board.board[tile.row][i].current==null){
                result.add(board.board[tile.row][i]);
            } else if(board.board[tile.row][i].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[tile.row][i]);
                break;
            }
        }
        //check all positions to the right
        for(int i = tile.col+1; i<8;i++){
            if(board.board[tile.row][i].current==null){
                result.add(board.board[tile.row][i]);
            } else if(board.board[tile.row][i].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[tile.row][i]);
                break;
            }
        }
        //check all positions above
        for(int i = tile.row-1; i>=0;i--){
            if(board.board[i][tile.col].current==null){
                result.add(board.board[i][tile.col]);
            } else if(board.board[i][tile.col].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[i][tile.col]);
                break;
            }
        }
        //check all positions below
        for(int i = tile.row+1; i<8;i++){
            if(board.board[i][tile.col].current==null){
                result.add(board.board[i][tile.col]);
            } else if(board.board[i][tile.col].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[i][tile.col]);
                break;
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
