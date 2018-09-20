package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;

public class Pawn extends ChessFigure {
    public Pawn(String side, ChessBoard chessBoard, Field location) {
        super(side,chessBoard,location);
        this.chessType = ChessType.PAWN;
    }

    @Override
    public boolean isAvailable() {
        boolean isAvailable = false;

        if (chessBoard.isFreeField(location.getX_coord(),location.getY_coord() + 1) || ) isAvailable = true;
        else isAvailable = false;

        return isAvailable;
    }

    @Override
    public int move() {

        return 0;
    }
}
