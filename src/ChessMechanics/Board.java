package ChessMechanics;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class is the board itself and contains all the positions for the chess board
 */
public class Board {
    LinkedList<Piece> pieces; //contains a list of all the pieces on the board
    LinkedList<Piece> blackPieces;  //contains all black pieces in play
    LinkedList<Piece> whitePieces;  //contains all white pieces in play
    Tile[][] board;   //the actual board and each position on the board

    /**
     * This method creates a standard 8x8 board with no pieces
     */
    public Board(){
        pieces = new LinkedList<Piece>();
        blackPieces = new LinkedList<Piece>();
        whitePieces = new LinkedList<Piece>();
        board = new Tile[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j] = new Tile(i,j);
            }
        }
    }

    public Board(Board b, Tile from, Tile to){
        pieces = new LinkedList<Piece>();
        blackPieces = new LinkedList<Piece>();
        whitePieces = new LinkedList<Piece>();
        board = new Tile[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j] = new Tile(b.board[i][j]);
                Piece piece = b.board[i][j].current;
                if(b.board[i][j].current!=null){
                    switch (piece.getName().charAt(0)) {
                        case 'p':
                            Pawn p = new Pawn(piece.getColour(), this);
                            p.setMoved();
                            board[piece.getTile().row][piece.getTile().col].addPiece(p);
                            pieces.add(p);
                            if (piece.getColour() == 0) {
                                blackPieces.add(p);
                            } else {
                                whitePieces.add(p);
                            }
                            break;
                        case 'q':
                            Queen q = new Queen(piece.getColour(), this);
                            board[piece.getTile().row][piece.getTile().col].addPiece(q);
                            pieces.add(q);
                            if (piece.getColour() == 0) {
                                blackPieces.add(q);
                            } else {
                                whitePieces.add(q);
                            }
                            break;
                        case 'k':
                            King k = new King(piece.getColour(), this);
                            board[piece.getTile().row][piece.getTile().col].addPiece(k);
                            pieces.add(k);
                            if (piece.getColour() == 0) {
                                blackPieces.add(k);
                            } else {
                                whitePieces.add(k);
                            }
                            break;
                        case 'h':
                            Knight h = new Knight(piece.getColour(), this);
                            board[piece.getTile().row][piece.getTile().col].addPiece(h);
                            pieces.add(h);
                            if (piece.getColour() == 0) {
                                blackPieces.add(h);
                            } else {
                                whitePieces.add(h);
                            }
                            break;
                        case 'b':
                            Bishop bi = new Bishop(piece.getColour(), this);
                            board[piece.getTile().row][piece.getTile().col].addPiece(bi);
                            pieces.add(bi);
                            if (piece.getColour() == 0) {
                                blackPieces.add(bi);
                            } else {
                                whitePieces.add(bi);
                            }
                            break;
                        case 'r':
                            Rook r = new Rook(piece.getColour(), this);
                            board[piece.getTile().row][piece.getTile().col].addPiece(r);
                            pieces.add(r);
                            if (piece.getColour() == 0) {
                                blackPieces.add(r);
                            } else {
                                whitePieces.add(r);
                            }
                            break;
                    }
                }
            }
        }
        new Move(board[from.row][from.col].current,board[to.row][to.col],this,new Scanner(System.in));
    }

    /**
     * This method adds a single piece to the board using 1-8 for rows and columns
     * It also places the pieces in their respective lists
     * @param piece is the character representing piece to be added
     * @param colour 0 for black, 1 for white
     * @param row is the row
     * @param col is the column
     */
    public Piece addPiece(char piece,int colour,int row, int col){
        Piece result = null;
        switch (piece){ //determines which piece to place
            case 'p':
                Pawn p = new Pawn(colour,this);
                board[row-1][col-1].addPiece(p);
                pieces.add(p);
                if(colour==0){
                    blackPieces.add(p);
                } else {
                    whitePieces.add(p);
                }
                result = p;
                break;
            case 'r':
                Rook r = new Rook(colour,this);
                board[row-1][col-1].addPiece(r);
                pieces.add(r);
                if(colour==0){
                    blackPieces.add(r);
                } else {
                    whitePieces.add(r);
                }
                result = r;
                break;
            case 'h':
                Knight h = new Knight(colour,this);
                board[row-1][col-1].addPiece(h);
                pieces.add(h);
                if(colour==0){
                    blackPieces.add(h);
                } else {
                    whitePieces.add(h);
                }
                result = h;
                break;
            case 'b':
                Bishop b = new Bishop(colour,this);
                board[row-1][col-1].addPiece(b);
                pieces.add(b);
                if(colour==0){
                    blackPieces.add(b);
                } else {
                    whitePieces.add(b);
                }
                result = b;
                break;
            case 'k':
                King k = new King(colour,this);
                board[row-1][col-1].addPiece(k);
                pieces.add(k);
                if(colour==0){
                    blackPieces.add(k);
                } else {
                    whitePieces.add(k);
                }
                result = k;
                break;
            case 'q':
                Queen q = new Queen(colour,this);
                board[row-1][col-1].addPiece(q);
                pieces.add(q);
                if(colour==0){
                    blackPieces.add(q);
                } else {
                    whitePieces.add(q);
                }
                result = q;
                break;
        }
        return result;
    }

    /**
     * This method prints an ASCII representation of the board to the console with 1A in the top left
     */
    public void print(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j].getPiece()+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This function evaluates the board. + is in favour or white, - in favour of black
     * @return board value
     * Method adapted (simplified) from Shannon (1950), proper citation needed
     */
    public int evalutateBoard(){
        int result = 0;
        for(Piece p: whitePieces){
            result = result + p.getHValue();
        }
        for(Piece p: blackPieces){
            result = result - p.getHValue();
        }
        return result;
    }

    public boolean isCheck(){
        boolean result = false;
        //can any black piece cause check?

        //can any white piece cause check?

        return result;
    }
}
