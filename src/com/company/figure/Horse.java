package com.company.figure;

import com.company.board.ChessBoard;
import com.company.types.Side;

import java.util.List;

public class Horse extends ChessFigure {
    public Horse(Side side, ChessBoard chessBoard, int x_coord, int y_coord) {
        super(side, chessBoard, x_coord, y_coord);
    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public void setStep() {

    }

    @Override
    public boolean setRandomVector(List<Integer> usedVectors) {
        return false;
    }
}
