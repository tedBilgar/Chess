package com.company.boardBuilder;

import com.company.board.ChessBoard;
import com.company.figure.ChessFigure;
import com.company.figure.Elephant;
import com.company.types.Side;

import java.util.LinkedList;
import java.util.List;

public class BoardBuilder implements Builder{
    private List<ChessFigure> chessFigures;
    private ChessBoard chessBoard;

    public List<ChessFigure> getChessFigures() {
        return chessFigures;
    }

    public BoardBuilder setChessFigures(){
        //TODO
        chessFigures = new LinkedList<>();
        for(int i = 0; i<4;i++){
            chessFigures.add(new Elephant(Side.WHITE,chessBoard,3+i,1));
            System.out.println("white is done");
        }
        for (int i = 0;i<4;i++){
            chessFigures.add(new Elephant(Side.BLACK,chessBoard,3+i,8));
            System.out.println("black is done");
        }
        return this;
    }
    public ChessBoard build(){
        chessBoard = new ChessBoard(this);
        return chessBoard;
    }

}
