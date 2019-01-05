import java.util.LinkedList;

public class Knight implements Piece {
    Board board;    //the board the piece is on
    Tile tile;      //the tile the piece is on
    int colour;     //the colour of the piece
    String name;    //the name of the piece (for ASCII representation)
    int value = 4;  //The base value of the piece

    /**
     * This constructor creates a knight
     * @param colour the colour of the knight (0 for black, 1 for white)
     * @param board the board the knight belongs to
     */
    public Knight(int colour, Board board){
        this.colour = colour;
        name = "h"+colour;
        this.board = board;
    }

    /**
     * This method returns a linked list of all the possible tiles the piece can legally move to
     * The method checks the 8 possible L-shaped moves.
     * @return the list with all legal moves for this piece
     */
    public LinkedList<Tile> getMoves(){
        LinkedList<Tile> result = new LinkedList<Tile>();
        //2 left, 1 up
        if((tile.col-2)>=0 && (tile.row-1)>=0){
            if(board.board[tile.row-1][tile.col-2].current==null){
                result.add(board.board[tile.row-1][tile.col-2]);
            } else if(board.board[tile.row-1][tile.col-2].current.getColour()!=colour){
                result.add(board.board[tile.row-1][tile.col-2]);
            }
        }
        //2 left, 1 down
        if((tile.col-2)>=0 && (tile.row+1)<8) {
            if (board.board[tile.row + 1][tile.col - 2].current == null) {
                result.add(board.board[tile.row + 1][tile.col - 2]);
            } else if (board.board[tile.row + 1][tile.col - 2].current.getColour() != colour) {
                result.add(board.board[tile.row + 2][tile.col - 2]);
            }
        }
        //1 left, 2 up
        if((tile.col-1)>=0 && (tile.row-2)>=0){
            if(board.board[tile.row-2][tile.col-1].current==null){
                result.add(board.board[tile.row-2][tile.col-1]);
            } else if(board.board[tile.row-2][tile.col-1].current.getColour()!=colour){
                result.add(board.board[tile.row-2][tile.col-1]);
            }
        }
        //1 left, 2 down
        if((tile.col-1)>=0 && (tile.row+2)<8){
            if(board.board[tile.row+2][tile.col-1].current==null){
                result.add(board.board[tile.row+2][tile.col-1]);
            } else if(board.board[tile.row+2][tile.col-1].current.getColour()!=colour){
                result.add(board.board[tile.row+2][tile.col-1]);
            }
        }
        //2 right, 1 up
        if((tile.col+2)<8 && (tile.row-1)>=0){
            if(board.board[tile.row-1][tile.col+2].current==null){
                result.add(board.board[tile.row-1][tile.col+2]);
            } else if(board.board[tile.row-1][tile.col+2].current.getColour()!=colour){
                result.add(board.board[tile.row-1][tile.col+2]);
            }
        }
        //2 left, 1 down
        if((tile.col+2)<8 && (tile.row+1)<8) {
            if (board.board[tile.row + 1][tile.col + 2 ].current == null) {
                result.add(board.board[tile.row + 1][tile.col + 2]);
            } else if (board.board[tile.row + 1][tile.col + 2].current.getColour() != colour) {
                result.add(board.board[tile.row + 2][tile.col + 2]);
            }
        }
        //1 left, 2 up
        if((tile.col+1)<8 && (tile.row-2)>=0){
            if(board.board[tile.row-2][tile.col+1].current==null){
                result.add(board.board[tile.row-2][tile.col+1]);
            } else if(board.board[tile.row-2][tile.col+1].current.getColour()!=colour){
                result.add(board.board[tile.row-2][tile.col+1]);
            }
        }
        //1 left, 2 down
        if((tile.col+1)<8 && (tile.row+2)<8){
            if(board.board[tile.row+2][tile.col+1].current==null){
                result.add(board.board[tile.row+2][tile.col+1]);
            } else if(board.board[tile.row+2][tile.col+1].current.getColour()!=colour){
                result.add(board.board[tile.row+2][tile.col+1]);
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
