package com.example.tetris.bean.shapes;

import com.example.tetris.annotation.GridType;
import com.example.tetris.bean.Block;
import com.example.tetris.bean.Shape;

public class Line extends Shape {
    public Line(int colorID,int x){
        super(x);
        blocks.add(new Block(colorID,0,0));
        blocks.add(new Block(colorID,1,0));
        blocks.add(new Block(colorID,2,0));
        blocks.add(new Block(colorID,3,0));
    }
}
