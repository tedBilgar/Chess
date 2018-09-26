package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Elephant extends ChessFigure {

    public Elephant(Side side, ChessBoard chessBoard, Field location) {
        super(side, chessBoard, location);
    }

    @Override
    public boolean move() {
        int coeff;
        boolean isDone  = false;
        List<Integer> usedVectors = new ArrayList<>();
        if (side == Side.WHITE) coeff = +1;
        else coeff = -1;

        do {
            setStep(1,8);
            if(!setRandomVector(usedVectors)) break;

            for (int i = vector[0],j = vector[1];;i++,j++){
                chessBoard.getPawnMap().get
            }

        }while (!isDone);
        return
    }

    @Override
    void setStep(int bottomLine, int upperLine) {
        this.step = new Random().nextInt(upperLine) + bottomLine;
    }

    @Override
    boolean setRandomVector(List<Integer> usedVectors) {
        boolean isNext = false;
        Random random = new Random();
        int randomNum;
        if (usedVectors.size() == 4) return false;
        do {
            randomNum = random.nextInt(4) + 1;
            for (int num: usedVectors) {
                if(randomNum == num) isNext = false;
                else isNext = true;
            }
        }while(!isNext);

        if(randomNum == 1){
            vector[0] = 0;
            vector[1] = +1;
        }
        if (randomNum == 2){
            vector[0] = +1;
            vector[1] = 0;
        }
        if (randomNum == 3){
            vector[0] = 0;
            vector[1] = -1;
        }
        if(randomNum == 4){
            vector[0] = -1;
            vector[1] = 0;
        }

        return true;
    }



}
