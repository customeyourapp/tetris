package com.example.tetris.bean;

public class Block {
    private int colorID;
    //相对于基准位置的偏移量
    private int relativeX;
    private int relativeY;
    private boolean isMove;

    public Block(int colorID, int relativeX, int relativeY) {
        this.colorID = colorID;
        this.relativeX = relativeX;
        this.relativeY = relativeY;

        isMove = true;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public int getRelativeX() {
        return relativeX;
    }

    public void setRelativeX(int relativeX) {
        this.relativeX = relativeX;
    }

    public int getRelativeY() {
        return relativeY;
    }

    public void setRelativeY(int relativeY) {
        this.relativeY = relativeY;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }
}
