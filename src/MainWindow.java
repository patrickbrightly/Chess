package Window;

import ChessMechanics.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        setImagePaths(); // set imagepathstrings
        initComponents(); // sets font and colours > contains buildlayout which creates component spacing
        setButtonNames();
        addButtonListeners(); //adds listeners
        game = new Game();    //ASSUMES creating a standard board
        currentBoard = game.getBoard();
        currentBoard.print();
        drawBoard(currentBoard); //start game
        //action listener method continues once board is drawm
    }

    /**
     * Class executes code when buttons are pressed, MAIN LOOP will exist in this method
     */
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //TODO: only for one colour, ie only allow movement of white
            if (secondClick == false) { // if its a first click
                startPosition = (JButton) e.getSource();  //set starting button
                Tile[][] tileArray = currentBoard.getBoard();  // get the piece from the board
                char[] startArray = startPosition.getName().toCharArray();
                pieceFrom = tileArray[startArray[0] - 49][Character.getNumericValue(startArray[1]) - 10].getCurrent();
                //System.out.println("startpos: "+startPosition.getName()); //TODO remove, testing
                secondClick = true;  //set flag to designate second click
            } else { //its a second click
                try {
                    endPosition = (JButton) e.getSource(); //set end button
                    Tile[][] tileArray = currentBoard.getBoard();  // use board to get end tile
                    char[] endArray = endPosition.getName().toCharArray();
                    tileFrom = tileArray[endArray[0] - 49][Character.getNumericValue(endArray[1]) - 10];
                    //System.out.println("endpos: " + endPosition.getName()); //TODO remove, testing

                    Move m = new Move(pieceFrom, tileFrom, currentBoard); //move piece to new tile

                    ImageIcon empty = new ImageIcon(emptyPiecePath);  //make moved area empty
                    startPosition.setIcon(empty);
                    currentBoard.print(); //TODO remove, for testing
                    
                    m = game.miniMaxDecision(currentBoard);
                    mapButton(m.getFrom().getName(),null).setIcon(empty);
                    drawBoard(currentBoard);
                    currentBoard.print();
                    //TODO if(currentBoard.checkmate() gameOver
                    

                } catch (NullPointerException exception) {
                    // do nothing
                }
                secondClick = false; //reset flag
                pieceFrom = null; //reset variables
                tileFrom = null;
                startPosition = null;
                endPosition = null;

            }
            //TODO print board, new game buttons etc
            //TODO add moves to the move window
      }

    }

    /**
     * adds action listeners to every tile.
     */
    private void addButtonListeners() {
        newGameButton.addActionListener(new ButtonListener());
        endGameButton.addActionListener(new ButtonListener());
        A8.addActionListener(new ButtonListener());
        A7.addActionListener(new ButtonListener());
        A6.addActionListener(new ButtonListener());
        A5.addActionListener(new ButtonListener());
        A4.addActionListener(new ButtonListener());
        A3.addActionListener(new ButtonListener());
        A2.addActionListener(new ButtonListener());
        A1.addActionListener(new ButtonListener());

        B8.addActionListener(new ButtonListener());
        B7.addActionListener(new ButtonListener());
        B6.addActionListener(new ButtonListener());
        B5.addActionListener(new ButtonListener());
        B4.addActionListener(new ButtonListener());
        B3.addActionListener(new ButtonListener());
        B2.addActionListener(new ButtonListener());
        B1.addActionListener(new ButtonListener());

        C8.addActionListener(new ButtonListener());
        C7.addActionListener(new ButtonListener());
        C6.addActionListener(new ButtonListener());
        C5.addActionListener(new ButtonListener());
        C4.addActionListener(new ButtonListener());
        C3.addActionListener(new ButtonListener());
        C2.addActionListener(new ButtonListener());
        C1.addActionListener(new ButtonListener());

        D8.addActionListener(new ButtonListener());
        D7.addActionListener(new ButtonListener());
        D6.addActionListener(new ButtonListener());
        D5.addActionListener(new ButtonListener());
        D4.addActionListener(new ButtonListener());
        D3.addActionListener(new ButtonListener());
        D2.addActionListener(new ButtonListener());
        D1.addActionListener(new ButtonListener());

        E8.addActionListener(new ButtonListener());
        E7.addActionListener(new ButtonListener());
        E6.addActionListener(new ButtonListener());
        E5.addActionListener(new ButtonListener());
        E4.addActionListener(new ButtonListener());
        E3.addActionListener(new ButtonListener());
        E2.addActionListener(new ButtonListener());
        E1.addActionListener(new ButtonListener());

        F8.addActionListener(new ButtonListener());
        F7.addActionListener(new ButtonListener());
        F6.addActionListener(new ButtonListener());
        F5.addActionListener(new ButtonListener());
        F4.addActionListener(new ButtonListener());
        F3.addActionListener(new ButtonListener());
        F2.addActionListener(new ButtonListener());
        F1.addActionListener(new ButtonListener());

        G8.addActionListener(new ButtonListener());
        G7.addActionListener(new ButtonListener());
        G6.addActionListener(new ButtonListener());
        G5.addActionListener(new ButtonListener());
        G4.addActionListener(new ButtonListener());
        G3.addActionListener(new ButtonListener());
        G2.addActionListener(new ButtonListener());
        G1.addActionListener(new ButtonListener());

        H8.addActionListener(new ButtonListener());
        H7.addActionListener(new ButtonListener());
        H6.addActionListener(new ButtonListener());
        H5.addActionListener(new ButtonListener());
        H4.addActionListener(new ButtonListener());
        H3.addActionListener(new ButtonListener());
        H2.addActionListener(new ButtonListener());
        H1.addActionListener(new ButtonListener());
    }

    ;

    /**
     * places the buttons and labels in the correct positions
     */
    private void buildLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(left7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(left5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(left3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(left2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addComponent(left1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(left4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(left6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(left8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(G8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(H8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lowerA, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(lowerB, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(lowerC, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(lowerD, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(lowerE, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(lowerF, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(lowerG, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(lowerH, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(A5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, 0)
                                                                                .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(right8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(upperA, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(upperB, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(upperC, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(upperD, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(upperE, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(upperF, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(upperG, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(upperH, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(endGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(printBoardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(moveListTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(moveListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(firstPlayer)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(secondPlayer)))))
                                .addContainerGap(57, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{A1, A2, A3, A4, A6, A7, A8, B1, B2, B3, B4, B5, B6, B7, B8, C1, C2, C3, C4, C5, C6, C7, C8, D1, D2, D3, D4, D5, D6, D7, D8, E1, E2, E3, E4, E5, E6, E7, E8, F1, F2, F3, F4, F5, F6, F7, F8, G1, G2, G3, G4, G5, G6, G7, G8, H1, H2, H3, H4, H5, H6, H7, H8});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(upperA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upperB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upperC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upperE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upperG, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upperH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upperF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upperD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(moveListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(A8)
                                                        .addComponent(C8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(D8)
                                                        .addComponent(E8)
                                                        .addComponent(F8)
                                                        .addComponent(G8)
                                                        .addComponent(H8)
                                                        .addComponent(left8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(A7)
                                                        .addComponent(B7)
                                                        .addComponent(C7)
                                                        .addComponent(D7)
                                                        .addComponent(E7)
                                                        .addComponent(F7)
                                                        .addComponent(H7)
                                                        .addComponent(G7)
                                                        .addComponent(left7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(A6)
                                                        .addComponent(B6)
                                                        .addComponent(C6)
                                                        .addComponent(D6)
                                                        .addComponent(E6)
                                                        .addComponent(F6)
                                                        .addComponent(G6)
                                                        .addComponent(H6)
                                                        .addComponent(left6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(A5)
                                                        .addComponent(B5)
                                                        .addComponent(C5)
                                                        .addComponent(D5)
                                                        .addComponent(E5)
                                                        .addComponent(F5)
                                                        .addComponent(G5)
                                                        .addComponent(H5)
                                                        .addComponent(left5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(A4)
                                                        .addComponent(B4)
                                                        .addComponent(C4)
                                                        .addComponent(D4)
                                                        .addComponent(E4)
                                                        .addComponent(F4)
                                                        .addComponent(G4)
                                                        .addComponent(H4)
                                                        .addComponent(left4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(A3)
                                                        .addComponent(B3)
                                                        .addComponent(C3)
                                                        .addComponent(D3)
                                                        .addComponent(E3)
                                                        .addComponent(F3)
                                                        .addComponent(G3)
                                                        .addComponent(H3)
                                                        .addComponent(left3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(right3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(left2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(right2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(1, 1, 1)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(left1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(right1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(D2)
                                                                                        .addComponent(E2)
                                                                                        .addComponent(F2)
                                                                                        .addComponent(G2)
                                                                                        .addComponent(H2))
                                                                                .addGap(0, 0, 0)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(D1)
                                                                                        .addComponent(E1)
                                                                                        .addComponent(F1)
                                                                                        .addComponent(G1)
                                                                                        .addComponent(H1)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(A2)
                                                                                        .addComponent(B2)
                                                                                        .addComponent(C2))
                                                                                .addGap(0, 0, 0)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(A1)
                                                                                        .addComponent(B1)
                                                                                        .addComponent(C1))))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lowerA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lowerB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lowerC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lowerE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lowerG, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lowerH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lowerF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lowerD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(firstPlayer)
                                                        .addComponent(secondPlayer))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(moveListTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(printBoardButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newGameButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(endGameButton)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{A1, A2, A3, A4, A5, A6, A7, A8, B1, B2, B3, B4, B5, B6, B7, B8, C1, C2, C3, C4, C5, C6, C7, C8, D1, D2, D3, D4, D5, D6, D7, D8, E1, E2, E3, E4, E5, E6, E7, E8, F1, F2, F3, F4, F5, F6, F7, F8, G1, G2, G3, G4, G5, G6, G7, G8, H1, H2, H3, H4, H5, H6, H7, H8});

        B8.getAccessibleContext().setAccessibleDescription("B8");

        pack();
    }

    ; //buildLayout

    /**
     * places piece images in a standard chess layout - UNUSED
     * pieces retrieved from Wikimedia Commons, 'a free media repository'
     * https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent
     */
    private void createDefaultBoard() { //for testing, will eventually take in the starting board, more general
        ImageIcon R = new ImageIcon(blackRookPath);
        ImageIcon N = new ImageIcon(blackKnightPath);
        ImageIcon B = new ImageIcon(blackBishopPath);
        ImageIcon Q = new ImageIcon(blackQueenPath);
        ImageIcon K = new ImageIcon(blackKingPath);
        ImageIcon P = new ImageIcon(blackPawnPath);
        ImageIcon r = new ImageIcon(whiteRookPath);
        ImageIcon n = new ImageIcon(whiteKnightPath);
        ImageIcon b = new ImageIcon(whiteBishopPath);
        ImageIcon q = new ImageIcon(whiteQueenPath);
        ImageIcon k = new ImageIcon(whiteKingPath);
        ImageIcon p = new ImageIcon(whitePawnPath);
        ImageIcon empty = new ImageIcon(emptyPiecePath);


        A8.setIcon(R);
        B8.setIcon(N);
        C8.setIcon(B);
        D8.setIcon(Q);
        E8.setIcon(K);
        F8.setIcon(B);
        G8.setIcon(N);
        H8.setIcon(R);
        A7.setIcon(P);
        B7.setIcon(P);
        C7.setIcon(P);
        D7.setIcon(P);
        E7.setIcon(P);
        F7.setIcon(P);
        G7.setIcon(P);
        H7.setIcon(P);

        A2.setIcon(p);
        B2.setIcon(p);
        C2.setIcon(p);
        D2.setIcon(p);
        E2.setIcon(p);
        F2.setIcon(p);
        G2.setIcon(p);
        H2.setIcon(p);
        A1.setIcon(r);
        B1.setIcon(n);
        C1.setIcon(b);
        D1.setIcon(q);
        E1.setIcon(k);
        F1.setIcon(b);
        G1.setIcon(n);
        H1.setIcon(r);
    }

    ;//createDefaultBoard

    /**
     * draws the board based on the passed board file
     */
    private void drawBoard(Board board) { 
        for (int i = 0; i < board.getPieces().size(); i++) {
            mapImage(board.getPieces().get(i).getTile().getCurrent());
        }
    }

    ; //drawBoard


    /**
     * main method that initializes buttons
     */
    private void initComponents() {
        Font boardText = new java.awt.Font("Tahoma", 0, 14);
        Font playerNames = new java.awt.Font("Tahoma", 0, 10);
        Color whiteTile = new java.awt.Color(251, 206, 156);
        Color blackTile = new java.awt.Color(211, 141, 71);
        Color backgroundColor = new java.awt.Color(253, 226, 198);
        this.getContentPane().setBackground(backgroundColor);

        A8 = new javax.swing.JButton();
        A8.setBackground(whiteTile);

        B8 = new javax.swing.JButton();
        B8.setBackground(blackTile);

        C8 = new javax.swing.JButton();
        C8.setBackground(whiteTile);

        D8 = new javax.swing.JButton();
        D8.setBackground(blackTile);

        E8 = new javax.swing.JButton();
        E8.setBackground(whiteTile);

        F8 = new javax.swing.JButton();
        F8.setBackground(blackTile);

        G8 = new javax.swing.JButton();
        G8.setBackground(whiteTile);

        H8 = new javax.swing.JButton();
        H8.setBackground(blackTile);

        A7 = new javax.swing.JButton();
        A7.setBackground(blackTile);

        B7 = new javax.swing.JButton();
        B7.setBackground(whiteTile);

        C7 = new javax.swing.JButton();
        C7.setBackground(blackTile);

        D7 = new javax.swing.JButton();
        D7.setBackground(whiteTile);

        E7 = new javax.swing.JButton();
        E7.setBackground(blackTile);

        F7 = new javax.swing.JButton();
        F7.setBackground(whiteTile);

        G7 = new javax.swing.JButton();
        G7.setBackground(blackTile);

        H7 = new javax.swing.JButton();
        H7.setBackground(whiteTile);

        A6 = new javax.swing.JButton();
        A6.setBackground(whiteTile);

        B6 = new javax.swing.JButton();
        B6.setBackground(blackTile);

        C6 = new javax.swing.JButton();
        C6.setBackground(whiteTile);

        D6 = new javax.swing.JButton();
        D6.setBackground(blackTile);

        E6 = new javax.swing.JButton();
        E6.setBackground(whiteTile);

        F6 = new javax.swing.JButton();
        F6.setBackground(blackTile);

        G6 = new javax.swing.JButton();
        G6.setBackground(whiteTile);

        H6 = new javax.swing.JButton();
        H6.setBackground(blackTile);

        A5 = new javax.swing.JButton();
        A5.setBackground(blackTile);

        B5 = new javax.swing.JButton();
        B5.setBackground(whiteTile);

        C5 = new javax.swing.JButton();
        C5.setBackground(blackTile);

        D5 = new javax.swing.JButton();
        D5.setBackground(whiteTile);

        E5 = new javax.swing.JButton();
        E5.setBackground(blackTile);

        F5 = new javax.swing.JButton();
        F5.setBackground(whiteTile);

        G5 = new javax.swing.JButton();
        G5.setBackground(blackTile);

        H5 = new javax.swing.JButton();
        H5.setBackground(whiteTile);

        A4 = new javax.swing.JButton();
        A4.setBackground(whiteTile);

        B4 = new javax.swing.JButton();
        B4.setBackground(blackTile);

        C4 = new javax.swing.JButton();
        C4.setBackground(whiteTile);

        D4 = new javax.swing.JButton();
        D4.setBackground(blackTile);

        E4 = new javax.swing.JButton();
        E4.setBackground(whiteTile);

        F4 = new javax.swing.JButton();
        F4.setBackground(blackTile);

        G4 = new javax.swing.JButton();
        G4.setBackground(whiteTile);

        H4 = new javax.swing.JButton();
        H4.setBackground(blackTile);

        A3 = new javax.swing.JButton();
        A3.setBackground(blackTile);

        B3 = new javax.swing.JButton();
        B3.setBackground(whiteTile);

        C3 = new javax.swing.JButton();
        C3.setBackground(blackTile);

        D3 = new javax.swing.JButton();
        D3.setBackground(whiteTile);

        E3 = new javax.swing.JButton();
        E3.setBackground(blackTile);

        F3 = new javax.swing.JButton();
        F3.setBackground(whiteTile);

        G3 = new javax.swing.JButton();
        G3.setBackground(blackTile);

        H3 = new javax.swing.JButton();
        H3.setBackground(whiteTile);

        A2 = new javax.swing.JButton();
        A2.setBackground(whiteTile);

        B2 = new javax.swing.JButton();
        B2.setBackground(blackTile);

        C2 = new javax.swing.JButton();
        C2.setBackground(whiteTile);

        D2 = new javax.swing.JButton();
        D2.setBackground(blackTile);

        E2 = new javax.swing.JButton();
        E2.setBackground(whiteTile);

        F2 = new javax.swing.JButton();
        F2.setBackground(blackTile);

        G2 = new javax.swing.JButton();
        G2.setBackground(whiteTile);

        H2 = new javax.swing.JButton();
        H2.setBackground(blackTile);

        A1 = new javax.swing.JButton();
        A1.setBackground(blackTile);

        B1 = new javax.swing.JButton();
        B1.setBackground(whiteTile);

        C1 = new javax.swing.JButton();
        C1.setBackground(blackTile);

        D1 = new javax.swing.JButton();
        D1.setBackground(whiteTile);

        E1 = new javax.swing.JButton();
        E1.setBackground(blackTile);

        F1 = new javax.swing.JButton();
        F1.setBackground(whiteTile);

        G1 = new javax.swing.JButton();
        G1.setBackground(blackTile);

        H1 = new javax.swing.JButton();
        H1.setBackground(whiteTile);

        upperA = new javax.swing.JLabel();
        upperA.setText("        A");
        upperA.setBackground(backgroundColor);
        upperA.setFont(boardText);

        upperB = new javax.swing.JLabel();
        upperB.setText("        B");
        upperB.setBackground(backgroundColor);
        upperB.setFont(boardText);

        upperC = new javax.swing.JLabel();
        upperC.setText("        C");
        upperC.setBackground(backgroundColor);
        upperC.setFont(boardText);

        upperD = new javax.swing.JLabel();
        upperD.setText("        D");
        upperD.setBackground(backgroundColor);
        upperD.setFont(boardText);

        upperE = new javax.swing.JLabel();
        upperE.setText("        E");
        upperE.setBackground(backgroundColor);
        upperE.setFont(boardText);

        upperF = new javax.swing.JLabel();
        upperF.setText("        F");
        upperF.setBackground(backgroundColor);
        upperF.setFont(boardText);

        upperG = new javax.swing.JLabel();
        upperG.setText("        G");
        upperG.setBackground(backgroundColor);
        upperG.setFont(boardText);

        upperH = new javax.swing.JLabel();
        upperH.setText("        H");
        upperH.setBackground(backgroundColor);
        upperH.setFont(boardText);

        right8 = new javax.swing.JLabel();
        right8.setText("8");
        right8.setBackground(backgroundColor);
        right8.setFont(boardText);

        right7 = new javax.swing.JLabel();
        right7.setText("7");
        right7.setBackground(backgroundColor);
        right7.setFont(boardText);

        right6 = new javax.swing.JLabel();
        right6.setText("6");
        right6.setBackground(backgroundColor);
        right6.setFont(boardText);

        right5 = new javax.swing.JLabel();
        right5.setText("5");
        right5.setBackground(backgroundColor);
        right5.setFont(boardText);

        right4 = new javax.swing.JLabel();
        right4.setText("4");
        right4.setBackground(backgroundColor);
        right4.setFont(boardText);

        right3 = new javax.swing.JLabel();
        right3.setText("3");
        right3.setBackground(backgroundColor);
        right3.setFont(boardText);

        right2 = new javax.swing.JLabel();
        right2.setText("2");
        right2.setBackground(backgroundColor);
        right2.setFont(boardText);

        right1 = new javax.swing.JLabel();
        right1.setText("1");
        right1.setBackground(backgroundColor);
        right1.setFont(boardText);

        lowerA = new javax.swing.JLabel();
        lowerA.setText("        A");
        lowerA.setBackground(backgroundColor);
        lowerA.setFont(boardText);

        lowerB = new javax.swing.JLabel();
        lowerB.setText("        B");
        lowerB.setBackground(backgroundColor);
        lowerB.setFont(boardText);

        lowerC = new javax.swing.JLabel();
        lowerC.setText("        C");
        lowerC.setBackground(backgroundColor);
        lowerC.setFont(boardText);

        lowerD = new javax.swing.JLabel();
        lowerD.setText("        D");
        lowerD.setBackground(backgroundColor);
        lowerD.setFont(boardText);

        lowerE = new javax.swing.JLabel();
        lowerE.setText("        E");
        lowerE.setBackground(backgroundColor);
        lowerE.setFont(boardText);

        lowerF = new javax.swing.JLabel();
        lowerF.setText("        F");
        lowerF.setBackground(backgroundColor);
        lowerF.setFont(boardText);

        lowerG = new javax.swing.JLabel();
        lowerG.setText("        G");
        lowerG.setBackground(backgroundColor);
        lowerG.setFont(boardText);

        lowerH = new javax.swing.JLabel();
        lowerH.setText("        H");
        lowerH.setBackground(backgroundColor);
        lowerH.setFont(boardText);

        left8 = new javax.swing.JLabel();
        left8.setText("  8");
        left8.setBackground(backgroundColor);
        left8.setFont(boardText);

        left7 = new javax.swing.JLabel();
        left7.setText("  7");
        left7.setBackground(backgroundColor);
        left7.setFont(boardText);

        left6 = new javax.swing.JLabel();
        left6.setText("  6");
        left6.setBackground(backgroundColor);
        left6.setFont(boardText);

        left5 = new javax.swing.JLabel();
        left5.setText("  5");
        left5.setBackground(backgroundColor);
        left5.setFont(boardText);

        left4 = new javax.swing.JLabel();
        left4.setText("  4");
        left4.setBackground(backgroundColor);
        left4.setFont(boardText);

        left3 = new javax.swing.JLabel();
        left3.setText("  3");
        left3.setBackground(backgroundColor);
        left3.setFont(boardText);

        left2 = new javax.swing.JLabel();
        left2.setText("  2");
        left2.setBackground(backgroundColor);
        left2.setFont(boardText);

        left1 = new javax.swing.JLabel();
        left1.setText("  1");
        left1.setBackground(backgroundColor);
        left1.setFont(boardText);

        moveListTextArea = new javax.swing.JScrollPane();
        moveListTextArea.setBackground(Color.white);

        moveList = new javax.swing.JTextArea();
        moveList.setColumns(20);
        moveList.setRows(5);

        moveListLabel = new javax.swing.JLabel();
        moveListLabel.setText("Move List");
        moveListLabel.setFont(boardText);

        printBoardButton = new javax.swing.JButton();
        printBoardButton.setText("Save Board");

        newGameButton = new javax.swing.JButton();
        newGameButton.setText("New Game");

        endGameButton = new javax.swing.JButton();
        endGameButton.setText("End Game");

        firstPlayer = new javax.swing.JLabel();
        firstPlayer.setText("Player");    //TODO: set to whoever goes first, make more general if 2 AI
        firstPlayer.setFont(playerNames);

        secondPlayer = new javax.swing.JLabel();
        secondPlayer.setText("Computer"); //TODO: set to whoever goes second
        secondPlayer.setFont(playerNames);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        buildLayout();
    }

    ; //initComponents

    /**
     * Maps game board names to UI buttons, used for placing pieces onto correct tiles.
     *
     * @param pieceToPlace The Piece which button name needs to be returned.
     * @return The button/UI tile which the piece will be placed on.
     */
    private JButton mapButton(Piece pieceToPlace) {
        switch (pieceToPlace.getTile().getName()) {
            case "1A":
                return A8;
            case "2A":
                return A7;
            case "3A":
                return A6;
            case "4A":
                return A5;
            case "5A":
                return A4;
            case "6A":
                return A3;
            case "7A":
                return A2;
            case "8A":
                return A1;
            case "1B":
                return B8;
            case "2B":
                return B7;
            case "3B":
                return B6;
            case "4B":
                return B5;
            case "5B":
                return B4;
            case "6B":
                return B3;
            case "7B":
                return B2;
            case "8B":
                return B1;
            case "1C":
                return C8;
            case "2C":
                return C7;
            case "3C":
                return C6;
            case "4C":
                return C5;
            case "5C":
                return C4;
            case "6C":
                return C3;
            case "7C":
                return C2;
            case "8C":
                return C1;
            case "1D":
                return D8;
            case "2D":
                return D7;
            case "3D":
                return D6;
            case "4D":
                return D5;
            case "5D":
                return D4;
            case "6D":
                return D3;
            case "7D":
                return D2;
            case "8D":
                return D1;
            case "1E":
                return E8;
            case "2E":
                return E7;
            case "3E":
                return E6;
            case "4E":
                return E5;
            case "5E":
                return E4;
            case "6E":
                return E3;
            case "7E":
                return E2;
            case "8E":
                return E1;
            case "1F":
                return F8;
            case "2F":
                return F7;
            case "3F":
                return F6;
            case "4F":
                return F5;
            case "5F":
                return F4;
            case "6F":
                return F3;
            case "7F":
                return F2;
            case "8F":
                return F1;
            case "1G":
                return G8;
            case "2G":
                return G7;
            case "3G":
                return G6;
            case "4G":
                return G5;
            case "5G":
                return G4;
            case "6G":
                return G3;
            case "7G":
                return G2;
            case "8G":
                return G1;
            case "1H":
                return H8;
            case "2H":
                return H7;
            case "3H":
                return H6;
            case "4H":
                return H5;
            case "5H":
                return H4;
            case "6H":
                return H3;
            case "7H":
                return H2;
            case "8H":
                return H1;
            default:
                throw new NullPointerException("mapButton invalid");
        }
    }

    private JButton mapButton(String name, String secondArg) {
        switch(name){
        case "1A":
            return A8;
        case "2A":
            return A7;
        case "3A":
            return A6;
        case "4A":
            return A5;
        case "5A":
            return A4;
        case "6A":
            return A3;
        case "7A":
            return A2;
        case "8A":
            return A1;
        case "1B":
            return B8;
        case "2B":
            return B7;
        case "3B":
            return B6;
        case "4B":
            return B5;
        case "5B":
            return B4;
        case "6B":
            return B3;
        case "7B":
            return B2;
        case "8B":
            return B1;
        case "1C":
            return C8;
        case "2C":
            return C7;
        case "3C":
            return C6;
        case "4C":
            return C5;
        case "5C":
            return C4;
        case "6C":
            return C3;
        case "7C":
            return C2;
        case "8C":
            return C1;
        case "1D":
            return D8;
        case "2D":
            return D7;
        case "3D":
            return D6;
        case "4D":
            return D5;
        case "5D":
            return D4;
        case "6D":
            return D3;
        case "7D":
            return D2;
        case "8D":
            return D1;
        case "1E":
            return E8;
        case "2E":
            return E7;
        case "3E":
            return E6;
        case "4E":
            return E5;
        case "5E":
            return E4;
        case "6E":
            return E3;
        case "7E":
            return E2;
        case "8E":
            return E1;
        case "1F":
            return F8;
        case "2F":
            return F7;
        case "3F":
            return F6;
        case "4F":
            return F5;
        case "5F":
            return F4;
        case "6F":
            return F3;
        case "7F":
            return F2;
        case "8F":
            return F1;
        case "1G":
            return G8;
        case "2G":
            return G7;
        case "3G":
            return G6;
        case "4G":
            return G5;
        case "5G":
            return G4;
        case "6G":
            return G3;
        case "7G":
            return G2;
        case "8G":
            return G1;
        case "1H":
            return H8;
        case "2H":
            return H7;
        case "3H":
            return H6;
        case "4H":
            return H5;
        case "5H":
            return H4;
        case "6H":
            return H3;
        case "7H":
            return H2;
        case "8H":
            return H1;
        default:
            throw new NullPointerException("mapButton invalid");
    }
}

    /**
     * Maps the piece name to matching image files and places images on the buttons of the board.
     */
    private void mapImage(Piece piece) {

        switch (piece.getName()) { //determines which piece to place
            case "p0": //pawn
                ImageIcon P = new ImageIcon(blackPawnPath);
                mapButton(piece).setIcon(P);
                break;
            case "r0": //rook
                ImageIcon R = new ImageIcon(blackRookPath);
                mapButton(piece).setIcon(R);
                break;
            case "h0": //knight
                ImageIcon N = new ImageIcon(blackKnightPath);
                mapButton(piece).setIcon(N);
                break;
            case "b0": //bishop
                ImageIcon B = new ImageIcon(blackBishopPath);
                mapButton(piece).setIcon(B);
                break;
            case "k0": //king
                ImageIcon K = new ImageIcon(blackKingPath);
                mapButton(piece).setIcon(K);
                break;
            case "q0": //queen
                ImageIcon Q = new ImageIcon(blackQueenPath);
                mapButton(piece).setIcon(Q);
                break;
            case "p1": //pawn
                ImageIcon p = new ImageIcon(whitePawnPath);
                mapButton(piece).setIcon(p);
                break;
            case "r1": //rook
                ImageIcon r = new ImageIcon(whiteRookPath);
                mapButton(piece).setIcon(r);
                break;
            case "h1": //knight
                ImageIcon n = new ImageIcon(whiteKnightPath);
                mapButton(piece).setIcon(n);
                break;
            case "b1": //bishop
                ImageIcon b = new ImageIcon(whiteBishopPath);
                mapButton(piece).setIcon(b);
                break;
            case "k1": //king
                ImageIcon k = new ImageIcon(whiteKingPath);
                mapButton(piece).setIcon(k);
                break;
            case "q1": //queen
                ImageIcon q = new ImageIcon(whiteQueenPath);
                mapButton(piece).setIcon(q);
                break;
            case "--": //empty TODO create an empty case TESTTTTTTT
                ImageIcon empty = new ImageIcon(emptyPiecePath);
                mapButton(piece).setIcon(empty);

        }
    }; //placePiece

    /**
    private void newGameButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        game = new Game();    //creating a standard board
        currentBoard = game.getBoard();
        drawBoard(currentBoard); //start game
    }
    * */
    /**
     * This method provides a localized place to change/set image PNG paths.
     */
    private void setImagePaths(){ //TODO: cupdate relative paths with master
        blackRookPath = "..\\Latest_Chess\\Chess-Patrick\\blackRook.png";
        blackKnightPath = "..\\Latest_Chess\\Chess-Patrick\\blackKnight.png";
        blackBishopPath = "..\\Latest_Chess\\Chess-Patrick\\blackBishop.png";
        blackQueenPath = "..\\Latest_Chess\\Chess-Patrick\\blackQueen.png";
        blackKingPath = "..\\Latest_Chess\\Chess-Patrick\\blackKing.png";
        blackPawnPath = "..\\Latest_Chess\\Chess-Patrick\\blackPawn.png";
        whiteRookPath = "..\\Latest_Chess\\Chess-Patrick\\whiteRook.png";
        whiteKnightPath = "..\\Latest_Chess\\Chess-Patrick\\whiteKnight.png";
        whiteBishopPath = "..\\Latest_Chess\\Chess-Patrick\\whiteBishop.png";
        whiteQueenPath = "..\\Latest_Chess\\Chess-Patrick\\whiteQueen.png";
        whiteKingPath = "..\\Latest_Chess\\Chess-Patrick\\whiteKing.png";
        whitePawnPath = "..\\Latest_Chess\\Chess-Patrick\\whitePawn.png";
        emptyPiecePath = "..\\Latest_Chess\\Chess-Patrick\\transparent.png";
    }

    /**
     * setting the names of the buttons, mapped to representation in
     */
    private void setButtonNames(){
        A8.setName("1A");
        A7.setName("2A");
        A6.setName("3A");
        A5.setName("4A");
        A4.setName("5A");
        A3.setName("6A");
        A2.setName("7A");
        A1.setName("8A");

        B8.setName("1B");
        B7.setName("2B");
        B6.setName("3B");
        B5.setName("4B");
        B4.setName("5B");
        B3.setName("6B");
        B2.setName("7B");
        B1.setName("8B");

        C8.setName("1C");
        C7.setName("2C");
        C6.setName("3C");
        C5.setName("4C");
        C4.setName("5C");
        C3.setName("6C");
        C2.setName("7C");
        C1.setName("8C");

        D8.setName("1D");
        D7.setName("2D");
        D6.setName("3D");
        D5.setName("4D");
        D4.setName("5D");
        D3.setName("6D");
        D2.setName("7D");
        D1.setName("8D");

        E8.setName("1E");
        E7.setName("2E");
        E6.setName("3E");
        E5.setName("4E");
        E4.setName("5E");
        E3.setName("6E");
        E2.setName("7E");
        E1.setName("8E");

        F8.setName("1F");
        F7.setName("2F");
        F6.setName("3F");
        F5.setName("4F");
        F4.setName("5F");
        F3.setName("6F");
        F2.setName("7F");
        F1.setName("8F");

        G8.setName("1G");
        G7.setName("2G");
        G6.setName("3G");
        G5.setName("4G");
        G4.setName("5G");
        G3.setName("6G");
        G2.setName("7G");
        G1.setName("8G");

        H8.setName("1H");
        H7.setName("2H");
        H6.setName("3H");
        H5.setName("4H");
        H4.setName("5H");
        H3.setName("6H");
        H2.setName("7H");
        H1.setName("8H");
    };

    /** ///NOT WORKING: keeping for posterity
    private void updateTextField(LinkedList list){
        moveList = new JTextArea( );
        for(int i=0; i<list.size(); i++){
            moveList.append("hello world");
        }
     };
     */


    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });

    }

    // Variable declaration
    private javax.swing.JButton A1;
    private javax.swing.JButton A2;
    private javax.swing.JButton A3;
    private javax.swing.JButton A4;
    private javax.swing.JButton A5;
    private javax.swing.JButton A6;
    private javax.swing.JButton A7;
    private javax.swing.JButton A8;
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton C1;
    private javax.swing.JButton C2;
    private javax.swing.JButton C3;
    private javax.swing.JButton C4;
    private javax.swing.JButton C5;
    private javax.swing.JButton C6;
    private javax.swing.JButton C7;
    private javax.swing.JButton C8;
    private javax.swing.JButton D1;
    private javax.swing.JButton D2;
    private javax.swing.JButton D3;
    private javax.swing.JButton D4;
    private javax.swing.JButton D5;
    private javax.swing.JButton D6;
    private javax.swing.JButton D7;
    private javax.swing.JButton D8;
    private javax.swing.JButton E1;
    private javax.swing.JButton E2;
    private javax.swing.JButton E3;
    private javax.swing.JButton E4;
    private javax.swing.JButton E5;
    private javax.swing.JButton E6;
    private javax.swing.JButton E7;
    private javax.swing.JButton E8;
    private javax.swing.JButton F1;
    private javax.swing.JButton F2;
    private javax.swing.JButton F3;
    private javax.swing.JButton F4;
    private javax.swing.JButton F5;
    private javax.swing.JButton F6;
    private javax.swing.JButton F7;
    private javax.swing.JButton F8;
    private javax.swing.JButton G1;
    private javax.swing.JButton G2;
    private javax.swing.JButton G3;
    private javax.swing.JButton G4;
    private javax.swing.JButton G5;
    private javax.swing.JButton G6;
    private javax.swing.JButton G7;
    private javax.swing.JButton G8;
    private javax.swing.JButton H1;
    private javax.swing.JButton H2;
    private javax.swing.JButton H3;
    private javax.swing.JButton H4;
    private javax.swing.JButton H5;
    private javax.swing.JButton H6;
    private javax.swing.JButton H7;
    private javax.swing.JButton H8;
    private javax.swing.JLabel left1;
    private javax.swing.JLabel left2;
    private javax.swing.JLabel left3;
    private javax.swing.JLabel left4;
    private javax.swing.JLabel left5;
    private javax.swing.JLabel left6;
    private javax.swing.JLabel left7;
    private javax.swing.JLabel left8;
    private javax.swing.JLabel lowerA;
    private javax.swing.JLabel lowerB;
    private javax.swing.JLabel lowerC;
    private javax.swing.JLabel lowerD;
    private javax.swing.JLabel lowerE;
    private javax.swing.JLabel lowerF;
    private javax.swing.JLabel lowerG;
    private javax.swing.JLabel lowerH;
    private javax.swing.JLabel right1;
    private javax.swing.JLabel right2;
    private javax.swing.JLabel right3;
    private javax.swing.JLabel right4;
    private javax.swing.JLabel right5;
    private javax.swing.JLabel right6;
    private javax.swing.JLabel right7;
    private javax.swing.JLabel right8;
    private javax.swing.JLabel upperA;
    private javax.swing.JLabel upperB;
    private javax.swing.JLabel upperC;
    private javax.swing.JLabel upperD;
    private javax.swing.JLabel upperE;
    private javax.swing.JLabel upperF;
    private javax.swing.JLabel upperG;
    private javax.swing.JLabel upperH;
    private javax.swing.JTextArea moveList;
    private javax.swing.JLabel moveListLabel;
    private javax.swing.JButton printBoardButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton endGameButton;
    private javax.swing.JScrollPane moveListTextArea;
    private javax.swing.JLabel firstPlayer;
    private javax.swing.JLabel secondPlayer;
    private String blackRookPath;
    private String blackKnightPath;
    private String blackBishopPath;
    private String blackQueenPath;
    private String blackKingPath;
    private String blackPawnPath;
    private String whiteRookPath;
    private String whiteKnightPath;
    private String whiteBishopPath;
    private String whiteQueenPath;
    private String whiteKingPath;
    private String whitePawnPath;
    private String emptyPiecePath;
    private JButton startPosition;
    private JButton endPosition;
    private Board currentBoard;
    private Board nextBoard;
    private boolean secondClick;
    private Tile tileFrom;
    private Tile tileFromSecond;
    private Piece pieceFrom;
    private Game game;
    private String updateComponentName;

}


