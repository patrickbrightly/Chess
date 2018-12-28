import java.util.LinkedList;

public class Bishop implements Piece {
    Board board;
    Tile tile;
    int colour;
    String name;

    public Bishop(int colour, Board board){
        this.colour = colour;
        name = "b"+colour;
        this.board = board;
    }

    public LinkedList<Tile> getMoves(){
        LinkedList<Tile> result = new LinkedList<Tile>();
        //check all diagonals to the top left
        int i =  1;
        while(tile.col-i>=0 && tile.row-i>=0){
            if(board.board[tile.row-i][tile.col-i].current==null){
                result.add(board.board[tile.row-i][tile.col-i]);
                i++;
            } else if(board.board[tile.row-i][tile.col-i].current.getColour()==colour){
                break;
            } else{
                result.add(board.board[tile.row-i][tile.col-i]);
                break;
            }
        }
        //check all diagonals to the bottom right
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
