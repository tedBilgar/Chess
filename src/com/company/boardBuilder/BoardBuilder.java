package com.company.boardBuilder;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.figure.ChessFigure;

import java.util.HashMap;
import java.util.Map;

public class BoardBuilder {
    private String firstSide;
    private String secondSide;
    private HashMap<Field, ChessFigure> pawnMap;

    public String getFirstSide() {
        return firstSide;
    }

    public String getSecondSide() {
        return secondSide;
    }

    public HashMap<Field, ChessFigure> getPawnMap() {
        return pawnMap;
    }

    public BoardBuilder setFirstSide(String firstSide){
        this.firstSide = firstSide;
        return this;
    }

    public BoardBuilder setSecondSide(String secondSide){
        this.secondSide = secondSide;
        return this;
    }

    public BoardBuilder setPawnMap(){
        pawnMap = new HashMap<>();
        for(int i = 0; i<8;i++){
            for (int j = 0; j<8;j++){
                pawnMap.put(new Field(i,j),null);
            }
        }
        return this;
    }
    public ChessBoard build(){
        return new ChessBoard(this);
    }

}
