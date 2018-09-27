package com.company.board;

import com.company.boardBuilder.BoardBuilder;
import com.company.figure.ChessFigure;
import com.company.types.Side;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessBoard {
    private List<ChessFigure> chessFigures;

    public ChessBoard(BoardBuilder boardBuilder) {
        this.chessFigures = boardBuilder.getChessFigures();
    }

    public List<ChessFigure> getChessFigures() {
        return chessFigures;
    }

    public ChessFigure getFigureByCoord(int x, int y){
        for (ChessFigure figure : chessFigures) {
            if (figure.getX_coord() == x && figure.getY_coord() == y) return figure;
        }
        return null;
    }
}
