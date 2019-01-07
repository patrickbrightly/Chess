package ChessMechanics;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * This is the main class that starts the game and allows players to interact with the game mechanics
 *
 */
public class Game {
    Board board;
    boolean gameOver;
    LinkedList<Move> moves;
    Scanner in;

    public Game() {
        in = new Scanner(System.in);
        moves = new LinkedList<Move>();
        gameOver = false;
//        board = setStandardBoard();
        board = new Board();
        board.addPiece('p',0,2,2);
        board.addPiece('p',1,1,1);
        board.print();
        //Game loop
        mainLoop();
//        for(int i=0;i<8;i++){
//            for(int j=0;j<8;j++){
//                System.out.print(board.board[i][j].name+"\t");
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args){
        Game g = new Game();
    }

    public void mainLoop(){
        while (!gameOver) {
            //white turn
            boolean validMove = false;
            while (!validMove) {
                //Select a piece
                System.out.println("Which piece would you like to move?");
                System.out.println("Row (1-8) then Col (1-8)");
                int row = in.nextInt() - 1;
                int col = in.nextInt() - 1;
                Piece selected = null;
                try {
                    if (board.whitePieces.contains(board.board[row][col].current)) {
                        selected = board.board[row][col].current;
                    } else {
                        System.out.println("This is not a valid piece, try again");
                    }
                    //select a destination
                    System.out.println("Where to?");
                    System.out.println("Row (1-8) then Column (1-8)");
                    row = in.nextInt() - 1;
                    col = in.nextInt() - 1;
                    if (selected.getMoves().contains(board.board[row][col])) {
                        Move move =new Move(selected, board.board[row][col],board,in);
                        moves.add(move);
                        validMove = true;
                    } else {
                        System.out.println("Not a valid move, try again");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("not a valid piece, try again");
                }
            }
            board.print();
            System.out.println("White played - HVal = "+board.evalutateBoard());
            //TODO Check for check/mate
            //Select a piece
            validMove = false;
            while (!validMove) {
                //Select a piece
                System.out.println("Which piece would you like to move?");
                System.out.println("Row (1-8) then Col (1-8)");
                int row = in.nextInt() - 1;
                int col = in.nextInt() - 1;
                Piece selected = null;
                try {
                    if (board.blackPieces.contains(board.board[row][col].current)) {
                        selected = board.board[row][col].current;
                    } else {
                        System.out.println("This is not a valid piece, try again");
                    }
                    //select a destination
                    System.out.println("Where to?");
                    System.out.println("Row (1-8) then Column (1-8)");
                    row = in.nextInt() - 1;
                    col = in.nextInt() - 1;
                    if (selected.getMoves().contains(board.board[row][col])) {
                        Move move =new Move(selected, board.board[row][col],board,in);
                        moves.add(move);
                        validMove = true;
                    } else {
                        System.out.println("Not a valid move, try again");
                    }
                } catch (Exception e) {
                    System.out.println("not a valid piece, try again");
                }
            }
            board.print();
            System.out.println("Black played - HVal = "+board.evalutateBoard());
            //TODO Check for check
        }
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