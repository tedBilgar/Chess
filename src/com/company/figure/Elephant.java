package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Elephant extends ChessFigure {


    public Elephant(Side side, ChessBoard chessBoard, int x_coord, int y_coord) {
        super(side, chessBoard, x_coord, y_coord);
    }

    @Override
    public boolean move() {
        int coeff;
        boolean isDone  = false;
        List<Integer> usedVectors = new ArrayList<>();
        if (side == Side.WHITE) coeff = +1;
        else coeff = -1;

        //Получаем рандомный вектор для движения
        setRandomVector(usedVectors);

        //Получаем валидный шаг для движения
        setStep();

        int potentialXCoord = x_coord + coeff * vector[0] * step;
        int potentialYCoord = y_coord + coeff * vector[1] * step;

        for (ChessFigure figure: chessBoard.getPawnList()) {
            int differenceX = figure.getX_coord() - x_coord;
            int differenceY = figure.getY_coord() - y_coord;

            //данная фигура на пути у текущей фигуры или нет
            if (getVectorType(differenceX,differenceY) == usedVectors.get(usedVectors.size() - 1)){
                if (vector[0] * potentialXCoord > vector[0] * figure.getX_coord()
                        || vector[1] * potentialYCoord > vector[1] * figure.getY_coord()){
                    if (figure.side != this.side){
                        //если вражеская фигура стоит раньше то потенциально бьет её
                        potentialXCoord = figure.getX_coord();
                        potentialYCoord = figure.getY_coord();
                    }else{
                        //TODO until still on own place
                        //если союзная фигура стоит раньше
                        //пока что стоит на месте своем
                        potentialXCoord = figure.getX_coord()- vector[0] * 1;
                        potentialYCoord = figure.getY_coord() - vector[1] * 1;
                    }
                }
            }
        }

    }

    @Override
    void setStep() {
        int coeff;
        boolean isDone = false;
        int randomStep;
        Random random = new Random();
        if (side == Side.WHITE) coeff = +1;
        else coeff = -1;
        do {
            randomStep = random.nextInt(8) + 1;
            if (x_coord + coeff * vector[0] * randomStep > 0 && x_coord + coeff * vector[0] * randomStep < 9
                    || y_coord + coeff * vector[1] * randomStep > 0 && y_coord + coeff * vector[1] * randomStep < 9) {
                isDone = true;
            }
        }while (!isDone);

        step = randomStep;
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
            usedVectors.add(1);
        }
        if (randomNum == 2){
            vector[0] = +1;
            vector[1] = 0;
            usedVectors.add(2);
        }
        if (randomNum == 3){
            vector[0] = 0;
            vector[1] = -1;
            usedVectors.add(3);
        }
        if(randomNum == 4){
            vector[0] = -1;
            vector[1] = 0;
            usedVectors.add(4);
        }

        return true;
    }

    private int getVectorType(int x,int y){
        if (x == 0 && y > 0) return 1;

        if (x > 0 && y == 0 ) return 2;

        if (x == 0 && y < 0) return 3;

        if (x < 0 && y==0) return 4;
    }



}
