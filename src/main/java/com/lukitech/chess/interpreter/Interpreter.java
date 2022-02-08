package com.lukitech.chess.interpreter;

import com.lukitech.chess.board.Position;
import com.lukitech.chess.pieces.Piece;

public interface Interpreter {
    boolean processMove(String move);
    Piece getPiece();
    Position getPosition();
}
