package de.damn57.nim;

public class Match extends UIElement{

    private static final int widthRect = 10;
    private static final int heightRect = 100;

    private static final int heightEllipsis = 20;
    private static final int widthEllipsis = 10;

    private final int xPosRect;
    private final int yPosRect;
    private final int xPosEllipse;
    private final int yPosEllipse;
    private GameUI gameUI;

    private final int row;

    Match(int xPosRect, int yPosRect, int xPosEllipse, int yPosEllipse, int row, GameUI gameUI) {
        this.xPosRect = xPosRect;
        this.yPosRect = yPosRect;
        this.xPosEllipse = xPosEllipse;
        this.yPosEllipse = yPosEllipse;
        this.row = row;
        this.gameUI = gameUI;
    }

    @Override
    int getX() {
        return xPosRect;
    }

    @Override
    int getY() {
        return yPosRect - (heightEllipsis / 2);
    }

    @Override
    int getWidth() {
        return Math.max(widthEllipsis, widthRect);
    }

    @Override
    int getHeight() {
        return heightRect + (heightEllipsis / 2);
    }

    public void draw() {
        gameUI.fill(251, 191, 119);
        gameUI.rect(xPosRect, yPosRect, widthRect, heightRect);
        gameUI.fill(255);
        gameUI.ellipse(xPosEllipse, yPosEllipse, widthEllipsis, heightEllipsis);
    }

    public int getRow() {
        return row;
    }
}
