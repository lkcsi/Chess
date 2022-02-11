package com.lukitech.chess.interpreter;

import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveResult;
import com.lukitech.chess.pieces.Piece;

public interface Interpreter {
    MoveResult move(String move);
    Piece getPiece();
    Position getPosition();
}
