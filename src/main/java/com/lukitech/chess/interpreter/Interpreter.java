package com.lukitech.chess.interpreter;

import com.lukitech.chess.moves.MoveResult;

public interface Interpreter {
    boolean processMove(String move);
}
