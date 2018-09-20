package com.company.board;

import com.company.boardBuilder.BoardBuilder;
import com.company.figure.ChessFigure;
import com.company.figure.Pawn;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private String firstSide;
    private String secondSide;
    private HashMap<Field, ChessFigure> pawnMap;


    public ChessBoard(BoardBuilder boardBuilder) {
        this.firstSide = boardBuilder.getFirstSide();
        this.secondSide = boardBuilder.getSecondSide();
        this.pawnMap = boardBuilder.getPawnMap();
    }

    public ChessBoard(String firstSide, String secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }


    public String getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(String firstSide) {
        this.firstSide = firstSide;
    }

    public String getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(String secondSide) {
        this.secondSide = secondSide;
    }

    public Map<Field, ChessFigure> getPawnMap() {
        return pawnMap;
    }
    
    public boolean isFreeField(int x,int y){

        boolean isFree = false;

        for (Map.Entry<Field, ChessFigure> entry: pawnMap.entrySet()) {
            if (entry.getKey().getX_coord() == x && entry.getKey().getY_coord() == y || entry.getValue().){
                if (entry.getValue() == null) isFree = false;
                else isFree = true;
            }
        }
        return  isFree;
    }
}
