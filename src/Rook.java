import java.util.LinkedList;

public class Rook implements Piece {
    Board board;    //the board the piece is on
    Tile tile;      //the tile the piece is on
    int colour;     //the colour of the piece
    String name;    //the name of the piece (for ASCII representation)

    /**
     * This constructor creates a rook
     * @param colour the colour of the rook (0 for black, 1 for white)
     * @param board the board the rook belongs to
     */
    public Rook(int colour, Board board){
        this.colour = colour;
        name = "r"+colour;
        this.board = board;
    }

    /**
     * This method returns a linked list of all the possible tiles the piece can legally move to
     * The method checks iteratively for further and further orthogonal moves,
     * stopping when a capture happens, or another piece of the same colour forces it to stop.
     * @return the list with all legal moves for this piece
     */
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
