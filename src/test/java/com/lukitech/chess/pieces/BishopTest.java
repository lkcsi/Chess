package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BishopTest extends PieceTest{
    Piece bishop;
    @BeforeEach
    public void setup(){
        super.setup();
        startPosition = new Position(3,1);
        bishop = board.getPieceByPosition(startPosition);
    }

    @Test
    void move(){
        var blockPosition = new Position(4,2);
        var movePosition = new Position(6,4);

        assertMove(bishop, movePosition, startPosition, MoveResult.MoveBlocked);

        board.removePieceFromPosition(blockPosition);
        assertMove(bishop, movePosition, movePosition, MoveResult.Move);

        movePosition = new Position(4,2);
        assertMove(bishop, movePosition, movePosition, MoveResult.Move);

        movePosition = new Position(2,4);
        assertMove(bishop, movePosition, movePosition, MoveResult.Move);

        movePosition = new Position(3,3);
        assertMove(bishop, movePosition, movePosition, MoveResult.Move);
    }

    @Test
    void capture(){
        var capturePosition = new Position(5,3);

        board.removePieceFromPosition(new Position(4,2));
        board.addPiece(new Pawn(Color.BLACK, capturePosition));

        assertMove(bishop, capturePosition, capturePosition, MoveResult.Move);
    }


}
