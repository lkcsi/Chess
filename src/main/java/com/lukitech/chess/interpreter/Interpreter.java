package com.lukitech.chess.interpreter;

import com.lukitech.chess.pieces.MoveResult;

public interface Interpreter {
    MoveResult processMove(String move);
}
