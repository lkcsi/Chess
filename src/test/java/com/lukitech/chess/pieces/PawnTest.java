package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PawnTest extends PieceTest{

    Piece pawn;

    @BeforeEach
    public void setup(){
        super.setup();
        startPosition = new Position(1,2);
        pawn = board.getPieceByPosition(startPosition);
    }

    @Test
    public void singleMove(){
        var destination = new Position(1,3);

        //Blocked own piece
        board.addPiece(new Pawn(Color.WHITE, destination));
        assertMove(pawn, destination, startPosition, MoveResult.NotValidMove);
        board.removePieceFromPosition(destination);

        //Blocked by other piece
        board.addPiece(new Pawn(Color.BLACK, destination));
        assertMove(pawn, destination, startPosition, MoveResult.NotValidMove);
        board.removePieceFromPosition(destination);

        //Moved
        assertMove(pawn, destination, destination, MoveResult.Move);
    }
    @Test
    public void doubleMove(){
        var halfWayPosition = new Position(1, 3);
        var destination = new Position(1,4);

        //Blocked by own piece
        board.addPiece(new Pawn(Color.WHITE, halfWayPosition));
        assertMove(pawn, destination, startPosition, MoveResult.NotValidMove);
        board.removePieceFromPosition(halfWayPosition);

        //Blocked by opponent piece
        board.addPiece(new Pawn(Color.BLACK, halfWayPosition));
        assertMove(pawn, destination, startPosition, MoveResult.NotValidMove);
        board.removePieceFromPosition(halfWayPosition);

        //Moved
        assertMove(pawn, destination, destination, MoveResult.Move);
    }

    @Test
    public void capture(){
        var movePosition = new Position(1,4);
        var capturePosition = new Position(2,5);

        pawn.setPosition(movePosition);

        //No piece to capture
        assertMove(pawn, capturePosition, movePosition, MoveResult.NotValidMove);

        //Friendly piece
        board.addPiece(new Pawn(Color.WHITE, capturePosition));
        assertMove(pawn, capturePosition, movePosition, MoveResult.NotValidMove);
        board.removePieceFromPosition(capturePosition);

        //Capture
        var capturedPawn = board.addPiece(new Pawn(Color.BLACK, capturePosition));
        assertMove(pawn, capturePosition, capturePosition, MoveResult.Move);

        Assertions.assertEquals(false, board.getPieces().contains(capturedPawn));
    }

    @Test
    void pinTest(){

        var blackQueen = board.getPieceByPosition(new Position(4,8));
        var whiteKing = board.getPieceByPosition(new Position(5,1));

        var movePosition = new Position(7,5);
        var pinPosition = new Position(7,4);

        whiteKing.setPosition(new Position(5,4));
        blackQueen.setPosition(new Position(8, 4));
        pawn.setPosition(pinPosition);

        //Allow check
        assertMove(pawn, movePosition, pinPosition, MoveResult.AllowCheck);

        //Remove threat
        board.removePiece(blackQueen);
        assertMove(pawn, movePosition, movePosition, MoveResult.Move);
    }

    @Test
    void enPassant(){
        var enPassantStart = new Position(4,5);
        var enPassantEndPos = new Position(5,6);

        var blackPawnPos = new Position(5,7);
        var jumpPos = new Position(5,5);

        var blackPawn = board.getPieceByPosition(blackPawnPos);

        pawn.setPosition(enPassantStart);

        assertMove(pawn, enPassantEndPos, enPassantStart, MoveResult.NotValidMove);
        board.endTurn();

        assertMove(blackPawn, jumpPos, jumpPos, MoveResult.Move);

        assertMove(pawn, enPassantEndPos, enPassantEndPos, MoveResult.Move);
    }
}
