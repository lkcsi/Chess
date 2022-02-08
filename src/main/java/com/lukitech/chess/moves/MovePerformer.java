package com.lukitech.chess.moves;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.pieces.CheckMateable;
import com.lukitech.chess.pieces.Color;
import com.lukitech.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MovePerformer {

    private Board board;

    public MovePerformer(Board board){
        this.board = board;
    }

    public MoveResult move(Position position, Piece piece){
        for(var move : piece.getMoves()) {
            var positions = move.getPositions(piece.getPosition());
            if(!positions.contains(position))
                continue;

            Piece otherPiece = null;
            for(var currentPosition : positions) {
                otherPiece = board.getPieceByPosition(currentPosition);
                if(otherPiece != null) {
                    if(!position.equals(currentPosition))
                        return MoveResult.MoveBlocked;
                    if(otherPiece.getColor() == piece.getColor())
                        return MoveResult.MoveBlocked;
                    if(otherPiece instanceof CheckMateable)
                        return MoveResult.MoveBlocked;
                    if(move.getMoveType() == MoveType.MOVE_ONLY)
                        return MoveResult.MoveBlocked;
                }
                else if(move.getMoveType() == MoveType.CAPTURE_ONLY && position.equals(currentPosition)) {
                        return MoveResult.WrongDirection;
                }

                if(move.getSpecialCondition() != null && !move.getSpecialCondition().check(piece, board))
                    return MoveResult.WrongConditions;

                if(position.equals(currentPosition))
                    break;
                }
                return move(piece, otherPiece, position, move);
            }
        return MoveResult.WrongDirection;
    }


    private MoveResult move(Piece piece, Piece capturedPiece, Position position, Move move){
        var originalPosition = piece.getPosition();
        piece.setPosition(position);
        if(board.inCheck(piece.getColor())) {
            piece.setPosition(originalPosition);
            return MoveResult.AllowCheck;
        }
        if(capturedPiece != null)
            board.capture(capturedPiece);

        if(move.getSpecialAction() != null)
            move.getSpecialAction().perform(piece, board);
        board.endTurn();
        return MoveResult.Move;
    }
}
