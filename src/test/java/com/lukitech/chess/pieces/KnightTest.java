package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest extends PieceTest{

    Piece knight;

    @BeforeEach
    public void setup(){
        super.setup();
        startPosition = new Position(2,1);
        knight = board.getPieceByPosition(startPosition);
    }

    @Test
    void move(){
        var movePosition1 = new Position(3,3);
        var movePosition2 = new Position(1,3);

        //Blocked
        var pawn = new Pawn(Color.WHITE, movePosition1);
        board.addPiece(pawn);
        assertMove(knight, movePosition1, startPosition, MoveResult.NotValidMove);

        //Move
        board.removePieceFromPosition(movePosition1);
        assertMove(knight, movePosition1, movePosition1, MoveResult.Move);
        board.endTurn();

        assertMove(knight, startPosition, startPosition, MoveResult.Move);
        board.endTurn();

        assertMove(knight, movePosition2, movePosition2, MoveResult.Move);
    }

    @Test
    void capture(){
        var capturePosition = new Position(3,3);
        var piece = board.addPiece(new Pawn(Color.BLACK, capturePosition));

        assertMove(knight, capturePosition, capturePosition, MoveResult.Move);
        Assertions.assertEquals(false, board.getPieces().contains(piece));
    }
}
