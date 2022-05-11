import processing.core.PApplet;

public class GameUI extends PApplet {
    public static void main(String[] args) {
        PApplet.main("GameUI");

    }

    int xPosRect = 50;
    int yPosRect = 50;
    int xPosEllipse = 55;
    int yPosEllipse = 50;

    NimGame n1 = Nim.of(2, 3, 4);


    public void settings() {
        size(1280, 720);
    }

    public void draw() {

        background(0);
        drawMatch();
        noLoop();

    }


    public void drawMatch() {
        for (int i = 0; i < n1.getRows().length; i++) {
            fill(251, 191, 119);
            rect(xPosRect, yPosRect, 10, 100);
            fill(255);
            ellipse(xPosEllipse, yPosEllipse, 10, 20);


            for (int j = 0; j < n1.getRows()[i]; j++) {
                fill(251, 191, 119);
                rect(xPosRect, yPosRect, 10, 100);
                fill(255);
                ellipse(xPosEllipse, yPosEllipse, 10, 20);

                xPosRect += 100;
                xPosEllipse += 100;

            }

            xPosRect = 50;
            xPosEllipse = 55;
            yPosRect += 150;
            yPosEllipse += 150;
        }
    }

    public void removeMatch() {

        if (mouseX )
    }

}