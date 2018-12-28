/**
 *
 * This is the main class that starts the game and allows players to interact with the game mechanics
 *
 */
public class Game {
    Tile[] board;  //The board which contains a number of board positions

    public static void main(String[] args){
        Board b = new Board();
        b.addPiece('k',0,3,5);
        b.addPiece('q',1,1,1);
        b.addPiece('q',1,8,5);
        b.addPiece('q',1,3,4);
        b.print();
        System.out.println("k0");
        for(Tile t: b.pieces.get(0).getMoves()){
            System.out.print(t.name+"\t");
        }
        System.out.println("\nq1");
        for(Tile t: b.pieces.get(1).getMoves()){
            System.out.print(t.name+"\t");
        }
        System.out.println("\nq2");
        for(Tile t: b.pieces.get(2).getMoves()){
            System.out.print(t.name+"\t");
        }
        System.out.println("\nq3");
        for(Tile t: b.pieces.get(3).getMoves()){
            System.out.print(t.name+"\t");
        }
        for(Piece p: b.pieces){
            System.out.println(p.causesCheck());
        }
    }
}