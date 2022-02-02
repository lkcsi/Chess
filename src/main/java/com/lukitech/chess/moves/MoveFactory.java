package com.lukitech.chess.moves;

import com.lukitech.chess.board.Position;

import java.util.EnumSet;

public class MoveFactory {
    public static Move getDirection(Position position, int colStep, int rowStep, int distance, EnumSet<MoveType> moveTypes){
        var direction = new Move(moveTypes);
        int col = position.getColumn() + colStep;
        int row = position.getRow() + rowStep;

        while(col < 9 && row < 9 && col > 0 && row > 0 && direction.size() < distance){
            direction.addPosition(new Position(col, row));
            col = col + colStep;
            row = row + rowStep;
        }
        return direction;
    }

    public static Move getDirection(Position position, int colStep, int rowStep, EnumSet<MoveType> moveTypes) {
        return getDirection(position, colStep, rowStep, 100, moveTypes);
    }

}
