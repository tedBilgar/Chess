package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;

public abstract class ChessFigure {
    protected Side side;
    protected ChessBoard chessBoard;
    protected Field location;
    protected ChessType chessType;

    public ChessFigure(Side side, ChessBoard chessBoard, Field location) {
        this.side = side;
        this.chessBoard = chessBoard;
        this.location = location;
    }

    abstract boolean isAvailable();
    abstract int move();
}
