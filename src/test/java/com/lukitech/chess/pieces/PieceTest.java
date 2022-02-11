package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.board.StandardPieceSet;
import com.lukitech.chess.moves.MovePerformer;
import com.lukitech.chess.moves.MoveResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public abstract class PieceTest {
    protected Board board;
    protected MovePerformer movePerformer;
    protected Position startPosition;


    public void setup(){
        board = new Board(new StandardPieceSet());
        movePerformer = new MovePerformer(board);
    }

    public void assertMove(Piece piece, Position movePosition, Position expectedPosition, MoveResult expectedResult){

        var moveResult = movePerformer.move(movePosition, piece);
        Assertions.assertEquals(expectedResult, moveResult, moveResult.getMessage());
        Assertions.assertEquals(expectedPosition, piece.getPosition());
    }

    public void assertMove(Piece piece, Position movePosition, MoveResult expectedResult){

        var moveResult = movePerformer.move(movePosition, piece);
        Assertions.assertEquals(expectedResult, moveResult, moveResult.getMessage());
        Assertions.assertEquals(movePosition, piece.getPosition());
    }
}
