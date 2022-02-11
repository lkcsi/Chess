package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;
import com.lukitech.chess.moves.MoveResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingTest extends PieceTest{

    Piece king;

    @BeforeEach
    public void setup() {
        super.setup();
        startPosition = new Position(5,1);
        king = board.getPieceByPosition(startPosition);
    }


    @Test
    public void singleMove(){
        board.removePieceFromPosition(new Position(5, 2));

        assertMove(king, new Position(5,2), MoveResult.Move);
        board.endTurn();

        assertMove(king, new Position(5,3), MoveResult.Move);
        board.endTurn();

        //Diagonal
        assertMove(king, new Position(4,4), MoveResult.Move);
        board.endTurn();

        assertMove(king, new Position(5,5), MoveResult.Move);
        board.endTurn();

        assertMove(king, new Position(6,4), MoveResult.Move);
        board.endTurn();

        assertMove(king, new Position(5,3), MoveResult.Move);
        board.endTurn();

        //Line
        assertMove(king, new Position(5,4), MoveResult.Move);
        board.endTurn();

        assertMove(king, new Position(4,4), MoveResult.Move);
        board.endTurn();

        assertMove(king, new Position(4,3), MoveResult.Move);
        board.endTurn();

        assertMove(king, new Position(5,3), MoveResult.Move);
        board.endTurn();
    }

    @Test
    void checkMove(){
        king.setPosition(new Position(5,5));
        assertMove(king, new Position(5,6), king.getPosition(), MoveResult.AllowCheck);
    }

    @Test
    void enemyKing(){
        var blackKing = board.getPieceByPosition(new Position(5,8));
        blackKing.setPosition(new Position(5,6));

        king.setPosition(new Position(5,4));

        assertMove(king, new Position(5,5), king.getPosition(), MoveResult.AllowCheck);
    }
}
