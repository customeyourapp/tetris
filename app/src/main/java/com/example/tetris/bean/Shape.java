package com.example.tetris.bean;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    protected List<Block> blocks = new ArrayList<>();
    protected int x;
    protected int y;

    protected Shape(int x){
        this.x = x;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}