package com.example.tetris.bean.shapes;

import com.example.tetris.annotation.GridType;
import com.example.tetris.bean.Block;
import com.example.tetris.bean.Shape;

public class BrokenLine extends Shape {
    //x随机生成，y永远在最上面一格出现
    public BrokenLine(int colorID,int x){
        super(x);
        blocks.add(new Block(colorID,0,0));
        blocks.add(new Block(colorID,0,1));
        blocks.add(new Block(colorID,1,0));
        blocks.add(new Block(colorID,2,0));
    }
}
