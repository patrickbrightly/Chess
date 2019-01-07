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
    Scanner in;

    public Move(Piece piece, Tile moveTo, Board board, Scanner in){
        this.board = board;
        this.piece = piece;
        this.from = piece.getTile();
        this.to = moveTo;
        if(piece.getMoves().contains(moveTo)){ //check the move is legal
            if(!moveTo.isEmpty()){ //remove the captured piece if the square is occupied
                piece.capture(moveTo);
            }
            from.current = null;    //empty the move from
            to.current = piece;     //put the piece in the tile
            piece.setTile(moveTo);  //tell the piece which tile it's on
            piece.setMoved();
        }
        if(piece.getName().charAt(0)=='p'){
            if(piece.getColour()==0 && piece.getTile().row==0){
                    System.out.println("Change your pawn to a new piece");
                    System.out.println("Queen - q");
                    System.out.println("Bishop - b");
                    System.out.println("Rook - r");
                    System.out.println("Knight - h");
                    char newPieceChar = in.next().charAt(0);
                    System.out.println("Character "+ newPieceChar);
                    //create a new piece, remove the pawn
                    piece = changePawn(piece,newPieceChar);
                System.out.println(piece.getName());
                System.out.println(piece.getTile().name);
            }
        }
    }

    /**
     * This method returns the string representation of the move
     * @return String representation of the move
     */
    @Override
    public String toString() {
        return (from.name + to.name);
    }

    public Piece changePawn(Piece pawn, char newPiece){
        System.out.println("Start method");
        Piece result = null;
        //set the tile to empty
        pawn.getTile().current = null;
        //remove the piece from the game
        board.pieces.remove(pawn);
        if(pawn.getColour()==0){
            board.blackPieces.remove(pawn);
            System.out.println("Black piece removed");
        } else{
            board.whitePieces.remove(pawn);
            System.out.println("White piece removed");
        }
        //add a new piece of type specified
        result = board.addPiece(newPiece,pawn.getColour(),pawn.getTile().row,pawn.getTile().col);
        System.out.println("New piece" + result.getName());
        return result;
    }
}
