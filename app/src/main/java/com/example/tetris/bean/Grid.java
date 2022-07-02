package com.example.tetris.bean;

import com.example.tetris.annotation.GridType;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<Block> placedBlocks;
    //同时只能有一个图形下落
    private Shape movingShape;
    //记录当前游戏每个X可以降落的最低Y,注意这个Line对应的都是空的格子
    private List<Integer> lowestLine;

    public Grid(){
        lowestLine = new ArrayList<>();
        placedBlocks = new ArrayList<>();
        for(int i=0;i< GridType.GRID_WIDTH;i++){
            lowestLine.add(GridType.GRID_HEIGHT);
        }
    }

    public List<Block> getPlacedBlocks() {
        return placedBlocks;
    }

    public void setPlacedBlocks(List<Block> placedBlocks) {
        this.placedBlocks = placedBlocks;
    }

    public void addPlacedBlocks(Block block){
        placedBlocks.add(block);
    }

    public Shape getMovingShape() {
        return movingShape;
    }

    public void setMovingShape(Shape movingShape) {
        this.movingShape = movingShape;
    }

    public List<Integer> getLowestLine() {
        return lowestLine;
    }

    public void setLowestLine(int index,int newValue) {
        lowestLine.set(index,newValue);
    }
}
