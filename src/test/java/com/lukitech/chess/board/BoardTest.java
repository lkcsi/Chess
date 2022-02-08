package com.lukitech.chess.board;

import com.lukitech.chess.pieces.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    Board board;
    @BeforeEach
    public void setup(){
        board = new Board(new StandardPieceSet());
    }

    @Test
    public void checkTest(){
        var blackQueen = board.getPieceByPosition(new Position(4,8));
        var whitePawn = board.getPieceByPosition(new Position(1,2));
        var whiteKing = board.getPieceByPosition(new Position(5,1));

        whiteKing.setPosition(new Position(5,4));
        blackQueen.setPosition(new Position(8, 4));
        whitePawn.setPosition(new Position(7, 4));

        Assertions.assertEquals(false, board.inCheck(Color.WHITE));
        board.removePiece(whitePawn);

        Assertions.assertEquals(true, board.inCheck(Color.WHITE));
    }
}
