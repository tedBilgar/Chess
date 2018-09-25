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
    protected int vectorNum;

    public ChessFigure(Side side, ChessBoard chessBoard, Field location) {
        this.side = side;
        this.chessBoard = chessBoard;
        this.location = location;
    }
    abstract int move();

    public void kill(int x_coord,int y_coord){
        chessBoard.getPawnMap().put(chessBoard.getFieldByCoord(x_coord, y_coord),this);
    }

    public int getRandom(int firstBorder, int secondBorder, List<Integer> exceptionVectorList){
        boolean itWas = false;
        Random random = new Random();
        int randomVector;
        do {
            randomVector = random.nextInt(secondBorder) + firstBorder;
            for (int a : exceptionVectorList) {
                if (randomVector == a) itWas = true;
            }
        } while (itWas);

        return randomVector;
    }
}
