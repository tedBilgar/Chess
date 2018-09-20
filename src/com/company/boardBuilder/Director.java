package com.company.boardBuilder;

import com.company.board.ChessBoard;

public class Director {
    public static ChessBoard createBoard(){
        return new BoardBuilder().setFirstSide("Black").setSecondSide("White").setPawnMap().build();
    }
}
