package com.company.boardBuilder;

import com.company.board.ChessBoard;
import com.company.figure.Side;

public class Director {
    public static ChessBoard createBoard(){
        return new BoardBuilder().setFirstSideBLACK().setPawnMap().build();
    }
}
