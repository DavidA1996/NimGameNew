package de.damn57.nim;

public abstract class UIElement {
    abstract int getX();
    abstract int getY();
    abstract int getWidth();
    abstract int getHeight();

    abstract void draw();

    public boolean collides(int x, int y){
        int xStart = getX();
        int xEnd = getX() + getWidth();

        int yStart = getY();
        int yEnd = getY() + getHeight();

        return (x >= xStart && x <= xEnd && y >= yStart && y<= yEnd);
    }
}
