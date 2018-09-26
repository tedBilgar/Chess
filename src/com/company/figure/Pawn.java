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
        vector = new int[2];
    }


    @Override
    public int move() {
        int coeff;
        if (side == Side.WHITE) coeff = +1;
        else coeff = -1;

        setStep();
        setRandomVector();

        if (getVector()[0] == -1 && getVector()[1] == +1 || getVector()[0] == +1 && getVector()[1] == +1){
            ChessFigure anotherFigure = chessBoard.getFigureByCoord(location.getX_coord() + (coeff)*getVector()[0]*step,
                    location.getY_coord() + (coeff)*getVector()[1]*step);
            if(anotherFigure != null && anotherFigure.side != this.side){
                killOther(anotherFigure.getLocation());
            }
        }else {
            ChessFigure anotherFigure = chessBoard.getFigureByCoord(location.getX_coord() + (coeff)*getVector()[0]*step,
                    location.getY_coord() + (coeff)*getVector()[1]*step);
            if(anotherFigure == null){
                Field newField = chessBoard.getFieldByCoord(location.getX_coord() + (coeff)*getVector()[0]*step, location.getY_coord() + (coeff)*getVector()[1]*step);
                chessBoard.getPawnMap().put(newField,this);
            }
        }

      return 0;
    }

    @Override
    void setStep() {
        this.step = 1;
    }

    @Override
    void setRandomVector() {
        Random random = new Random();
        int randomNum = random.nextInt(3) + 1;

        if(randomNum == 1) {
            vector[0] = -1;
            vector[1] = +1;
        }
        if(randomNum == 2){
            vector[0] = 0;
            vector[1] = +1;
        }
        if(randomNum == 3){
            vector[0] = +1;
            vector[1] = +1;
        }

    }

}
