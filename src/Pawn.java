import java.util.LinkedList;

public class Pawn implements Piece {
    Board board;    //the board the piece is on
    Tile tile;      //the tile the piece is on
    int colour;     //the colour of the piece
    String name;    //the name of the piece (for ASCII representation)
    boolean moved;  //this keeps track of if a pawn has moved for the first move double move

    /**
     * This constructor creates a pawn
     * @param colour the colour of the pawn (0 for black, 1 for white)
     * @param board the board the pawn belongs to
     */
    public Pawn(int colour, Board board){
        this.colour = colour;
        name = "p"+colour;
        this.board = board;
        moved = false;
    }

    /**
     * This method returns a linked list of all the possible tiles the piece can legally move to
     * This method checks that a pawn can move forward, or capture diagonally
     * @return the list with all legal moves for this piece
     */
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

    /**
     * This method sets the piece to a tile
     * @param newTile the destination tile
     */
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
                if(t.current.getClass()==King.class && t.current.getColour()!=colour){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }   //checks to see if the piece causes check

    /**
     * This method returns the name of the piece (character/colour code)
     * @return piece's name
     */
    public String getName(){
        return name;
    }

    /**
     * This method returns the piece's colour
     * @return 0 if black, 1 if white
     */
    public int getColour(){
        return colour;
    }
}
