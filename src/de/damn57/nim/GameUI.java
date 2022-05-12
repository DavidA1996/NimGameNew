package de.damn57.nim;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameUI extends PApplet {
    public static void main(String[] args) {
        PApplet.main("de.damn57.nim.GameUI");
    }

    private NimGame nimGame;
    private int rowClicked = -1;
    private List<Match> matches = new ArrayList<>();
    private Button endTurnButton = new Button((1280 / 4) * 3, (720 / 4) * 2, 200,50, "Zug beenden",this );
    private Button newGameButton = new Button((1280 / 4) * 3, (720 / 4), 200,50, "Neues Spiel",this );


    public void settings() {
        size(1280, 720);
        newGame(4,7);
    }

    public void draw() {
        background(0);
        for (Match m : matches) {
            m.draw();
        }
        endTurnButton.draw();
        newGameButton.draw();
    }

    private void newGame(int maxRows, int maxMatches) {
        Random r = new Random();
        int[] rows = new int[r.nextInt(maxRows)];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = r.nextInt(maxMatches - 1) + 1;
        }

        nimGame = Nim.of(rows);
        rowClicked = -1;
        updateGameState();
    }

    private void updateGameState() {
        matches.clear();
        int xPosRect = 50;
        int yPosRect = 50;
        int xPosEllipse = 55;
        int yPosEllipse = 50;

        int[] rows = nimGame.getRows();
        for (int rowIdx = 0; rowIdx < rows.length; rowIdx++) {
            for (int j = 0; j < rows[rowIdx]; j++) {
                matches.add(
                        new Match(xPosRect, yPosRect, xPosEllipse, yPosEllipse, rowIdx, this)
                );
                xPosRect += 100;
                xPosEllipse += 100;
            }

            xPosRect = 50;
            xPosEllipse = 55;
            yPosRect += 150;
            yPosEllipse += 150;
        }
    }

    public void mouseReleased() {
        boolean change = false;
        for (Match m : matches) {
            if (m.collides(mouseX, mouseY)) {
                int mRow = m.getRow();
                if(rowClicked == -1 || rowClicked == mRow){
                    // Match m angeklickt
                    nimGame = nimGame.play(Move.of(mRow, 1));
                    rowClicked = mRow;
                    change = true;
                }
            }
        }

        if(endTurnButton.collides(mouseX, mouseY)){
            Move m = nimGame.randomMove();
            nimGame = nimGame.play(m);
            rowClicked = -1;
            change = true;
        }

        if(newGameButton.collides(mouseX,mouseY)){
            newGame(4,7);
        }

        if (change) {
            this.updateGameState();
        }
    }

}