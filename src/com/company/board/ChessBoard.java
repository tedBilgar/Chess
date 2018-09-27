package com.company.board;

import com.company.boardBuilder.BoardBuilder;
import com.company.figure.ChessFigure;
import com.company.types.Side;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessBoard {
    private Side firstSide;
    private Side secondSide;
    private List<ChessFigure> pawnList;

    public ChessBoard(BoardBuilder boardBuilder) {
        this.firstSide = boardBuilder.getFirstSide();
        this.secondSide = boardBuilder.getSecondSide();
        this.pawnList = boardBuilder.getPawnList();
    }


    public Side getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(Side firstSide) {
        this.firstSide = firstSide;
    }

    public Side getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(Side secondSide) {
        this.secondSide = secondSide;
    }

    public List<ChessFigure> getPawnList() {
        return pawnList;
    }

    public ChessFigure getFigureByCoord(int x, int y){
        for (ChessFigure figure : pawnList) {
            if (figure.getX_coord() == x && figure.getY_coord() == y) return figure;
        }
        return null;
    }
}
