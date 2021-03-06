package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.ChessType;
import com.company.types.Side;

import java.util.List;
import java.util.Random;

public abstract class ChessFigure {
    protected Side side;
    protected ChessBoard chessBoard;
    protected Field location;

    protected int[] vector;
    protected int step;

    public ChessFigure(Side side, ChessBoard chessBoard, Field location) {
        this.side = side;
        this.chessBoard = chessBoard;
        this.location = location;
    }
    abstract boolean move();
    abstract void setStep(int bottomLine,int upperLine);
    abstract boolean setRandomVector(List<Integer> usedVectors);

    public int getStep(){
        return step;
    }
    public int[] getVector(){
        return vector;
    }
    public Field getLocation(){
        return location;
    }

    public void killOther(Field otherField){
        chessBoard.getPawnMap().put(chessBoard.getFieldByCoord(location.getX_coord(),location.getY_coord()),null);
        location = otherField;
        chessBoard.getPawnMap().put(location,this);
    }

}
