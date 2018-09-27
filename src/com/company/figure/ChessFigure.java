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
    protected int x_coord;
    protected int y_coord;

    protected int[] vector;
    protected int step;

    public ChessFigure(Side side, ChessBoard chessBoard) {
        this.side = side;
        this.chessBoard = chessBoard;
    }
    abstract boolean move();
    abstract void setStep(int bottomLine,int upperLine);
    abstract boolean setRandomVector(List<Integer> usedVectors);

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getX_coord() {
        return x_coord;
    }

    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public void setY_coord(int y_coord) {
        this.y_coord = y_coord;
    }

    public void killOther(Field otherField){
        chessBoard.getPawnMap().put(chessBoard.getFieldByCoord(location.getX_coord(),location.getY_coord()),null);
        location = otherField;
        chessBoard.getPawnMap().put(location,this);
    }

}
