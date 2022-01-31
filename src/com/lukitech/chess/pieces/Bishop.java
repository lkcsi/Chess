package com.lukitech.chess.pieces;

import com.lukitech.chess.board.Position;

public class Bishop extends Piece{

   public Bishop(Color color) {
      super("Bishop", color);
   }

   @Override
   public char getLetter() {
      return 'B';
   }

   @Override
   public MoveResult move(Position newPosition) {
      if(newPosition.equals(this.getPosition()))
         return new MoveResult(false, "Not a move");

      int deltaRow = getPosition().getRow() - newPosition.getRow();
      int deltaCol = getPosition().getColumn() - newPosition.getColumn();

      if(Math.abs(deltaRow) != Math.abs(deltaCol))
         return new MoveResult(false, "Not a valid move");

      int currentRow = getPosition().getRow();
      int currentCol = getPosition().getColumn();

      for(int i = 0; i < Math.abs(deltaRow); i++){
         currentRow = deltaRow < 0 ? currentRow-1 : currentRow+1;
         currentCol = deltaCol < 0 ? currentCol-1 : currentCol+1;

         var nextPosition = new Position(currentCol, currentRow);
         var piece = getBoard().getPieces().stream().filter(p -> p.getPosition().equals(nextPosition)).findAny();
         if(piece.isPresent())
         {
            if(nextPosition != newPosition)
               return new MoveResult(false, "Move blocked");
            if(piece.get() instanceof CheckMateable)
               return new MoveResult(false, "Cannot capture this piece");
            
            return new MoveResult(true, "Capture");
         }
      }

      return super.move(newPosition);
   }
   
}
