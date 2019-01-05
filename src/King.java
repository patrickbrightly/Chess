import java.util.LinkedList;

public class King implements Piece {
    Board board;    //the board the piece is on
    Tile tile;      //the tile the piece is on
    int colour;     //the colour of the piece
    String name;    //the name of the piece (for ASCII representation)
    int value = 10;  //The base value of the piece

    /**
     * This constructor creates a king
     * @param colour the colour of the king (0 for black, 1 for white)
     * @param board the board the king belongs to
     */
    public King(int colour, Board board){
        this.colour = colour;
        name = "k"+colour;
        this.board = board;
    }

    /**
     * This method returns a linked list of all the possible tiles the piece can legally move to
     * @return the list with all legal moves for this piece
     */
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

    /**
     * This method returns the value of the piece in question
     * @return heuristic value
     */
    public int getHValue(){
        int result = 0;
        result = getMoves().size();
        result = value*result;
        return result;
    }
}
