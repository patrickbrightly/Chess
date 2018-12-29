import java.util.LinkedList;

public class Knight implements Piece {
    Board board;
    Tile tile;
    int colour;
    String name;

    public Knight(int colour, Board board){
        this.colour = colour;
        name = "h"+colour;
        this.board = board;
    }

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
