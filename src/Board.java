import java.util.List;

/**
 * This class is the board itself and contains all the positions for the chess board
 */
public class Board {
    List<Piece> pieces; //contains a list of all the pieces on the board
    Position[][] board;   //the actual board and each position on the board

    public Board(){
        board = new Position[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j] = new Position(i,j);
                System.out.print(board[i][j].name+"\t");
            }
            System.out.println();
        }
    }
}
