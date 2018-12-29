import java.util.LinkedList;

public class Bishop implements Piece {
    Board board;    //the board the piece is on
    Tile tile;      //the tile the piece is on
    int colour;     //the colour of the piece
    String name;    //the name of the piece (for ASCII representation)

    /**
     * This constructor creates a bishop
     * @param colour the colour of the bishop (0 for black, 1 for white)
     * @param board the board the bishop belongs to
     */
    public Bishop(int colour, Board board){
        this.colour = colour;
        name = "b"+colour;
        this.board = board;
    }

    /**
     * This method returns a linked list of all the possible tiles the piece can legally move to
     * The method checks iteratively for further and further diagonals, stopping when a capture happens, or another piece of the same colour forces it to stop.
     * @return the list with all legal moves for this piece
     */
    public LinkedList<Tile> getMoves(){
        LinkedList<Tile> result = new LinkedList<Tile>();   //list of tiles it can move to
        //check all diagonals to the top left
        int i =  1;
        while(tile.col-i>=0 && tile.row-i>=0){
            if(board.board[tile.row-i][tile.col-i].current==null){
                result.add(board.board[tile.row-i][tile.col-i]);
                i++;
            } else if(board.board[tile.row-i][tile.col-i].current.getColour()==colour){
                break;  //if the piece is of the same colour, stop searching
            } else{
                result.add(board.board[tile.row-i][tile.col-i]);
                break; //if the piece if of a different colour, capture and stop here
            }
        }
        //check all diagonals to the bottom right, similar to first code block
        i =  1;
        while(tile.col+i<8 && tile.row+i<8){
            if(board.board[tile.row+i][tile.col+i].current==null){
                result.add(board.board[tile.row+i][tile.col+i]);
                i++;
            } else if(board.board[tile.row+i][tile.col+i].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[tile.row+i][tile.col+i]);
                break;
            }
        }
        //check the top right
        i =  1;
        while(tile.col+i<8 && tile.row-i>=0){
            if(board.board[tile.row-i][tile.col+i].current==null){
                result.add(board.board[tile.row-i][tile.col+i]);
                i++;
            } else if(board.board[tile.row-i][tile.col+i].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[tile.row-i][tile.col+i]);
                break;
            }
        }
        //check the bottom left
        i =  1;
        while(tile.col-i>=0 && tile.row+i<8){
            if(board.board[tile.row+i][tile.col-i].current==null){
                result.add(board.board[tile.row+i][tile.col-i]);
                i++;
            } else if(board.board[tile.row+i][tile.col-i].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[tile.row+i][tile.col-i]);
                break;
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

    /**
     * This method checks to see if the piece causes check for the enemy
     * @return true if the piece causes check
     */
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

    /**
     * This method returns the tile this piece is on
     * @return this piece's tile
     */
    public Tile getTile(){
        return tile;
    }

    /**
     * This method removes the captured piece from the available enemy pieces
     * @param moveTo the tile that is being moved to
     */
    public void capture(Tile moveTo){
        Piece p = moveTo.current;
        if(p.getColour()==0){
            board.blackPieces.remove(p);
        } else {
            board.whitePieces.remove(p);
        }
        board.pieces.remove(p);
    }
}
