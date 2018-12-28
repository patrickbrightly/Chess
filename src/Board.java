import java.util.LinkedList;
import java.util.List;

/**
 * This class is the board itself and contains all the positions for the chess board
 */
public class Board {
    LinkedList<Piece> pieces; //contains a list of all the pieces on the board
    LinkedList<Piece> blackPieces;
    LinkedList<Piece> whitePieces;
    Tile[][] board;   //the actual board and each position on the board

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

    /**
     *
     * @param piece is the character representing piece to be added
     * @param colour 0 for black, 1 for white
     * @param row is the row
     * @param col is the column
     */
    public void addPiece(char piece,int colour,int row, int col){
        switch (piece){
            case 'p':
                Pawn p = new Pawn(colour,this);
                board[row-1][col-1].addPiece(p);
                pieces.add(p);
                if(colour==0){
                    blackPieces.add(p);
                } else {
                    whitePieces.add(p);
                }
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
                break;
        }
    }

    public void print(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j].getPiece()+"\t");
            }
            System.out.println();
        }
    }
}
