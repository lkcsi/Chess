package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.board.StandardBoard;
import com.lukitech.chess.board.StandardPieceSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PawnTest {
    Board board;
    @BeforeEach
    public void setup(){
        board = new StandardBoard(new StandardPieceSet());
    }

    @Test
    public void singleMove(){
        var destination = new Position(1,3);
        var startPosition = new Position(1,2);
        var pawn = board.getPieceByPosition(startPosition);

        //Blocked own piece
        board.addPiece(new Pawn(Color.WHITE, destination));
        var moveResult = pawn.move(destination);
        Assertions.assertEquals(false, moveResult.result);
        Assertions.assertEquals(pawn.getPosition(), startPosition);
        board.removePieceFromPosition(destination);

        //Blocked own piece
        board.addPiece(new Pawn(Color.BLACK, destination));
        moveResult = pawn.move(destination);
        Assertions.assertEquals(false, moveResult.result);
        Assertions.assertEquals(pawn.getPosition(), startPosition);
        board.removePieceFromPosition(destination);

        //Moved
        moveResult = pawn.move(destination);
        Assertions.assertEquals(true, moveResult.result);
        Assertions.assertEquals(pawn.getPosition(), destination);
    }
    @Test
    public void doubleMove(){
        var startPosition = new Position(1,2);
        var halfWayPosition = new Position(1, 3);
        var destination = new Position(1,4);

        var pawn = board.getPieceByPosition(startPosition);

        //Blocked by own piece
        board.addPiece(new Pawn(Color.WHITE, halfWayPosition));
        var moveResult = pawn.move(destination);
        Assertions.assertEquals(false, moveResult.result);
        Assertions.assertEquals(pawn.getPosition(), startPosition);
        board.removePieceFromPosition(halfWayPosition);

        //Blocked by opponent piece
        board.addPiece(new Pawn(Color.BLACK, halfWayPosition));
        moveResult = pawn.move(destination);
        Assertions.assertEquals(false, moveResult.result);
        Assertions.assertEquals(pawn.getPosition(), startPosition);
        board.removePieceFromPosition(halfWayPosition);

        //Moved
        moveResult = pawn.move(destination);
        Assertions.assertEquals(true, moveResult.result);
        Assertions.assertEquals(pawn.getPosition(), destination);
    }

    @Test
    public void capture(){
        var movePosition = new Position(1,4);
        var capturePosition = new Position(2,5);
        var originalPosition = new Position(1,2);

        var pawn = board.getPieceByPosition(originalPosition);
        pawn.move(movePosition);

        board.addPiece(new Pawn(Color.WHITE, capturePosition));
        var moveResult = pawn.move(capturePosition);

        Assertions.assertEquals(false, moveResult.result, moveResult.message);
        Assertions.assertEquals(movePosition, pawn.getPosition());

        board.removePieceFromPosition(capturePosition);
        var capturedPawn = board.addPiece(new Pawn(Color.BLACK, capturePosition));
        moveResult = pawn.move(capturePosition);

        Assertions.assertEquals(true, moveResult.result, moveResult.message);
        Assertions.assertEquals(capturePosition, pawn.getPosition());
        Assertions.assertEquals(false, board.getPieces().contains(capturedPawn));
        Assertions.assertEquals(true, board.getPieces().contains(pawn));
    }

    @Test
    void blockCheck(){

        var blackQueen = board.getPieceByPosition(new Position(4,8));
        var whitePawn = board.getPieceByPosition(new Position(1,2));
        var whiteKing = board.getPieceByPosition(new Position(5,1));

        whiteKing.setPosition(new Position(5,4));
        blackQueen.setPosition(new Position(8, 4));
        whitePawn.setPosition(new Position(7, 4));

        var moveResult = whitePawn.move(new Position(7,5));
        Assertions.assertEquals(false, moveResult.result);

        //Remove threat
        board.removePiece(blackQueen);
        moveResult = whitePawn.move(new Position(7,5));
        Assertions.assertEquals(true, moveResult.result);
    }
}
