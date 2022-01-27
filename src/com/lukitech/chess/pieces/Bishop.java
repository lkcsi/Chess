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
   public boolean isLegalMove(Position position) {
      if(position.equals(this.getPosition()))
         return false;

      int deltaRow = Math.abs(this.getPosition().getRow() - position.getRow());
      int deltaCol = Math.abs(this.getPosition().getColumn() - position.getColumn()); 

      if(deltaRow != deltaCol)
         return false;

      return true;
   }
   
}
