package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.ChessType;
import com.company.types.Side;

import java.util.List;
import java.util.Random;

public class Pawn extends ChessFigure {
    public Pawn(Side side, ChessBoard chessBoard, Field location) {
        super(side,chessBoard,location);
        minStep = 1;
        maxStep = 2;

        upperLeft = 1;
        upperCenter = 2;
        upperRight = 3;
        currentLeft = 0;
        currentRight = 0;
        bottomLeft = 0;
        bottomCenter = 0;
        bottonRight = 0;
    }


    @Override
    public int move() {
        boolean isChanged = false;

        Random random = new Random();
        int a = random.nextInt(2);
        if (a == 0 && isChanged == false){
            if (chessBoard.getFigureByCoord(location.getX_coord(),location.getY_coord() + 1) == null) {
                location.setY_coord(location.getY_coord() + 1);
                chessBoard.getPawnMap().put(chessBoard.getFieldByCoord(location.getX_coord(),location.getY_coord()),this);
                isChanged = true;
            }
        }


        return 0;
    }

    public void kill(int x_coord,int y_coord){
        //ChessFigure alienFigure = chessBoard.getFigureByCoord(x_coord, y_coord);
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
