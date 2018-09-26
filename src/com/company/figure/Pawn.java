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
    public boolean move() {
        int coeff;
        boolean isDone  = false;
        List<Integer> usedVectors = new ArrayList<>();
        if (side == Side.WHITE) coeff = +1;
        else coeff = -1;

        do {
            setStep(1,1);
            if(!setRandomVector(usedVectors)) break;

            if (getVector()[0] == -1 && getVector()[1] == +1 || getVector()[0] == +1 && getVector()[1] == +1) {
                ChessFigure anotherFigure = chessBoard.getFigureByCoord(location.getX_coord() + (coeff) * getVector()[0] * step,
                        location.getY_coord() + (coeff) * getVector()[1] * step);
                if (anotherFigure != null && anotherFigure.side != this.side && location.getX_coord() + (coeff) * getVector()[0] * step < 8
                    && location.getX_coord() + (coeff) * getVector()[0] * step > -1
                    && location.getY_coord() + (coeff) * getVector()[1] * step < 8
                    && location.getY_coord() + (coeff) * getVector()[1] * step > -1 ) {
                    killOther(anotherFigure.getLocation());
                    isDone = true;
                }else {
                    isDone = false;
                }
            } else {
                ChessFigure anotherFigure = chessBoard.getFigureByCoord(location.getX_coord() + (coeff) * getVector()[0] * step,
                        location.getY_coord() + (coeff) * getVector()[1] * step);
                if (anotherFigure == null && location.getX_coord() + (coeff) * getVector()[0] * step < 8
                        && location.getX_coord() + (coeff) * getVector()[0] * step > -1
                        && location.getY_coord() + (coeff) * getVector()[1] * step < 8
                        && location.getY_coord() + (coeff) * getVector()[1] * step > -1 ) {
                    Field newField = chessBoard.getFieldByCoord(location.getX_coord() + (coeff) * getVector()[0] * step, location.getY_coord() + (coeff) * getVector()[1] * step);
                    chessBoard.getPawnMap().put(newField, this);
                    isDone = true;
                }else{

                    isDone = false;
                }
            }

        }while (!isDone);

      return isDone;
    }

    @Override
    void setStep(int bottomLine,int upperLine) {
        this.step = new Random().nextInt(bottomLine) + upperLine;
    }

    @Override
    boolean setRandomVector(List<Integer> usedVectors) {
        boolean isNext = false;
        Random random = new Random();
        int randomNum;
        if (usedVectors.size() == 3) return false;
        do {
            randomNum = random.nextInt(3) + 1;
            for (int num: usedVectors) {
                if(randomNum == num) isNext = false;
                else isNext = true;
            }
        }while(!isNext);

        if(randomNum == 1) {
            vector[0] = -1;
            vector[1] = +1;
            usedVectors.add(1);
        }
        if(randomNum == 2){
            vector[0] = 0;
            vector[1] = +1;
            usedVectors.add(2);
        }
        if(randomNum == 3){
            vector[0] = +1;
            vector[1] = +1;
            usedVectors.add(3);
        }

        return true;
    }

}
