package com.lukitech.chess.moves;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.pieces.Piece;

@FunctionalInterface
public interface MoveCheck {
    boolean valid(Piece piece, Position direction, Board board);
}
