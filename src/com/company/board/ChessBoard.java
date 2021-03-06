package com.company.board;

import com.company.boardBuilder.BoardBuilder;
import com.company.figure.ChessFigure;
import com.company.types.Side;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private Side firstSide;
    private Side secondSide;
    private HashMap<Field, ChessFigure> pawnMap;


    public ChessBoard(BoardBuilder boardBuilder) {
        this.firstSide = boardBuilder.getFirstSide();
        this.secondSide = boardBuilder.getSecondSide();
        this.pawnMap = boardBuilder.getPawnMap();
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

    public Map<Field, ChessFigure> getPawnMap() {
        return pawnMap;
    }


    public ChessFigure getFigureByCoord(int x,int y){
        for(Map.Entry<Field,ChessFigure> entry: pawnMap.entrySet()) {
            if (entry.getKey().getX_coord() == x && entry.getKey().getY_coord() == y){
                return entry.getValue();
            }
        }
        return null;
    }

    public Field getFieldByCoord(int x, int y){
        for(Map.Entry<Field,ChessFigure> entry: pawnMap.entrySet()){
            if (entry.getKey().getX_coord() == x && entry.getKey().getY_coord() == y){
                return entry.getKey();
            }
        }

        return null;
    }

    public Field getFieldByFigure(ChessFigure chessFigure){
        for(Map.Entry<Field,ChessFigure> entry: pawnMap.entrySet()){
            if (entry.getValue() == chessFigure) return entry.getKey();
        }
        return null;
    }
}
