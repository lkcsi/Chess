package com.lukitech.chess.moves;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.pieces.Piece;

public interface SpecialCondition {
    boolean check(Piece piece, Board board);
}
