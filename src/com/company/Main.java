package com.company;

import com.company.board.ChessBoard;
import com.company.boardBuilder.BoardBuilder;
import com.company.boardBuilder.Director;

public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = Director.createBoard();
    }
}
