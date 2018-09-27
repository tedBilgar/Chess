package com.company.boardBuilder;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.figure.ChessFigure;
import com.company.types.Side;

import java.util.HashMap;
import java.util.List;

public class BoardBuilder implements Builder{
    private Side firstSide;
    private Side secondSide;
    private List<ChessFigure> pawnList;

    public Side getFirstSide() {
        return firstSide;
    }

    public Side getSecondSide() {
        return secondSide;
    }

    public List<ChessFigure> getPawnList() {
        return pawnList;
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

    public BoardBuilder setPawnList(){
        //TODO
        return this;
    }
    public ChessBoard build(){
        return new ChessBoard(this);
    }

}
