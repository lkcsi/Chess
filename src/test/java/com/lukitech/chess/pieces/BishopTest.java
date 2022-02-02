package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.board.StandardBoard;
import com.lukitech.chess.board.StandardPieceSet;
import com.lukitech.chess.moves.MoveResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BishopTest {
    private Board board;

    @BeforeEach
    void setup(){
        board = new StandardBoard(new StandardPieceSet());
    }

    @Test
    void move(){
        var startPosition = new Position(3,1);
        var blockPosition = new Position(4,2);
        var movePosition = new Position(6,4);

        var bishop = board.getPieceByPosition(startPosition);

        var moveResult = bishop.move(movePosition);
        Assertions.assertEquals(MoveResult.MoveBlocked, moveResult, moveResult.getMessage());
        Assertions.assertEquals(bishop.getPosition(), startPosition);

        board.removePieceFromPosition(blockPosition);
        moveResult = bishop.move(movePosition);
        Assertions.assertEquals(MoveResult.Move, moveResult, moveResult.getMessage());
        Assertions.assertEquals(bishop.getPosition(), movePosition);

        movePosition = new Position(4,2);
        moveResult = bishop.move(movePosition);
        Assertions.assertEquals(MoveResult.Move, moveResult);
        Assertions.assertEquals(bishop.getPosition(), movePosition);

        movePosition = new Position(2,4);
        moveResult = bishop.move(movePosition);
        Assertions.assertEquals(MoveResult.Move, moveResult);
        Assertions.assertEquals(bishop.getPosition(), movePosition);

        movePosition = new Position(3,3);
        moveResult = bishop.move(movePosition);
        Assertions.assertEquals(MoveResult.Move, moveResult);
        Assertions.assertEquals(bishop.getPosition(), movePosition);
    }

    @Test
    void capture(){
        var startPosition = new Position(3,1);
        var capturePosition = new Position(5,3);
        var bishop = board.getPieceByPosition(startPosition);

        board.removePieceFromPosition(new Position(4,2));
        board.addPiece(new Pawn(Color.BLACK, capturePosition));

        var moveResult = bishop.move(capturePosition);
        Assertions.assertEquals(MoveResult.Capture, moveResult, moveResult.getMessage());
        Assertions.assertEquals(capturePosition, bishop.getPosition());
    }


}
