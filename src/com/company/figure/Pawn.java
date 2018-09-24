package com.company.figure;

import com.company.board.ChessBoard;
import com.company.board.Field;
import com.company.types.ChessType;
import com.company.types.Side;

import java.util.Random;

public class Pawn extends ChessFigure {
    public Pawn(Side side, ChessBoard chessBoard, Field location) {
        super(side,chessBoard,location);
    }

    @Override
    public boolean isAvailable() {
        boolean isAvailable = false;

        if (chessBoard.getFigureByCoord(location.getX_coord(),location.getY_coord() + 1) == null
                || (chessBoard.getFigureByCoord(location.getX_coord(),location.getY_coord() + 1).side != this.side)
                || (chessBoard.getFigureByCoord())) isAvailable = true;
        else isAvailable = false;

        return isAvailable;
    }

    @Override
    public int move() {
        boolean isChanged = false;

        Random random = new Random();
        int a = random.nextInt(2);
        if (a == 0){
            if (chessBoard.getFigureByCoord(location.getX_coord(),location.getY_coord() + 1) == null
                    || chessBoard.getFigureByCoord(location.getX_coord(),location.getY_coord()+1).side != this.side) {
                location.setY_coord(location.getY_coord() + 1);
                isChanged = true;
            }
        }
        return 0;
    }

    public int kill(){

    }
}
