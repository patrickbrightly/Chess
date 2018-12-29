/**
 *
 * This is the main class that starts the game and allows players to interact with the game mechanics
 *
 */
public class Game {
    Tile[] board;  //The board which contains a number of board positions

    public static void main(String[] args){
//        Game g = new Game();
        Board b = new Board();
        b.addPiece('h',0,3,3);
        b.addPiece('q',1,1,3);
//        b.addPiece('q',1,3,4);
        b.print();
        System.out.println();
        new Move(b.pieces.getFirst(),b.board[1][0]);
        b.print();
        System.out.println();
        new Move(b.pieces.getFirst(),b.board[0][2]);
        b.print();
        System.out.println();
        new Move(b.pieces.getFirst(),b.board[0][4]);
        b.print();
    }

    /**
     * This method sets up a standard chess board configuration
     * @return a new board with the black pieces in rows 7/8 and white in rows 1/2
     */
    public Board setStandardBoard(){
        Board result = new Board();
        result.addPiece('r',1,1,1);
        result.addPiece('h',1,1,2);
        result.addPiece('b',1,1,3);
        result.addPiece('k',1,1,4);
        result.addPiece('q',1,1,5);
        result.addPiece('b',1,1,6);
        result.addPiece('h',1,1,7);
        result.addPiece('r',1,1,8);
        result.addPiece('r',0,8,1);
        result.addPiece('h',0,8,2);
        result.addPiece('b',0,8,3);
        result.addPiece('k',0,8,4);
        result.addPiece('q',0,8,5);
        result.addPiece('b',0,8,6);
        result.addPiece('h',0,8,7);
        result.addPiece('r',0,8,8);
        for(int i=1;i<=8;i++){
            result.addPiece('p',1,2,i);
            result.addPiece('p',0,7,i);
        }
        return result;
    }
}