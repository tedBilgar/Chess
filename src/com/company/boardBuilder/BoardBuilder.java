package com.company.boardBuilder;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.figure.ChessFigure;
import com.company.types.Side;

import java.util.HashMap;

public class BoardBuilder implements Builder{
    private Side firstSide;
    private Side secondSide;
    private HashMap<Field, ChessFigure> pawnMap;

    public Side getFirstSide() {
        return firstSide;
    }

    public Side getSecondSide() {
        return secondSide;
    }

    public HashMap<Field, ChessFigure> getPawnMap() {
        return pawnMap;
    }

    public BoardBuilder setFirstSideWHITE(){
        this.firstSide = Side.WHITE;
        this.secondSide = Side.BLACK;
        return this;
    }

    public BoardBuilder setFirstSideBLACK(){
        this.firstSide = Side.BLACK;
        this.secondSide = Side.WHITE;
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
