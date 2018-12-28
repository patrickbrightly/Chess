import java.util.LinkedList;

public class Pawn implements Piece {
    Board board;
    Tile tile;
    int colour;
    String name;
    boolean moved;

    public Pawn(int colour, Board board){
        this.colour = colour;
        name = "p"+colour;
        this.board = board;
        moved = false;
    }

    public LinkedList<Tile> getMoves(){
        LinkedList<Tile> result = new LinkedList<Tile>();
        //black pawns move in the negative, white in the positive
        if(colour == 0){
            //check the tile 1 ahead, unless at the last row
            if(tile.row-1>=0 && board.board[tile.row-1][tile.col].current==null) {
                result.add(board.board[tile.row - 1][tile.col]);
                //check the second tile ahead only if you haven't moved yet
                if (!moved && board.board[tile.row - 2][tile.col].current == null) {
                    result.add(board.board[tile.row - 2][tile.col]);
                }
            }
            if(tile.row-1>=0 && tile.col-1>=0 && board.board[tile.row-1][tile.col-1].current!=null && board.board[tile.row-1][tile.col-1].current.getColour()!=colour){
                result.add(board.board[tile.row-1][tile.col-1]);
            }
            if(tile.row-1>=0 && tile.col+1<8 && board.board[tile.row-1][tile.col+1].current!=null && board.board[tile.row-1][tile.col+1].current.getColour()!=colour){
                result.add(board.board[tile.row-1][tile.col+1]);
            }
        } else {
            //check the tile 1 ahead, unless at the last row
            if(tile.row+1>=0 && board.board[tile.row+1][tile.col].current==null) {
                result.add(board.board[tile.row + 1][tile.col]);
                //check the second tile ahead only if you haven't moved yet
                if (!moved && board.board[tile.row + 2][tile.col].current == null) {
                    result.add(board.board[tile.row + 2][tile.col]);
                }
            }
            if(tile.row+1>=0 && tile.col-1>=0 && board.board[tile.row+1][tile.col-1].current!=null && board.board[tile.row+1][tile.col-1].current.getColour()!=colour){
                result.add(board.board[tile.row+1][tile.col-1]);
            }
            if(tile.row+1>=0 && tile.col+1<8 && board.board[tile.row+1][tile.col+1].current!=null && board.board[tile.row+1][tile.col+1].current.getColour()!=colour){
                result.add(board.board[tile.row+1][tile.col+1]);
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
