package com.company;

import com.company.board.ChessBoard;
import com.company.boardBuilder.BoardBuilder;
import com.company.boardBuilder.Director;
import com.company.types.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = Director.createBoard();

        boolean isWhitePick = true;
        Random random = new Random();

        do{
            if (isWhitePick){
               int randomNum = random.nextInt(chessBoard.getChessFigures().size()-1);
               if(chessBoard.getChessFigures().get(randomNum).getSide() == Side.WHITE){
                   chessBoard.getChessFigures().get(randomNum).setChessBoard(chessBoard);
                   chessBoard.getChessFigures().get(randomNum).move();
                   isWhitePick = false;
                   try {
                       TimeUnit.SECONDS.sleep(3);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }else{
                int randomNum = random.nextInt(chessBoard.getChessFigures().size()-1);
                if(chessBoard.getChessFigures().get(randomNum).getSide() == Side.BLACK){
                    chessBoard.getChessFigures().get(randomNum).setChessBoard(chessBoard);
                    chessBoard.getChessFigures().get(randomNum).move();
                    isWhitePick = true;
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }while (!chessBoard.getChessFigures().isEmpty());
    }
}
