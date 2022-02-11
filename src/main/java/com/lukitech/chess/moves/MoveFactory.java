package com.lukitech.chess.moves;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class MoveFactory {

    private Board board;
    private Piece piece;

    public MoveFactory(Piece piece, Board board){
        this.piece = piece;
        this.board = board;
    }


    public List<Move> getMoves(int colStep, int rowStep, int range){
        var positions = getPositions(colStep, rowStep, range);
        List<Move> moves = new ArrayList<>();
        positions.forEach(p -> moves.add(new Move(p)));
        return moves;
    }

    public List<Position> getPositions(int colStep, int rowStep, int range){
        var result = new ArrayList<Position>();
        int col = piece.getPosition().getColumn() + colStep;
        int row = piece.getPosition().getRow() + rowStep;
        Piece otherPiece = null;

        while(col < 9 && row < 9 && col > 0 && row > 0 && result.size() < range && otherPiece == null){
            Position position = new Position(col, row);
            otherPiece = board.getPieceByPosition(position);
            if(otherPiece != null && otherPiece.getColor() == piece.getColor())
                break;
            result.add(new Position(col, row));
            col = col + colStep;
            row = row + rowStep;
        }
        return result;
    }
}
