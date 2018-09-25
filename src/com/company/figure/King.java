package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.Side;

public class King extends ChessFigure {
    public King(Side side, ChessBoard chessBoard, Field location) {
        super(side, chessBoard, location);
    }

    @Override
    int move() {
        return 0;
    }
}
