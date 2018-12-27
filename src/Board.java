import java.util.List;

/**
 * This class is the board itself and contains all the positions for the chess board
 */
public class Board {
    List<Piece> pieces; //contains a list of all the pieces on the board
    Tile[][] board;   //the actual board and each position on the board

    public Board(){
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
                break;
            case 'r':
                break;
            case 'h':
                break;
            case 'b':
                break;
            case 'k':

                break;
            case 'q':
                Queen q = new Queen(colour);
                board[row-1][col-1].addPiece(q);
                break;
        }
    }

    public void print(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j].getPiece());
            }
            System.out.println();
        }
    }
}
