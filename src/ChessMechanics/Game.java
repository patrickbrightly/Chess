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
        board = new Board();
        board = setStandardBoard();
//        board.addPiece('p',0,2,2);
//        board.addPiece('p',0,7,1);
//        board.addPiece('h',1,2,3);
//        board.addPiece('h',0,7,3);
//        board.print();
        //Game loop
//        mainLoop();
//        for(int i=0;i<8;i++){
//            for(int j=0;j<8;j++){
//                System.out.print(board.board[i][j].name+"\t");
//            }
//            System.out.println();
//        }
//        miniMaxDecision(board);
    }

    public static void main(String[] args){
        Game g = new Game();
    }

    public void mainLoop(){
        boolean blackCheck = false;
        boolean whiteCheck = false;
        boolean blackCheckMate = false;
        boolean whiteCheckMate = false;
        while (!blackCheckMate || !whiteCheckMate) {
            //white turn
            boolean validMove = false;
            while (!validMove) {
                //Select a piece
                System.out.println("Which white piece would you like to move?");
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
                        Move move = new Move(selected, board.board[row][col],board);
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
            //check for black king check
            for(Piece p: board.whitePieces){
                if(p.causesCheck()){
                    blackCheck = true;
                    System.out.println("blackcheck"+blackCheck);
                }
            }
            if(blackCheck){
                blackCheckMate = true;
                Piece k=null;//get the black king
                for(Piece p:board.blackPieces){
                    if(p.getClass()==King.class){
                        k = p;
                    }
                }
                System.out.println("Black king is in check");
                //TODO check for checkmate
                //check each position that the king can move to
                //if it can move, then it's not check
                LinkedList<Tile> whitePieceMoves = new LinkedList<Tile>();
                for(Piece p : board.whitePieces){
                    whitePieceMoves.addAll(p.getMoves());
                }
                for(Tile t: k.getMoves()){

                    for(Piece p: board.whitePieces){

                    }
                }
                //check if the capturing pieces can be captured or blocked
            }
            Move m = miniMaxDecision(board);
            board.print();
            System.out.println("Black played - HVal = "+board.evalutateBoard());
            for(Piece p: board.blackPieces){
                if(p.causesCheck()){
                    whiteCheck = true;
                    System.out.println("whitecheck"+whiteCheck);
                }
            }
            if(whiteCheck){
                System.out.println("White king is in check");
                //TODO check for checkmate
            }
        }
    }

    /**
     * This method sets up a standard chess board configuration
     * @return a new board with the black pieces in rows 7/8 and white in rows 1/2
     */
    public Board setStandardBoard(){
        Board result = new Board();
                for(int i=1;i<=8;i++){
            result.addPiece('p',0,2,i);
            result.addPiece('p',1,7,i);
        }
        result.addPiece('r',0,1,1);
        result.addPiece('h',0,1,2);
        result.addPiece('b',0,1,3);
        result.addPiece('q',0,1,4);
        result.addPiece('k',0,1,5);
        result.addPiece('b',0,1,6);
        result.addPiece('h',0,1,7);
        result.addPiece('r',0,1,8);
        result.addPiece('r',1,8,1);
        result.addPiece('h',1,8,2);
        result.addPiece('b',1,8,3);
        result.addPiece('q',1,8,4);
        result.addPiece('k',1,8,5);
        result.addPiece('b',1,8,6);
        result.addPiece('h',1,8,7);
        result.addPiece('r',1,8,8);
//        for(int i=1;i<=8;i++){
//            result.addPiece('p',0,2,i);
//            result.addPiece('p',1,7,i);
//        }
        return result;
    }

    /**
     * This method takes in a board state
     * This method is hardcoded for a ply of 3
     */
    public Move miniMaxDecision(Board board){
//        Move result = null;
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
        int currentPly = 1;
        LinkedList<Board> frontier = getSuccessors(board,0);
//        for(Piece p:board.blackPieces){
//            for(Tile tile:p.getMoves()){
//                //add the new board to the frontier
//                Board nextBoard = new Board(board,p.getTile(),tile);
//                //move the piece to the tile needed
//                frontier.add(nextBoard);
////                moves.add(new Move(p,tile,board,"s"));
//            }
//        }
        LinkedList<Integer> vals = new LinkedList<Integer>();
        for(Board b:frontier){
            Integer v = maximize(b,alpha,beta,1);
            vals.add(v);
        }
        System.out.println(vals);
        Integer lowest = Integer.MAX_VALUE;
        for(Integer i:vals){
            if(i<lowest){
                lowest=i;
            }
        }
        System.out.println(vals.indexOf(lowest));
        System.out.println(lowest);
        Board bestBoard = frontier.get(vals.indexOf(lowest));
        System.out.println(bestBoard.startPosition.getCurrent().getName()+bestBoard.endPosition.getName());
        return new Move(bestBoard.startPosition.getCurrent(),bestBoard.endPosition,board);
    }

    public int minimize(Board b,int alpha, int beta, int ply){
        int v = Integer.MAX_VALUE;
        if(ply>=3){
            return b.evalutateBoard();
        }
        //if even ply, white pieces, else black pieces
       LinkedList<Board> frontier = getSuccessors(b,1);
       for(Board b1:frontier){
           v = Math.min(v, maximize(b1,alpha,beta,ply+1));
           if(v<=alpha){
                return v;
           }
           beta = Math.min(beta,v);
       }
        return v;
    }
    
    public int maximize(Board b,int alpha, int beta, int ply){
        int v = Integer.MIN_VALUE;
        if(ply>=3){
            return b.evalutateBoard();
        }
        //if even ply, white pieces, else black pieces
       LinkedList<Board> frontier = new LinkedList<Board>();
               frontier.addAll(getSuccessors(b,0));
       for(Board b1:frontier){
           v = Math.max(v, minimize(b1,alpha,beta,ply+1));
           if(v>=beta){
                return v;
           }
           alpha = Math.max(alpha,v);
       }
        return v;
    }
    
    public LinkedList<Board> getSuccessors(Board b,int colour){
        LinkedList<Board> result = new LinkedList<Board>();
        LinkedList<Piece> pieces;
        if(colour==0){
            pieces = b.blackPieces;
        } else {
            pieces = b.whitePieces;
        }
        for(Piece p:pieces){
            for(Tile tile:p.getMoves()){
                //add the new board to the frontier
                Board nextBoard = new Board(b,p.getTile(),tile);
                //move the piece to the tile needed
                result.add(nextBoard);
//                moves.add(new Move(p,tile,board,"s"));
            }
        }
        return result;
    }
    

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    

}