package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.ChessType;
import com.company.types.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pawn extends ChessFigure {
    public Pawn(Side side, ChessBoard chessBoard, Field location) {
        super(side,chessBoard,location);
        vectorNum = 3;
    }


    @Override
    public int move() {
        boolean isChanged = false;
        List<Integer> exceptionVectorList = new ArrayList<>();

        do {
            int randomVector = getRandom(1, vectorNum, exceptionVectorList);
            if (randomVector == 1) {
                if (chessBoard.getFigureByCoord(location.getX_coord(), location.getY_coord() + 1) == null) {
                    location.setY_coord(location.getY_coord() + 1);
                    chessBoard.getPawnMap().put(chessBoard.getFieldByCoord(location.getX_coord(), location.getY_coord()), this);
                    isChanged = true;
                }else exceptionVectorList.add(1);
            }

            if(randomVector == 2){

            }

        } while(isChanged);


        return 0;
    }

}
