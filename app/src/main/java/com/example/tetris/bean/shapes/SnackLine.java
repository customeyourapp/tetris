package com.example.tetris.bean.shapes;

import com.example.tetris.annotation.GridType;
import com.example.tetris.bean.Block;
import com.example.tetris.bean.Shape;

public class SnackLine extends Shape {
    public SnackLine(int colorID,int x){
        this.x = x;
        this.y = GridType.GRID_HEIGHT - 1;
        blocks.add(new Block(colorID,0,0));
        blocks.add(new Block(colorID,1,0));
        blocks.add(new Block(colorID,1,1));
        blocks.add(new Block(colorID,2,1));
    }
}
