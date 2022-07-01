package com.example.tetris.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.tetris.R;
import com.example.tetris.annotation.GridType;
import com.example.tetris.bean.Block;
import com.example.tetris.bean.Grid;
import com.example.tetris.bean.Shape;
import com.example.tetris.bean.shapes.BrokenLine;
import com.example.tetris.bean.shapes.Line;
import com.example.tetris.bean.shapes.SnackLine;
import com.example.tetris.bean.shapes.Square;

import java.util.Random;

public class TetrisView extends View {
    private Grid grid;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int gridWidth = 0;
    private int gridHeight = 0;
    private int blockWidth;
    private int blockHeight;

    public TetrisView(Context context) {
        super(context);
        initView();
    }

    public TetrisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TetrisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        grid = new Grid();
        new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1000);
                    if(grid.getMovingShape() == null){
                        createNewShape();
                    }else{
                        shapeMoveDown();
                    }
                    invalidate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void createNewShape(){
        Random random = new Random();
        //防止超出右边界
        int randomX = random.nextInt(GridType.GRID_WIDTH-3);
        switch (random.nextInt(4)){
            case 0:
                grid.setMovingShape(new BrokenLine(R.color.green,randomX));
                break;
            case 1:
                grid.setMovingShape(new Line(R.color.red,randomX));
                break;
            case 2:
                grid.setMovingShape(new SnackLine(R.color.blue,randomX));
                break;
            case 3:
                grid.setMovingShape(new Square(R.color.purple_500,randomX));
        }
    }
    private void shapeMoveDown(){
        Shape movingShape = grid.getMovingShape();
        movingShape.setY(movingShape.getY() - 1);
    }
    private boolean isTouchPlacedBlocks(){
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        if(gridWidth == 0||gridHeight == 0){
            gridWidth = canvas.getWidth();
            gridHeight = canvas.getHeight();
            calculateBlockWidthAndHeight();
        }

        paint.setColor(ContextCompat.getColor(getContext(), R.color.grey));
        canvas.drawRect(0,0,gridWidth,gridHeight,paint);

        drawBlocksAndShapes(canvas);

        canvas.save();
    }
    private void calculateBlockWidthAndHeight(){
        if(gridWidth % GridType.GRID_WIDTH != 0)
            gridWidth -= GridType.GRID_WIDTH;
        if(gridHeight % GridType.GRID_HEIGHT != 0)
            gridHeight -= GridType.GRID_HEIGHT;
        blockWidth = gridWidth / GridType.GRID_WIDTH;
        blockHeight = gridHeight /GridType.GRID_HEIGHT;
    }
    private void drawBlocksAndShapes(Canvas canvas){
        if(grid.getPlacedBlocks() != null) {
            grid.getPlacedBlocks().forEach(block -> drawBlock(canvas, block, 0, 0));
        }
        Shape movingShape = grid.getMovingShape();
        if(movingShape != null){
            movingShape.getBlocks().forEach(block -> drawBlock(canvas,block,movingShape.getX(),movingShape.getY()));
        }
    }
    private void drawBlock(Canvas canvas, Block block,int offsetX,int offsetY){
        if(block.getRelativeX()+offsetX >= GridType.GRID_WIDTH ||
        block.getRelativeY()+offsetY >= GridType.GRID_HEIGHT)
            return;
        paint.setColor(ContextCompat.getColor(getContext(),block.getColorID()));
        canvas.drawRect(
                (block.getRelativeX()+offsetX)*blockWidth,
                (GridType.GRID_HEIGHT-block.getRelativeY()-offsetY)*blockHeight,
                (block.getRelativeX()+1+offsetX)*blockWidth,
                (GridType.GRID_HEIGHT-block.getRelativeY()-1-offsetY)*blockHeight,
                paint);
    }

}
