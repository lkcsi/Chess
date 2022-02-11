package com.lukitech.chess.moves;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.pieces.Piece;

@FunctionalInterface
public interface SpecialAction{
    void perform();
}
