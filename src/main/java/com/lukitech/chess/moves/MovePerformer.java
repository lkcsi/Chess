package com.lukitech.chess.moves;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.board.Position;
import com.lukitech.chess.pieces.CheckMateable;
import com.lukitech.chess.pieces.Piece;

public class MovePerformer {
    private Board board;

    public MovePerformer(Board board){
        this.board = board;
    }

    public MoveResult move(Position position, Piece piece){

        if(!yourTurn(piece))
            return MoveResult.NotYourTurn;

        var move = getMove(position, piece);
        var otherPiece = board.getPieceByPosition(position);
        if(move == null)
            return MoveResult.NotValidMove;
        if(blocked(position, piece, otherPiece))
            return MoveResult.NotValidMove;
        if(allowCheck(position, piece, otherPiece))
            return MoveResult.AllowCheck;

        if(otherPiece != null)
            board.capture(otherPiece);

        piece.setPosition(position);
        if(move.getSpecialAction() != null)
            move.getSpecialAction().perform();

        board.endTurn();
        return MoveResult.Move;
    }

    private Move getMove(Position position, Piece piece){
        return piece.getMoves(board).stream().filter(m -> m.getPosition().equals(position)).findFirst().orElse(null);
    }

    public boolean yourTurn(Piece piece){
        return piece.getColor() == board.getColorToMove();
    }

    public boolean blocked(Position position, Piece piece, Piece otherPiece){
        if (otherPiece != null) {
            if (otherPiece.getColor() == piece.getColor() || otherPiece instanceof CheckMateable){
                return true;
            }
        }
        return false;
    }

    private boolean allowCheck(Position position, Piece piece, Piece otherPiece){
        var result = false;
        var originalPosition = piece.getPosition();
        piece.setPosition(position);

        if(otherPiece != null)
            board.removePiece(otherPiece);

        result = board.inCheck(piece.getColor());

        piece.setPosition(originalPosition);
        if(otherPiece != null)
            board.addPiece(otherPiece);

        return result;
    }
}
