/**
 *
 * This is the main class that starts the game and allows players to interact with the game mechanics
 *
 */
public class Game {
    Tile[] board;  //The board which contains a number of board positions

    public static void main(String[] args){
        Board b = new Board();
        b.addPiece('q',0,8,8);
        b.addPiece('q',1,1,1);
        b.print();
    }
}