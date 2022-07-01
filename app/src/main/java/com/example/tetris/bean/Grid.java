package com.example.tetris.bean;

import java.util.List;

public class Grid {
    private List<Block> placedBlocks;
    //同时只能有一个图形下落
    private Shape movingShape;

    public List<Block> getPlacedBlocks() {
        return placedBlocks;
    }

    public void setPlacedBlocks(List<Block> placedBlocks) {
        this.placedBlocks = placedBlocks;
    }

    public Shape getMovingShape() {
        return movingShape;
    }

    public void setMovingShape(Shape movingShape) {
        this.movingShape = movingShape;
    }
}
