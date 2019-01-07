import java.util.LinkedList;
import java.util.List;

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

    /**
     * This method adds a single piece to the board using 1-8 for rows and columns
     * It also places the pieces in their respective lists
     * @param piece is the character representing piece to be added
     * @param colour 0 for black, 1 for white
     * @param row is the row
     * @param col is the column
     */
    public Piece addPiece(char piece,int colour,int row, int col){
        System.out.println("adding "+piece);
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
                System.out.println("adding h");
                Knight h = new Knight(colour,this);
                System.out.println("new knight name " +h.name);
                board[row-1][col-1].addPiece(h);
                System.out.println("new knight: "+board[row-1][col-1]);
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
}
