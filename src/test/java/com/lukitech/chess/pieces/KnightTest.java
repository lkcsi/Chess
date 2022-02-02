package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.StandardBoard;
import com.lukitech.chess.board.StandardPieceSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest {
    private Board board;

    @BeforeEach
    void setup(){
        board = new StandardBoard(new StandardPieceSet());
    }

    @Test
    void move(){

    }
}
