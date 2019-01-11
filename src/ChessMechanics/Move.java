package ChessMechanics;

import java.util.Scanner;

/**
 * This class encapsulates the moves made by any piece.
 * This will be used to keep track of the moves as they take place
 */
public class Move {
    Board board;
    Piece piece;    //the piece which was moved
    Tile from;      //the tile it moved from
    Tile to;        //the tile it moved to
    String name;    //The move name

    public Move(Piece piece, Tile moveTo, Board board){
        name = new String();
        this.board = board;
        this.piece = piece;
        name = name + piece.getName();
        this.from = piece.getTile();
        name = name + from.getName();
        this.to = moveTo;
        if(piece.getMoves().contains(moveTo)){ //check the move is legal
            if(!moveTo.isEmpty()){ //remove the captured piece if the square is occupied
                piece.capture(moveTo);
                name = name + "X";
            }
            from.current = null;    //empty the move from
            to.current = piece;     //put the piece in the tile
            piece.setTile(moveTo);  //tell the piece which tile it's on
            piece.setMoved();
            name = name + moveTo.getName();
        }
        if(piece.getName().charAt(0)=='p'){
            if(piece.getColour()==1 && piece.getTile().row==0){
                piece = changePawn(piece,'q');
            } else if(piece.getColour()==0 && piece.getTile().row==7){
                piece = changePawn(piece,'q');
            }
        }
    }
    
    /**
     * This method promotes a pawn upon reaching the opposite side of the board.
     * Currently it just promotes the pawn to a queen
     * @param pawn the pawn being promoted
     * @param newPiece the piece it should e promoted to
     * @return 
     */
    public Piece changePawn(Piece pawn, char newPiece){
        Piece result = null;
        //set the tile to empty
        pawn.getTile().current = null;
        //remove the piece from the game
        board.pieces.remove(pawn);
        if(pawn.getColour()==1){
            board.blackPieces.remove(pawn);
        } else{
            board.whitePieces.remove(pawn);
        }
        //add a new piece of type specified
        result = board.addPiece(newPiece,pawn.getColour(),pawn.getTile().row+1,pawn.getTile().col+1);
        return result;
    }

    public String getName() {
        return name;
    }

    public Tile getFrom() {
        return from;
    }
    
    
    
}
