package com.company;

import com.company.board.ChessBoard;
import com.company.boardBuilder.BoardBuilder;
import com.company.boardBuilder.Director;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = Director.createBoard();
        System.out.println(new Random().nextInt(1) + 1);
    }
}
