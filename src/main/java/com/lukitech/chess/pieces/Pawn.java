package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Board;
import com.lukitech.chess.moves.*;
import com.lukitech.chess.board.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

   private boolean jumped;

   public Pawn(Color color, Position position) {
      super("Pawn", color, position);
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
   public List<Move> getMoves(Board board) {
      int rowDir = getColor() == Color.BLACK ? -1 : 1;
      int rankPos = getColor() == Color.BLACK ? 7 : 2;
      List<Move> moves = new ArrayList<>();

      addSingleMove(board, rowDir, moves);
      addJumpMove(board, rowDir, rankPos, moves);
      addCaptureMove(board, -1, rowDir, moves);
      addCaptureMove(board, 1, rowDir, moves);
      addEnPassantMove(board,-1, rowDir, rankPos, moves);
      addEnPassantMove(board,1, rowDir, rankPos, moves);
      return  moves;
   }

   @Override
   public String getLetter() {
      return "P";
   }


   private void addSingleMove(Board board, int rowDir, List<Move> moves){
         int row = getPosition().getRow() + rowDir;
         int col = getPosition().getColumn();

         if(row < 1 || row > 8 || col < 1 || col > 8)
            return;

         var movePosition = new Position(col, row);
         var move = new Move(movePosition);
         if(board.getPieceByPosition(movePosition) == null)
            moves.add(move);
   }

   private void addJumpMove(Board board, int rowDir, int rankPos, List<Move> moves){
       if(this.getPosition().getRow() == rankPos)
       {
          int row = getPosition().getRow() + (2 * rowDir);
          int col = getPosition().getColumn();

          if(row < 1 || row > 8 || col < 1 || col > 8)
             return;

          var movePosition1 = new Position(col, row);
          var movePosition2 = new Position(col, row - rowDir);
          var otherPiece1 = board.getPieceByPosition(movePosition1);
          var otherPiece2 = board.getPieceByPosition(movePosition2);

          if(otherPiece1 != null || otherPiece2 != null)
             return;

          var move = new Move(movePosition1);
          move.setSpecialAction(() -> {
             this.setJumped();
          });
          moves.add(move);
       }
   }

   private void addEnPassantMove(Board board, int colDir, int rowDir, int rankPos, List<Move> moves){
      if(!(getPosition().getRow() == (rankPos + (rowDir*3))))
         return;

      var enPassantPiece = board.getPieces().stream().filter((p) -> p.getPosition().getRow() == getPosition().getRow()
              && Math.abs(p.getPosition().getColumn() - getPosition().getColumn()) == 1
              && p instanceof Pawn).filter(p -> ((Pawn)p).jumped()).findFirst().orElse(null);

      if(enPassantPiece == null)
         return;

      int row = getPosition().getRow() + rowDir;
      int col = getPosition().getColumn() + colDir;

      if(row < 1 || row > 8 || col < 1 || col > 8)
         return;

      var position = new Position(col, row);
      if(board.getPieceByPosition(position) != null)
         return;

      var move = new Move(position);
      move.setSpecialAction(() -> {
         board.capture(enPassantPiece);
      });

      moves.add(move);
   }

   private void addCaptureMove(Board board, int colDir, int rowDir, List<Move> moves){
      int row = getPosition().getRow() + rowDir;
      int col = getPosition().getColumn() + colDir;

      if(row < 1 || row > 8 || col < 1 || col > 8)
         return;
      var capturePosition1 = new Position(col, row);
      if(board.getPieceByPosition(capturePosition1) == null)
         return;

      moves.add(new Move(capturePosition1));
   }
}
