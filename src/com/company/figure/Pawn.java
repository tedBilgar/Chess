package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.ChessType;
import com.company.types.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pawn extends ChessFigure {

    public Pawn(Side side, ChessBoard chessBoard, int x_coord, int y_coord) {
        super(side, chessBoard, x_coord, y_coord);
    }

    @Override
    boolean move() {
        return false;
    }

    @Override
    void setStep() {

    }

    @Override
    boolean setRandomVector(List<Integer> usedVectors) {
        return false;
    }
}
