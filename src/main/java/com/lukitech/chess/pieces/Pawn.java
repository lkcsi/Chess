package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.moves.*;
import com.lukitech.chess.board.Position;

public class Pawn extends Piece {

   private boolean jumped;

   public Pawn(Color color, Position position) {
      super("Pawn", color, position);
      addMoves();
   }

   public boolean jumped(){
      return jumped;
   }
   public void setJumped(){
      jumped = true;
   }

   @Override
   public void update(){
      jumped = false;
   }

   @Override
   public String getLetter() {
      return "P";
   }

   public void addMoves() {
      int dir = getColor() == Color.BLACK ? -1 : 1;

      var move = new Move(new MoveVector(0, 1 * dir, 1), MoveType.MOVE_ONLY);
      addMove(move);

      move = new Move(new MoveVector(0, 1 * dir, 2), MoveType.MOVE_ONLY);
      move.setSpecialCondition(jumpCondition);
      move.setSpecialAction(jumpAction);
      addMove(move);

      addMove(new Move(new MoveVector(1, 1 * dir, 1), MoveType.CAPTURE_ONLY));
      addMove(new Move(new MoveVector(-1, 1 * dir, 1), MoveType.CAPTURE_ONLY));

      move = new Move(new MoveVector(1, 1 * dir, 1), MoveType.MOVE_ONLY);
      move.setSpecialAction(enPassantAction);
      move.setSpecialCondition(enPassantCondition);

      move = new Move(new MoveVector(-1, 1 * dir, 1), MoveType.MOVE_ONLY);
      move.setSpecialAction(enPassantAction);
      move.setSpecialCondition(enPassantCondition);
   }

   SpecialCondition jumpCondition = new SpecialCondition() {
      @Override
      public boolean check(Piece piece, Board board) {
         return (piece.getPosition().getRow() == 2 && piece.getColor() == Color.WHITE) ||
                 (piece.getPosition().getRow() == 7 && piece.getColor() == Color.BLACK);
      }
   };

   SpecialAction jumpAction = new SpecialAction() {
      @Override
      public void perform(Piece piece, Board board) {
         Pawn pawn = (Pawn) piece;
         pawn.setJumped();
      }
   };

   SpecialCondition enPassantCondition = new SpecialCondition() {
      @Override
      public boolean check(Piece piece, Board board) {
         if(!(piece.getPosition().getRow() == 5 && piece.getColor() == Color.WHITE) ||
                 !(piece.getPosition().getRow() == 4 && piece.getColor() == Color.BLACK))
            return false;

         return (board.getPieces().stream().anyMatch((p) -> {
            Pawn pawn = (Pawn) p;
            return pawn.getPosition().getRow() == piece.getPosition().getRow()
               && Math.abs(pawn.getPosition().getColumn() - piece.getPosition().getColumn()) == 1
               && pawn.jumped();
           }));
      }
   };

   SpecialAction enPassantAction = new SpecialAction() {
      @Override
      public void perform(Piece piece, Board board) {
         var capturedPiece = board.getPieces().stream().filter( (p) -> {
              Pawn pawn = (Pawn) p;
              return pawn.getPosition().getRow() == piece.getPosition().getRow()
                      && Math.abs(pawn.getPosition().getColumn() - piece.getPosition().getColumn()) == 1
                      && pawn.jumped();
           }).findFirst().get();

         board.capture(capturedPiece);
      }
   };
}
