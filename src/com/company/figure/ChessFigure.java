package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.ChessType;
import com.company.types.Side;

public abstract class ChessFigure {
    protected Side side;
    protected ChessBoard chessBoard;
    protected Field location;

    protected int minStep;
    protected int maxStep;
    protected int upperLeft;
    protected int upperCenter;
    protected int upperRight;
    protected int currentLeft;
    protected int currentRight;
    protected int bottomLeft;
    protected int bottomCenter;
    protected int bottonRight;

    public ChessFigure(Side side, ChessBoard chessBoard, Field location) {
        this.side = side;
        this.chessBoard = chessBoard;
        this.location = location;
    }
    abstract int move();
}
