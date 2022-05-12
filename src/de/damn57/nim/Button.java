package de.damn57.nim;

public class Button extends UIElement {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final String text;
    private final GameUI gameUI;

    Button(int x, int y, int width, int height, String text, GameUI gameUI){
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        this.text = text;
        this.gameUI = gameUI;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    int getWidth() {
        return width;
    }

    @Override
    int getHeight() {
        return height;
    }

    public void draw(){
        gameUI.fill(255, 255, 255);
        gameUI.rect(x,y,width,height);
        gameUI.fill(0,0,0);
        gameUI.text(text, x + (width/2), y + (height/2));
    }
}
