package com.lukitech.chess.board;

import com.lukitech.chess.moves.MovePerformer;
import com.lukitech.chess.moves.MoveResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurnTest {

    Board board;
    @BeforeEach
    void setup(){
        board = new Board(new StandardPieceSet());
    }

    @Test
    void changeTurns(){
        MovePerformer movePerformer = new MovePerformer(board);
        var whitePawn = board.getPieceByPosition(new Position(1,2));
        var blackPawn = board.getPieceByPosition(new Position(8,7));

        var moveResult = movePerformer.move(new Position(8,6), blackPawn);
        Assertions.assertEquals(MoveResult.NotYourTurn, moveResult, moveResult.getMessage());

        moveResult = movePerformer.move(new Position(1,3), whitePawn);
        Assertions.assertEquals(MoveResult.Move, moveResult, moveResult.getMessage());

        moveResult = movePerformer.move(new Position(8,6), blackPawn);
        Assertions.assertEquals(MoveResult.Move, moveResult, moveResult.getMessage());
    }
}
