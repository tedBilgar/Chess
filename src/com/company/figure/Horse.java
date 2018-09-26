package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.Side;

import java.util.List;

public class Horse extends ChessFigure {
    public Horse(Side side, ChessBoard chessBoard, Field location) {
        super(side, chessBoard, location);
    }

    @Override
    boolean move() {
        return false;
    }

    @Override
    void setStep(int bottomLine, int upperLine) {

    }

    @Override
    boolean setRandomVector(List<Integer> usedVectors) {
        return false;
    }


}
